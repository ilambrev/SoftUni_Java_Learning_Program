package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private AstronautRepository astronauts;
    private PlanetRepository planets;
    private int exploredPlanetsCount = 0;
    DecimalFormat df = new DecimalFormat("#.##");

    public ControllerImpl() {
        this.astronauts = new AstronautRepository();
        this.planets = new PlanetRepository();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {

        Astronaut astronaut;

        if ("Biologist".equals(type)) {
            astronaut = new Biologist(astronautName);
        } else if ("Geodesist".equals(type)) {
            astronaut = new Geodesist(astronautName);
        } else if ("Meteorologist".equals(type)) {
            astronaut = new Meteorologist(astronautName);
        } else {
            throw new IllegalArgumentException("Astronaut type doesn't exists!");
        }

        astronauts.add(astronaut);

        return String.format("Successfully added %s: %s!", type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {

        Planet planet = new PlanetImpl(planetName);

        for (String item : items) {
            planet.getItems().add(item);
        }

        planets.add(planet);

        return String.format("Successfully added Planet: %s!", planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {

        Astronaut astronaut = astronauts.getModels().stream()
                .filter(a -> a.getName().equals(astronautName)).findFirst().orElse(null);

        if (astronaut == null) {
            throw new IllegalArgumentException(String.format("Astronaut %s doesn't exists!", astronautName));
        }

        astronauts.remove(astronaut);

        return String.format("Astronaut %s was retired!", astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {

        Planet planet = planets.findByName(planetName);

        List<Astronaut> suitableAstronauts = astronauts.getModels().stream()
                .filter(a -> a.getOxygen() > 60).collect(Collectors.toList());

        if (suitableAstronauts.isEmpty()) {
            throw new IllegalArgumentException("You need at least one astronaut to explore the planet!");
        }

        Mission mission = new MissionImpl();

        mission.explore(planet, suitableAstronauts);

        exploredPlanetsCount++;

        long deadAstronauts = suitableAstronauts.stream().filter(a -> !a.canBreath()).count();

        return String.format("Planet: %s was explored! Exploration finished with %d dead astronauts!", planetName, deadAstronauts);
    }

    @Override
    public String report() {

        StringBuilder report = new StringBuilder();

        report.append(String.format("%d planets were explored!", exploredPlanetsCount)).append(System.lineSeparator());

        report.append("Astronauts info:").append(System.lineSeparator());

        for (Astronaut astronaut : astronauts.getModels()) {
            report.append(String.format("Name: %s", astronaut.getName())).append(System.lineSeparator());
            report.append(String.format("Oxygen: %s", df.format(astronaut.getOxygen()))).append(System.lineSeparator());
            if (astronaut.getBag().getItems().isEmpty()) {
                report.append("Bag items: none").append(System.lineSeparator());
            } else {
                String items = String.join(", ", astronaut.getBag().getItems());
                report.append("Bag items: ").append(items).append(System.lineSeparator());
            }
        }

        return report.toString().trim();
    }

}