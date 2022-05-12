package EX05MidExam;

import java.util.Scanner;

public class EX02MuOnline {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] dungeonRooms = scanner.nextLine().split("\\|+");

        int health = 100;
        int bitcoins = 0;

        for (int i = 0; i < dungeonRooms.length; i++) {
            String[] room = dungeonRooms[i].split("\\s+");
            String command = room[0];
            int value = Integer.parseInt(room[1]);
            int healedPoints = 0;

            switch (command) {
                case "potion":
                    if (health < 100) {
                        healedPoints = value - (100 - health);
                        if (healedPoints <= 0) {
                            healedPoints = value;
                        } else {
                            healedPoints = 100 - health;
                        }
                        health += healedPoints;
                    }
                    System.out.printf("You healed for %d hp.%n", healedPoints);
                    System.out.printf("Current health: %d hp.%n", health);
                    break;
                case "chest":
                    bitcoins += value;
                    System.out.printf("You found %d bitcoins.%n", value);
                    break;
                default:
                    if ((health - value) > 0) {
                        System.out.printf("You slayed %s.%n", command);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", command);
                        System.out.printf("Best room: %d%n", (i + 1));
                    }
                    health -= value;
                    break;
            }
            if (health <= 0) {
                break;
            }
        }

        if (health > 0) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", bitcoins);
            System.out.printf("Health: %d%n", health);
        }
    }
}