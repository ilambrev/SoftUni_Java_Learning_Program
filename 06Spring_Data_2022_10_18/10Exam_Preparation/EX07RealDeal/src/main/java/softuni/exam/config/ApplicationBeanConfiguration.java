package softuni.exam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.exam.models.dto.CarCreateDTO;
import softuni.exam.models.dto.CarExportDTO;
import softuni.exam.models.dto.OfferCreateDTO;
import softuni.exam.models.dto.PictureCreateDTO;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Offer;
import softuni.exam.models.entity.Picture;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    @Bean(name = "modelMapper")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean(name = "carModelMapper")
    public ModelMapper carModelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        Converter<String, LocalDate> stringToDate = new AbstractConverter<>() {
            @Override
            protected LocalDate convert(String source) {
                return LocalDate.parse(source, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
        };

        PropertyMap<CarCreateDTO, Car> carMap = new PropertyMap<>() {
            @Override
            protected void configure() {
                using(stringToDate).map(source.getRegisteredOn(), destination.getRegisteredOn());
            }
        };

        modelMapper.addMappings(carMap);

        return modelMapper;
    }

    @Bean(name = "pictureModelMapper")
    public ModelMapper pictureModelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        Converter<String, LocalDateTime> stringToDateTime = new AbstractConverter<>() {
            @Override
            protected LocalDateTime convert(String source) {
                return LocalDateTime.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }
        };

        PropertyMap<PictureCreateDTO, Picture> pictureMap = new PropertyMap<>() {
            @Override
            protected void configure() {
                using(stringToDateTime).map(source.getDateAndTime(), destination.getDateAndTime());
            }
        };

        modelMapper.addMappings(pictureMap);

        return modelMapper;
    }

    @Bean(name = "offerModelMapper")
    public ModelMapper offerModelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        Converter<String, LocalDateTime> stringToDateTime = new AbstractConverter<>() {
            @Override
            protected LocalDateTime convert(String source) {
                return LocalDateTime.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }
        };

        PropertyMap<OfferCreateDTO, Offer> pictureMap = new PropertyMap<>() {
            @Override
            protected void configure() {
                using(stringToDateTime).map(source.getAddedOn(), destination.getAddedOn());
            }
        };

        modelMapper.addMappings(pictureMap);

        return modelMapper;
    }

    @Bean(name = "carExportModelMapper")
    public ModelMapper carExportModelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        Converter<Set<Car>, Integer> setSizeToNumber = new AbstractConverter<>() {
            @Override
            protected Integer convert(Set<Car> source) {
                return source.size();
            }
        };

        PropertyMap<Car, CarExportDTO> carExportMap = new PropertyMap<>() {
            @Override
            protected void configure() {
                using(setSizeToNumber).map(source.getPictures(), destination.getCountOfPictures());
            }
        };

        modelMapper.addMappings(carExportMap);

        return modelMapper;
    }

}