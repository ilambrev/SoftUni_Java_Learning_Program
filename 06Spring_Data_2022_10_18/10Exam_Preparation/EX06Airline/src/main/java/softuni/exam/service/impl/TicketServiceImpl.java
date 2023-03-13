package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TicketCreateDTO;
import softuni.exam.models.dto.TicketsDTO;
import softuni.exam.models.entity.Passenger;
import softuni.exam.models.entity.Plane;
import softuni.exam.models.entity.Ticket;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.repository.TicketRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TicketService;
import softuni.exam.util.DataFromFile;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Optional;

import static softuni.exam.constants.FilePaths.TICKETS_XML_PATH;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final TownRepository townRepository;
    private final PassengerRepository passengerRepository;
    private final PlaneRepository planeRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    private final ModelMapper ticketMapper;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, TownRepository townRepository, PassengerRepository passengerRepository,
                             PlaneRepository planeRepository, DataFromFile dataFromFile, ValidationUtil validationUtil,
                             XmlParser xmlParser, @Qualifier("ticketMapper") ModelMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.townRepository = townRepository;
        this.passengerRepository = passengerRepository;
        this.planeRepository = planeRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.ticketMapper = ticketMapper;
    }

    @Override
    public boolean areImported() {
        return this.ticketRepository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return this.dataFromFile.read(TICKETS_XML_PATH);
    }

    @Override
    public String importTickets() throws IOException, JAXBException {

        StringBuilder messages = new StringBuilder();

        TicketsDTO ticketDTOs = this.xmlParser.parseXML(TicketsDTO.class, readTicketsFileContent());

        for (TicketCreateDTO ticketDTO : ticketDTOs.getTickets()) {

            if (this.validationUtil.isValid(ticketDTO)) {

                Optional<Ticket> optionalTicket = this.ticketRepository.findBySerialNumber(ticketDTO.getSerialNumber());
                Optional<Town> optionalFromTown = this.townRepository.findByName(ticketDTO.getFromTown().getName());
                Optional<Town> optionalToTown = this.townRepository.findByName(ticketDTO.getToTown().getName());
                Optional<Passenger> optionalPassenger = this.passengerRepository.findByEmail(ticketDTO.getPassenger().getEmail());
                Optional<Plane> optionalPlane = this.planeRepository.findByRegisterNumber(ticketDTO.getPlane().getRegisterNumber());

                if (optionalTicket.isEmpty() && optionalFromTown.isPresent() && optionalToTown.isPresent() &&
                        optionalPassenger.isPresent() && optionalPlane.isPresent()) {

                    Town fromTown = optionalFromTown.get();
                    Town toTown = optionalToTown.get();
                    Passenger passenger = optionalPassenger.get();
                    Plane plane = optionalPlane.get();
                    Ticket ticket = this.ticketMapper.map(ticketDTO, Ticket.class);
                    ticket.setFromTown(fromTown);
                    ticket.setToTown(toTown);
                    ticket.setPassenger(passenger);
                    ticket.setPlane(plane);
                    messages.append(String.format("Successfully imported Ticket %s - %s",
                            ticket.getFromTown().getName(), ticket.getToTown().getName())).append(System.lineSeparator());

                    this.ticketRepository.saveAndFlush(ticket);

                } else {
                    messages.append("Invalid Ticket").append(System.lineSeparator());
                }
            } else {
                messages.append("Invalid Ticket").append(System.lineSeparator());
            }
        }

        return messages.toString().trim();
    }

}