package EX02MidExam;

import java.util.Scanner;

public class EX01SoftUniReception {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] employeeEfficiency = new int[3];
        for (int i = 0; i < 3; i++) {
            employeeEfficiency[i] = Integer.parseInt(scanner.nextLine());
        }
        int studentsCount = Integer.parseInt(scanner.nextLine());
        int staffCapacity = 0;

        for (int efficiency : employeeEfficiency) {
            staffCapacity += efficiency;
        }

        double time = Math.ceil(studentsCount * 1.0 / staffCapacity);

        double breaksNumber = Math.floor(time / 3);

        if (time % 3 == 0 && breaksNumber > 0) {
            time += breaksNumber -1;
        } else {
            time += breaksNumber;
        }

        System.out.printf("Time needed: %.0fh.", time);
    }
}