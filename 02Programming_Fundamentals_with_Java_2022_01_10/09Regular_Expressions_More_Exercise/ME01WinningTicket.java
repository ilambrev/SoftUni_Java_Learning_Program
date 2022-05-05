package ME09RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ME01WinningTicket {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] tickets = scanner.nextLine().split("( +,+ +)|(,+ +)|( +,+)");
        String winningTicket = "(@{6,10})|(#{6,10})|(\\${6,10})|(\\^{6,10})";
        Pattern pattern = Pattern.compile(winningTicket);

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i].length() == 20) {
                String leftSide = tickets[i].substring(0, 10);
                String rightSide = tickets[i].substring(10);
                Matcher matcher1 = pattern.matcher(leftSide);
                Matcher matcher2 = pattern.matcher(rightSide);
                String leftPattern = "";
                String rightPattern = "";
                if (matcher1.find()) {
                    leftPattern = matcher1.group();
                }
                if (matcher2.find()) {
                    rightPattern = matcher2.group();
                }
                if ((leftPattern.length() > 5 && rightPattern.length() > 5) && leftPattern.charAt(0) == rightPattern.charAt(0)) {
                    char winingSymbol = leftPattern.charAt(0);
                    int numberOfWiningSymbols = Math.min(leftPattern.length(), rightPattern.length());
                    if (numberOfWiningSymbols == 10) {
                        System.out.printf("ticket \"%s\" - %d%c Jackpot!%n", tickets[i], numberOfWiningSymbols, winingSymbol);
                    } else {
                        System.out.printf("ticket \"%s\" - %d%c%n", tickets[i], numberOfWiningSymbols, winingSymbol);
                    }
                } else {
                    System.out.printf("ticket \"%s\" - no match%n", tickets[i]);
                }
            } else {
                System.out.println("invalid ticket");
            }

        }

    }
}