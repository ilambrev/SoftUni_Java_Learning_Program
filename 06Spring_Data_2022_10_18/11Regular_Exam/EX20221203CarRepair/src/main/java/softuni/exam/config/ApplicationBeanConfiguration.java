package softuni.exam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.exam.models.dto.TaskCreateDTO;
import softuni.exam.models.entity.Task;

import java.time.LocalDateTime;
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

        Converter<String, LocalDateTime> stringToDateTime = new AbstractConverter<>() {
            @Override
            protected LocalDateTime convert(String source) {
                return LocalDateTime.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }
        };

        PropertyMap<TaskCreateDTO, Task> taskMap = new PropertyMap<>() {
            @Override
            protected void configure() {
                using(stringToDateTime).map(source.getDate(), destination.getDate());
            }
        };

        modelMapper.addMappings(taskMap);

        return modelMapper;
    }

}