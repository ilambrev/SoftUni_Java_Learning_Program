package FootballTeamGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Team> teams = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] commandParameters = input.split(";");

            String command = commandParameters[0];
            String teamName = commandParameters[1];

            switch (command) {
                case "Team":
                    try {
                        Team team = new Team(teamName);
                        teams.put(teamName, team);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Add":
                    if (!teams.containsKey(teamName)) {
                        System.out.printf("Team %s does not exist.%n", teamName);
                    } else {
                        String playerNameToAdd = commandParameters[2];
                        int endurance = Integer.parseInt(commandParameters[3]);
                        int sprint = Integer.parseInt(commandParameters[4]);
                        int dribble = Integer.parseInt(commandParameters[5]);
                        int passing = Integer.parseInt(commandParameters[6]);
                        int shooting = Integer.parseInt(commandParameters[7]);

                        try {
                            Player player = new Player(playerNameToAdd, endurance, sprint, dribble, passing, shooting);

                            Team teamToAddPlayer = teams.get(teamName);

                            teamToAddPlayer.addPlayer(player);

                            teams.put(teamName, teamToAddPlayer);

                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }

                    }
                    break;
                case "Remove":
                    String playerNameToRemove = commandParameters[2];

                    try {
                        Team teamToRemovePlayer = teams.get(teamName);

                        teamToRemovePlayer.removePlayer(playerNameToRemove);

                        teams.put(teamName, teamToRemovePlayer);

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Rating":
                    if (!teams.containsKey(teamName)) {
                        System.out.printf("Team %s does not exist.%n", teamName);
                    } else {
                        System.out.println(teamName + " - " + Math.round(teams.get(teamName).getRating()));
                    }
                    break;
            }


            input = scanner.nextLine();
        }

        System.out.println();

    }
}