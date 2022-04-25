package ME06ObjectsAndClasses;

import java.util.*;

public class ME04TeamworkProjects {

    static class Team {
        String teamName;
        String teamCreator;
        List<User> users;

        public Team(String teamName, String timCreator, List<User> users) {
            this.teamName = teamName;
            this.teamCreator = timCreator;
            this.users = users;
        }

        public String getTeamName() {
            return this.teamName;
        }

        public String getTeamCreator() {
            return this.teamCreator;
        }

        public List<User> getUsers() {
            return this.users;
        }

        public void printUsers(List<User> users) {
            users.sort((u1, u2) -> (u1.getName().compareTo(u2.getName())));
            for (User u : users) {
                System.out.println(u);
            }
        }

        @Override
        public String toString() {
            return String.format("%s%n- %s", this.teamName, this.teamCreator);
        }

    }

    static class User {
        String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return String.format("-- %s", this.name);
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int countOfTeams = Integer.parseInt(scanner.nextLine());
        List<Team> teams = new ArrayList<>();

        for (int i = 0; i < countOfTeams; i++) {
            String[] input = scanner.nextLine().split("-");
            if (checkIfTeamExists(teams, input[1])) {
                System.out.printf("Team %s was already created!%n", input[1]);
            } else if (checkIfTeamCreatorExists(teams, input[0])) {
                System.out.printf("%s cannot create another team!%n", input[0]);
            } else {
                ArrayList<User> users = new ArrayList<>();
                Team team = new Team(input[1], input[0], users);
                teams.add(team);
                System.out.printf("Team %s has been created by %s!%n", team.getTeamName(), team.getTeamCreator());
            }
        }

        teams.sort((t1, t2) -> (t1.getTeamName().compareTo(t2.getTeamName())));

        String inputCommand = scanner.nextLine();

        while (!inputCommand.equals("end of assignment")) {
            String[] input = inputCommand.split("->");
            if (!checkIfTeamExists(teams, input[1])) {
                System.out.printf("Team %s does not exist!%n", input[1]);
            } else if (checkIfTeamCreatorExists(teams, input[0]) || checkIfUserExists(teams, input[0])) {
                System.out.printf("Member %s cannot join team %s!%n", input[0], input[1]);
            } else {
                int index = getTeamIndex(teams, input[1]);
                User user = new User(input[0]);
                teams.get(index).getUsers().add(user);
            }

            inputCommand = scanner.nextLine();
        }

        List<Team> teamsWithUsers = new ArrayList<>();

        for (Team t : teams) {
            if (!t.getUsers().isEmpty()) {
                teamsWithUsers.add(t);
            }
        }

        teamsWithUsers.sort((t1, t2) -> Integer.compare(t2.getUsers().size(), t1.getUsers().size()));

//        teamsWithUsers.sort((t1, t2) -> {
//                    int sort = Integer.compare(t2.getUsers().size(), t1.getUsers().size());
//                    if (sort == 0) {
//                        return t1.getTeamName().compareTo(t2.getTeamName());
//                    }
//                    return sort;
//                });

        for (Team t : teamsWithUsers) {
            System.out.println(t);
            t.printUsers(t.getUsers());
        }

        System.out.println("Teams to disband:");

        for (Team t : teams) {
            if (t.getUsers().isEmpty()) {
                System.out.println(t.getTeamName());
            }
        }
    }

    private static boolean checkIfTeamExists(List<Team> teams, String team) {
        for (Team t : teams) {
            if (!teams.isEmpty() && t.getTeamName().equals(team)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkIfTeamCreatorExists(List<Team> teams, String teamCreator) {
        for (Team t : teams) {
            if (!teams.isEmpty() && t.getTeamCreator().equals(teamCreator)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkIfUserExists(List<Team> teams, String user) {
        for (Team t : teams) {
            for (User u : t.getUsers()) {
                if (!t.getUsers().isEmpty() && u.getName().equals(user)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int getTeamIndex(List<Team> teams, String team) {
        int index = 0;
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getTeamName().equals(team)) {
                index = i;
                break;
            }
        }
        return index;
    }

}