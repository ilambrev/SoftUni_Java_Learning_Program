package softuni.exam.service;

import java.io.IOException;

public interface CityService {

    boolean areImported();

    String readCitiesFileContent() throws IOException;
	
	String importCities() throws IOException;

}