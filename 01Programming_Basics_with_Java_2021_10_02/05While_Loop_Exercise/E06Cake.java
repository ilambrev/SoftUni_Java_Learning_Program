package e05WhileLoop;

import java.util.Scanner;

public class E06Cake {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int cakeWidth = Integer.parseInt(scanner.nextLine());
        int cakeLength = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();


        int cakePieceNumber = cakeWidth * cakeLength;

        while (!input.equals("STOP")) {
            int takenPieces = Integer.parseInt(input);
            cakePieceNumber = cakePieceNumber - takenPieces;
            if (cakePieceNumber <= 0) {
                System.out.printf("No more cake left! You need %d pieces more.", Math.abs(cakePieceNumber));
                break;
            }
            input = scanner.nextLine();
        }
        if (input.equals("STOP")) {
            System.out.printf("%d pieces are left.", cakePieceNumber);
        }
    }
}