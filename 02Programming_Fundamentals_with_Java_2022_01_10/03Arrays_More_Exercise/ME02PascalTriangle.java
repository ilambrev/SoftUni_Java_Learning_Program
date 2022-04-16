package ME03Arrays;

import java.util.Scanner;

public class ME02PascalTriangle {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int triangleRows = Integer.parseInt(scanner.nextLine());

        int elements = 0;

        for (int i = 0; i < triangleRows; i++) {
            elements += (i + 1);
        }

        long[] triangle = new long[elements];

        for (int i = 0; i < elements; i++) {
            triangle[i] = 1;
        }

        int index = 4;
        for (int i = 1; i <= triangleRows - 2; i++) {
            for (int j = index; j < index + i; j++) {
                triangle[j] = triangle[j - (i + 2)] + triangle[j - (i + 1)];
            }
            index += 2 + i;
        }

        index = 0;
        for (int i = 1; i <= triangleRows; i++) {
            for (int j = index; j < index + i; j++) {
                System.out.print(triangle[j] + " ");
            }
            index += i;
            System.out.println();
        }

    }
}