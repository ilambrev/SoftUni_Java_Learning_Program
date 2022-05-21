package L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L05PrinterQueue {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String printQuery = scanner.nextLine();

        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        while (!"print".equals(printQuery)) {
            if ("cancel".equals(printQuery)) {
                if (!printerQueue.isEmpty()) {
                    String removedFile = printerQueue.poll();
                    System.out.println("Canceled " + removedFile);
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                printerQueue.offer(printQuery);
            }
            printQuery = scanner.nextLine();
        }

        for (String fileName : printerQueue) {
            System.out.println(fileName);
        }
    }
}