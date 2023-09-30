package softuni.exam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.exam.models.dto.AstronomerImportDTO;
import softuni.exam.models.entity.AstronomerEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();

        Converter<String, LocalDate> stringToDate = new AbstractConverter<String, LocalDate>() {
            @Override
            protected LocalDate convert(String source) {
                return LocalDate.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
        };

        PropertyMap<AstronomerImportDTO, AstronomerEntity> taskMap = new PropertyMap<AstronomerImportDTO, AstronomerEntity>() {
            @Override
            protected void configure() {
                using(stringToDate).map(source.getBirthday(), destination.getBirthday());
            }
        };

        modelMapper.addMappings(taskMap);

        return modelMapper;
    }

}