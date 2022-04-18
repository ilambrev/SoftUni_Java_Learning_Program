package E04Methods;

import java.util.Scanner;

public class E11ArrayManipulator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] numbersArr = scanner.nextLine().split(" ");
        String manipulationCommand = scanner.nextLine();

        int[] integerNumbers = new int[numbersArr.length];

        for (int i = 0; i < integerNumbers.length; i++) {
            integerNumbers[i] = Integer.parseInt(numbersArr[i]);
        }

        while (!manipulationCommand.equals("end")) {
            String[] command = manipulationCommand.split(" ");

            if (command[0].equals("exchange")) {
                int index = Integer.parseInt(command[1]);
                if (index >= 0 && index < integerNumbers.length - 1) {
                    exchangeSubArraysByIndex(integerNumbers, index);
                } else if (index < 0 || index > integerNumbers.length - 1) {
                    System.out.println("Invalid index");
                }
            } else if (command[0].equals("max")) {
                if (command[1].equals("even")) {
                    maxEvenNumber(integerNumbers);
                } else if (command[1].equals("odd")) {
                    maxOddNumber(integerNumbers);
                }
            } else if (command[0].equals("min")) {
                if (command[1].equals("even")) {
                    minEvenNumber(integerNumbers);
                } else if (command[1].equals("odd")) {
                    minOddNumber(integerNumbers);
                }
            } else if (command[0].equals("first")) {
                if (command[2].equals("even")) {
                    firstEvenNumbers(integerNumbers, command[1]);
                } else if (command[2].equals("odd")) {
                    firstOddNumbers(integerNumbers, command[1]);
                }
            } else if (command[0].equals("last")) {
                if (command[2].equals("even")) {
                    lastEvenNumbers(integerNumbers, command[1]);
                } else if (command[2].equals("odd")) {
                    lastOddNumbers(integerNumbers, command[1]);
                }
            }
            manipulationCommand = scanner.nextLine();
        }

        printArray(integerNumbers);
    }

    private static void exchangeSubArraysByIndex(int[] integerNumbers, int index) {
        for (int i = 0; i <= index; i++) {
            int bufferValue = integerNumbers[0];
            for (int j = 0; j < integerNumbers.length - 1; j++) {
                integerNumbers[j] = integerNumbers[j + 1];
            }
            integerNumbers[integerNumbers.length - 1] = bufferValue;
        }
    }

    private static void maxEvenNumber(int[] integerNumbers) {
        int maxNumber = Integer.MIN_VALUE;
        int maxNumberIndex = 0;
        int evenNumberCounter = 0;
        for (int i = 0; i < integerNumbers.length; i++) {
            if (integerNumbers[i] % 2 == 0 && integerNumbers[i] >= maxNumber) {
                maxNumber = integerNumbers[i];
                maxNumberIndex = i;
                evenNumberCounter++;
            }
        }
        if (evenNumberCounter > 0) {
            System.out.println(maxNumberIndex);
        } else {
            System.out.println("No matches");
        }
    }

    private static void maxOddNumber(int[] integerNumbers) {
        int maxNumber = Integer.MIN_VALUE;
        int maxNumberIndex = 0;
        int evenNumberCounter = 0;
        for (int i = 0; i < integerNumbers.length; i++) {
            if (integerNumbers[i] % 2 != 0 && integerNumbers[i] >= maxNumber) {
                maxNumber = integerNumbers[i];
                maxNumberIndex = i;
                evenNumberCounter++;
            }
        }
        if (evenNumberCounter > 0) {
            System.out.println(maxNumberIndex);
        } else {
            System.out.println("No matches");
        }
    }

    private static void minEvenNumber(int[] integerNumbers) {
        int minNumber = Integer.MAX_VALUE;
        int minNumberIndex = 0;
        int evenNumberCounter = 0;
        for (int i = 0; i < integerNumbers.length; i++) {
            if (integerNumbers[i] % 2 == 0 && integerNumbers[i] <= minNumber) {
                minNumber = integerNumbers[i];
                minNumberIndex = i;
                evenNumberCounter++;
            }
        }
        if (evenNumberCounter > 0) {
            System.out.println(minNumberIndex);
        } else {
            System.out.println("No matches");
        }
    }

    private static void minOddNumber(int[] integerNumbers) {
        int minNumber = Integer.MAX_VALUE;
        int minNumberIndex = 0;
        int evenNumberCounter = 0;
        for (int i = 0; i < integerNumbers.length; i++) {
            if (integerNumbers[i] % 2 != 0 && integerNumbers[i] <= minNumber) {
                minNumber = integerNumbers[i];
                minNumberIndex = i;
                evenNumberCounter++;
            }
        }
        if (evenNumberCounter > 0) {
            System.out.println(minNumberIndex);
        } else {
            System.out.println("No matches");
        }
    }

    private static void firstEvenNumbers(int[] integerNumbers, String evenNumbers) {
        int numbersToFind = Integer.parseInt(evenNumbers);
        if (numbersToFind > integerNumbers.length) {
            System.out.println("Invalid count");
        } else {
            int evenNumberCounter = 0;
            System.out.print("[");
            if (evenNumberCounter < numbersToFind) {
                for (int i = 0; i < integerNumbers.length; i++) {
                    if (integerNumbers[i] % 2 == 0) {
                        if (evenNumberCounter > 0) {
                            System.out.print(", ");
                        }
                        System.out.print(integerNumbers[i]);
                        evenNumberCounter++;
                    }
                    if (evenNumberCounter == numbersToFind) {
                        break;
                    }
                }
            }
            System.out.println("]");
        }
    }

    private static void firstOddNumbers(int[] integerNumbers, String oddNumbers) {
        int numbersToFind = Integer.parseInt(oddNumbers);
        if (numbersToFind > integerNumbers.length) {
            System.out.println("Invalid count");
        } else {
            int oddNumberCounter = 0;
            System.out.print("[");
            if (oddNumberCounter < numbersToFind) {
                for (int i = 0; i < integerNumbers.length; i++) {
                    if (integerNumbers[i] % 2 != 0) {
                        if (oddNumberCounter > 0) {
                            System.out.print(", ");
                        }
                        System.out.print(integerNumbers[i]);
                        oddNumberCounter++;
                    }
                    if (oddNumberCounter == numbersToFind) {
                        break;
                    }
                }
            }
            System.out.println("]");
        }
    }

    private static void lastEvenNumbers(int[] integerNumbers, String evenNumbers) {
        int numbersToFind = Integer.parseInt(evenNumbers);
        int[] lastEvenArr = new int[numbersToFind];
        if (numbersToFind > integerNumbers.length) {
            System.out.println("Invalid count");
        } else {
            int evenNumberCounter = 0;
            if (evenNumberCounter < numbersToFind) {
                for (int i = integerNumbers.length - 1; i >= 0; i--) {
                    if (integerNumbers[i] % 2 == 0) {
                        lastEvenArr[evenNumberCounter] = integerNumbers[i];
                        evenNumberCounter++;
                    }
                    if (evenNumberCounter == numbersToFind) {
                        break;
                    }
                }
            }
            System.out.print("[");
            for (int i = evenNumberCounter - 1; i >= 0; i--) {
                System.out.print(lastEvenArr[i]);
                if (i > 0) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    private static void lastOddNumbers(int[] integerNumbers, String oddNumbers) {
        int numbersToFind = Integer.parseInt(oddNumbers);
        int[] lastOddArr = new int[numbersToFind];
        if (numbersToFind > integerNumbers.length) {
            System.out.println("Invalid count");
        } else {
            int oddNumberCounter = 0;
            if (oddNumberCounter < numbersToFind) {
                for (int i = integerNumbers.length - 1; i >= 0; i--) {
                    if (integerNumbers[i] % 2 != 0) {
                        lastOddArr[oddNumberCounter] = integerNumbers[i];
                        oddNumberCounter++;
                    }
                    if (oddNumberCounter == numbersToFind) {
                        break;
                    }
                }
            }
            System.out.print("[");
            for (int i = oddNumberCounter - 1; i >= 0; i--) {
                System.out.print(lastOddArr[i]);
                if (i > 0) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    private static void printArray(int[] integerNumbers) {
        System.out.print("[");
        for (int i = 0; i < integerNumbers.length; i++) {
            System.out.print(integerNumbers[i]);
            if (i < integerNumbers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

}