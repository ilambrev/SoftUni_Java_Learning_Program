package L06DefiningClasses.L03BankAccount;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> accounts = new TreeMap<>();

        String tokens = scanner.nextLine();

        while (!tokens.equals("End")) {
            String[] commandParts = tokens.split("\\s+");
            String command = commandParts[0];

            if (commandParts.length == 1) {
                BankAccount bankAccount = new BankAccount();
                int id = bankAccount.getId();
                accounts.put(id, bankAccount);
                System.out.printf("Account ID%d created%n", id);
            } else {
                switch (command) {
                    case "Deposit":
                        int idDeposit = Integer.parseInt(commandParts[1]);
                        double depositAmount = Double.parseDouble(commandParts[2]);
                        if (accounts.containsKey(idDeposit)) {
                            accounts.get(idDeposit).deposit(depositAmount);
                            System.out.printf("Deposited %.0f to ID%d%n", depositAmount, idDeposit);
                        } else {
                            System.out.println("Account does not exist");
                        }
                        break;
                    case "SetInterest":
                        double newInterest = Double.parseDouble(commandParts[1]);
                        BankAccount.setInterestRate(newInterest);
                        break;
                    case "GetInterest":
                        int idAccount = Integer.parseInt(commandParts[1]);
                        int years = Integer.parseInt(commandParts[2]);
                        if (accounts.containsKey(idAccount)) {
                            double interest = accounts.get(idAccount).getInterest(years);
                            System.out.printf("%.2f%n", interest);
                        } else {
                            System.out.println("Account does not exist");
                        }
                        break;

                }
            }

            tokens = scanner.nextLine();
        }

    }
}