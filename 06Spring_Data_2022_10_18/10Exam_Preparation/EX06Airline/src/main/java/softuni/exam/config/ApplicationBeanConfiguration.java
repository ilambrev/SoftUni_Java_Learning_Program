package softuni.exam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.exam.models.dto.PassengerExportDTO;
import softuni.exam.models.dto.TicketCreateDTO;
import softuni.exam.models.entity.Passenger;
import softuni.exam.models.entity.Ticket;

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

    @Bean(name = "ticketMapper")
    public ModelMapper ticketMapper() {

        ModelMapper modelMapper = new ModelMapper();

        Converter<String, LocalDateTime> stringToDateTime = new AbstractConverter<>() {

            @Override
            protected LocalDateTime convert(String source) {
                return LocalDateTime.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }
        };

        PropertyMap<TicketCreateDTO, Ticket> ticketMap = new PropertyMap<>() {

            @Override
            protected void configure() {
                using(stringToDateTime).map(source.getTakeOff(), destination.getTakeOff());
            }
        };

        modelMapper.addMappings(ticketMap);

        return modelMapper;
    }

    @Bean(name = "passengerExportMapper")
    public ModelMapper passengerExportMapper() {

        ModelMapper modelMapper = new ModelMapper();

        Converter<Set<Ticket>, Integer> mapSize = new AbstractConverter<>() {

            @Override
            protected Integer convert(Set<Ticket> source) {
                return source.size();
            }

        };

        PropertyMap<Passenger, PassengerExportDTO> passengerMap = new PropertyMap<>() {

            @Override
            protected void configure() {
                using(mapSize).map(source.getTickets(), destination.getTicketsCount());
            }
        };

        modelMapper.addMappings(passengerMap);

        return modelMapper;
    }

}