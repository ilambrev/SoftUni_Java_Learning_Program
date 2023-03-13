package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.exam.models.dto.PassengerCreateDTO;
import softuni.exam.models.dto.PassengerExportDTO;
import softuni.exam.models.entity.Passenger;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.util.DataFromFile;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static softuni.exam.constants.FilePaths.PASSENGERS_JSON_PATH;

@Service
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;
    private final TownRepository townRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;

    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ModelMapper passengerExportMapper;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository, TownRepository townRepository,
                                DataFromFile dataFromFile, ValidationUtil validationUtil, Gson gson,
                                @Qualifier("modelMapper") ModelMapper modelMapper,
                                @Qualifier("passengerExportMapper") ModelMapper passengerExportMapper) {
        this.passengerRepository = passengerRepository;
        this.townRepository = townRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.passengerExportMapper = passengerExportMapper;
    }

    @Override
    public boolean areImported() {
        return this.passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return this.dataFromFile.read(PASSENGERS_JSON_PATH);
    }

    @Override
    public String importPassengers() throws IOException {

        StringBuilder messages = new StringBuilder();

        PassengerCreateDTO[] passengerDTOs = this.gson.fromJson(readPassengersFileContent(), PassengerCreateDTO[].class);

        for (PassengerCreateDTO passengerDTO : passengerDTOs) {

            if (this.validationUtil.isValid(passengerDTO)) {

                Optional<Passenger> optionalPassenger = this.passengerRepository.findByEmail(passengerDTO.getEmail());

                Optional<Town> optionalTown = this.townRepository.findByName(passengerDTO.getTown());

                if (optionalPassenger.isEmpty() && optionalTown.isPresent()) {

                    Town town = optionalTown.get();
                    Passenger passenger = this.modelMapper.map(passengerDTO, Passenger.class);
                    passenger.setTown(town);
                    messages.append(String.format("Successfully imported Passenger %s - %s",
                            passenger.getLastName(), passenger.getEmail())).append(System.lineSeparator());

                    this.passengerRepository.saveAndFlush(passenger);

                } else {
                    messages.append("Invalid Passenger").append(System.lineSeparator());
                }
            } else {
                messages.append("Invalid Passenger").append(System.lineSeparator());
            }
        }

        return messages.toString().trim();
    }

    @Override
    @Transactional
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {

        StringBuilder passengersInfo = new StringBuilder();

        List<PassengerExportDTO> passengers = this.passengerRepository.findByTicketsNumber().stream()
                .map(p -> this.passengerExportMapper.map(p, PassengerExportDTO.class)).toList();

        passengers.forEach(p -> passengersInfo.append(p.toString()).append(System.lineSeparator()));

        return passengersInfo.toString().trim();
    }

}