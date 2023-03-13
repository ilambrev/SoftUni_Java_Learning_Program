package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "tickets")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketsDTO {

    @XmlElement(name = "ticket")
    private List<TicketCreateDTO> tickets;

    public TicketsDTO() {

    }

    public TicketsDTO(List<TicketCreateDTO> tickets) {
        this.tickets = tickets;
    }

    public List<TicketCreateDTO> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketCreateDTO> tickets) {
        this.tickets = tickets;
    }

}