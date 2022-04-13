package ME02DataTypesAndVariables;

import java.util.Scanner;

public class ME04RefactoringPrimeChecker {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int endNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 2; i<= endNumber; i++) {
            boolean isNumberPrime = true;
            for (int j = 2; j < i; j++) {
               if (i % j == 0) {
                   isNumberPrime = false;
                   break;
               }
            }
            System.out.printf("%d -> %b%n", i, isNumberPrime);
        }
    }
}



//    Scanner chetec = new Scanner(System.in);
//
//    int ___Do___ = Integer.parseInt(chetec.nextLine());
//    for (int takoa = 2; takoa <= ___Do___; takoa++) {
//    boolean takovalie = true;
//    for (int cepitel = 2; cepitel < takoa; cepitel++) {
//    if (takoa % cepitel == 0) {
//    takovalie = false;
//    break;
//    }
//    }
//    System.out.printf("%d -> %b%n", takoa, takovalie);
//    }
