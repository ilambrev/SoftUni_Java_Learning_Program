package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CityCreateDTO;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;
import softuni.exam.util.DataFromFile;
import softuni.exam.util.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;

import static softuni.exam.constants.FilePaths.CITIES_JSON_PATH;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;

    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, CountryRepository countryRepository, DataFromFile dataFromFile, ValidationUtil validationUtil, Gson gson, ModelMapper modelMapper) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return this.dataFromFile.read(CITIES_JSON_PATH);
    }

    @Override
    public String importCities() throws IOException {

        StringBuilder messages = new StringBuilder();

        Set<ConstraintViolation<CityCreateDTO>> violations;

        CityCreateDTO[] cityDTOs= this.gson.fromJson(readCitiesFileContent(), CityCreateDTO[].class);

        for (CityCreateDTO cityDTO : cityDTOs) {
            violations = this.validationUtil.violation(cityDTO);

            if (violations.isEmpty()) {

                Optional<City> cityOptional = this.cityRepository.findByCityName(cityDTO.getCityName());
                Optional<Country> countryOptional = this.countryRepository.findById(cityDTO.getCountry());

                if(cityOptional.isEmpty() && countryOptional.isPresent()) {

                        Country country = countryOptional.get();
                        City city = this.modelMapper.map(cityDTO, City.class);
                        city.setCountry(country);

                        this.cityRepository.saveAndFlush(city);
                        messages.append(String.format("Successfully imported city %s - %s", cityDTO.getCityName(), cityDTO.getPopulation()))
                                .append(System.lineSeparator());

                } else {
                    messages.append("Invalid city").append(System.lineSeparator());
                }
            } else {
                messages.append("Invalid city").append(System.lineSeparator());
            }
        }

        return messages.toString().trim();
    }

}