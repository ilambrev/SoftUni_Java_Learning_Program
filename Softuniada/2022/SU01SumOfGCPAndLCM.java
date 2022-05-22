package Softuniada2022;

import java.util.Scanner;

public class SU01SumOfGCPAndLCM {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int GCP = 0;

        for (int i = 1; i <= Math.min(N, M); i++) {
            if (N % i == 0 && M % i == 0) {
                GCP = i;
            }
        }

        int LCM = (N / GCP) * M;

        System.out.println(GCP + LCM);
    }
}