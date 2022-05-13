package EX06MidExamRetake;

import java.util.Scanner;

public class EX0303ManOWar {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] pirateShip = inputStringToNumbers(scanner);
        int[] warship = inputStringToNumbers(scanner);
        int sectionMaxHealthCapacity = Integer.parseInt(scanner.nextLine());
        String commandsInput = scanner.nextLine();

        boolean stalemate = true;

        while (!commandsInput.equals("Retire")) {
            if (!stalemate) {
                break;
            }
            String[] commands = commandsInput.split(" ");
            String action = commands[0];
            int parameter1 = 0;
            int parameter2 = 0;
            int parameter3 = 0;

            switch (action) {
                case "Fire":
                    parameter1 = Integer.parseInt(commands[1]);
                    parameter2 = Integer.parseInt(commands[2]);
                    if (parameter1 >= 0 && parameter1 < warship.length) {
                        if (warship[parameter1] - parameter2 <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            stalemate = false;
                        } else {
                            warship[parameter1] -= parameter2;
                        }
                    }
                    break;
                case "Defend":
                    parameter1 = Integer.parseInt(commands[1]);
                    parameter2 = Integer.parseInt(commands[2]);
                    parameter3 = Integer.parseInt(commands[3]);
                    if (parameter1 >= 0 && parameter1 < pirateShip.length && parameter2 >= 0 && parameter2 < pirateShip.length) {
                        for (int i = Math.min(parameter1, parameter2); i <= Math.max(parameter1, parameter2); i++) {
                            if (pirateShip[i] - parameter3 <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                stalemate = false;
                                break;
                            } else {
                                pirateShip[i] -= parameter3;
                            }
                        }
                    }
                    break;
                case "Repair":
                    parameter1 = Integer.parseInt(commands[1]);
                    parameter2 = Integer.parseInt(commands[2]);
                    if (parameter1 >= 0 && parameter1 < pirateShip.length) {
                        if (pirateShip[parameter1] + parameter2 > sectionMaxHealthCapacity) {
                            pirateShip[parameter1] = sectionMaxHealthCapacity;
                        } else {
                            pirateShip[parameter1] += parameter2;
                        }
                    }
                    break;
                case "Status":
                    int numberOfWorseHealthSections = 0;
                    for (int i = 0; i < pirateShip.length; i++) {
                        if (pirateShip[i] < 0.2 * sectionMaxHealthCapacity) {
                            numberOfWorseHealthSections++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", numberOfWorseHealthSections);
                    break;
            }

            commandsInput = scanner.nextLine();
        }

        if (stalemate) {
            System.out.printf("Pirate ship status: %d%n", shipStatus(pirateShip));
            System.out.printf("Warship status: %d%n", shipStatus(warship));
        }
    }

    private static int[] inputStringToNumbers(Scanner scanner) {
        String[] inputString = scanner.nextLine().split(">");
        int[] numbersArr = new int[inputString.length];
        for (int i = 0; i < inputString.length; i++) {
            numbersArr[i] = Integer.parseInt(inputString[i]);
        }
        return numbersArr;
    }

    private static int shipStatus(int[] ship) {
        int status = 0;
        for (int i = 0; i < ship.length; i++) {
            status += ship[i];
        }
        return status;
    }

}