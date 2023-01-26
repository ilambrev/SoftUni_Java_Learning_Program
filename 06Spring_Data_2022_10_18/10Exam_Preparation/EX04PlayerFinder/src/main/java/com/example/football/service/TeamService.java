package com.example.football.service;

import java.io.IOException;

public interface TeamService {

    boolean areImported();

    String readTeamsFileContent() throws IOException;

    String importTeams() throws IOException;

}