package softuni.exam.service;

import java.io.IOException;

public interface PassengerService {

    boolean areImported();

    String readPassengersFileContent() throws IOException;
	
	String importPassengers() throws IOException;

	String getPassengersOrderByTicketsCountDescendingThenByEmail();

}