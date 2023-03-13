package softuni.exam.models.dto;

public class PassengerExportDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private int ticketsCount;

    public PassengerExportDTO() {

    }

    public PassengerExportDTO(String firstName, String lastName, String email, String phoneNumber, int ticketsCount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.ticketsCount = ticketsCount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getTicketsCount() {
        return ticketsCount;
    }

    public void setTicketsCount(int ticketsCount) {
        this.ticketsCount = ticketsCount;
    }

    @Override
    public String toString() {
        return String.format("Passenger %s %s", this.firstName, this.lastName) + System.lineSeparator() +
                String.format("\tEmail - %s", this.email) + System.lineSeparator() +
                String.format("\tPhone - %s", this.phoneNumber) + System.lineSeparator() +
                String.format("\tNumber of tickets - %d", this.ticketsCount) + System.lineSeparator();
    }

}