package softuni.exam.service.impl;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForecastCreateDTO;
import softuni.exam.models.dto.ForecastExportDTO;
import softuni.exam.models.dto.ForecastsDTO;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.ForecastService;
import softuni.exam.util.DataFromFile;
import softuni.exam.util.ValidationUtil;

import javax.validation.ConstraintViolation;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalTime;
import java.util.*;

import static softuni.exam.constants.FilePaths.FORECASTS_XML_PATH;

@Service
public class ForecastServiceImpl implements ForecastService {

    private final ForecastRepository forecastRepository;
    private final CityRepository cityRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;

    @Autowired
    public ForecastServiceImpl(ForecastRepository forecastRepository, CityRepository cityRepository, DataFromFile dataFromFile, ValidationUtil validationUtil) {
        this.forecastRepository = forecastRepository;
        this.cityRepository = cityRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return this.dataFromFile.read(FORECASTS_XML_PATH);
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {

        ModelMapper modelMapper = new ModelMapper();

        Converter<String, LocalTime> time = new AbstractConverter<>() {
            @Override
            protected LocalTime convert(String source) {
                return LocalTime.parse(source);

            }
        };

        PropertyMap<ForecastCreateDTO, Forecast> forecastMap = new PropertyMap<>() {
            @Override
            protected void configure() {
                using(time).map(source.getSunrise(), destination.getSunrise());
                using(time).map(source.getSunset(), destination.getSunset());
            }
        };

        modelMapper.addMappings(forecastMap);

        StringBuilder messages = new StringBuilder();

        Set<ConstraintViolation<ForecastCreateDTO>> violations;

        JAXBContext jaxbContext = JAXBContext.newInstance(ForecastsDTO.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader reader = new StringReader(readForecastsFromFile());

        ForecastsDTO forecastsDTO = (ForecastsDTO) unmarshaller.unmarshal(reader);

        for (ForecastCreateDTO forecastDTO : forecastsDTO.getForecasts()) {

            violations = this.validationUtil.violation(forecastDTO);

            if (violations.isEmpty()) {

                Optional<City> cityOptional = this.cityRepository.findById(forecastDTO.getCity());

                if (cityOptional.isPresent()) {

                    Optional<Forecast> forecastOptional =
                            this.forecastRepository.findByCityAndDayOfWeek(cityOptional.get(), forecastDTO.getDayOfWeek());

                    if (forecastOptional.isEmpty()) {

                        Forecast forecast = modelMapper.map(forecastDTO, Forecast.class);

                        forecast.setCity(cityOptional.get());

                        this.forecastRepository.saveAndFlush(forecast);
                        messages.append(String.format("Successfully import forecast %s - %.2f",
                                forecastDTO.getDayOfWeek(), forecastDTO.getMaxTemperature())).append(System.lineSeparator());
                    } else {
                        messages.append("Invalid forecast").append(System.lineSeparator());
                    }
                } else {
                    messages.append("Invalid forecast").append(System.lineSeparator());
                }

            } else {
                messages.append("Invalid forecast").append(System.lineSeparator());
            }
        }

        return messages.toString().trim();
    }

    @Override
    public String exportForecasts() {

        ModelMapper modelMapper = new ModelMapper();

        StringBuilder forecastsData = new StringBuilder();

        Converter<City, String> name = new AbstractConverter<>() {
            @Override
            protected String convert(City source) {
                return source.getCityName();
            }
        };

        PropertyMap<Forecast, ForecastExportDTO> forecastExportMap = new PropertyMap<>() {
            @Override
            protected void configure() {
                using(name).map(source.getCity(), destination.getCityName());
            }
        };

        modelMapper.addMappings(forecastExportMap);

        List<Forecast> forecasts = this.forecastRepository.findForecastByCityPopulationAndDay();

        List<ForecastExportDTO> forecastDTOs = forecasts.stream()
                .map(f -> modelMapper.map(f, ForecastExportDTO.class)).toList();

        forecastDTOs.forEach(f -> forecastsData.append(f.toString()).append(System.lineSeparator()));

        return forecastsData.toString().trim();
    }

}