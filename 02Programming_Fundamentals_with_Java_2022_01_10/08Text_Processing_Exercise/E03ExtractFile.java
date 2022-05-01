package E08TextProcessing;

import java.util.Scanner;

public class E03ExtractFile {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String filePath = scanner.nextLine();

        String[] fileNameAndExtension = filePath.substring(filePath.lastIndexOf("\\") + 1).split("\\.");

        System.out.println("File name: " + fileNameAndExtension[0]);
        System.out.println("File extension: " + fileNameAndExtension[1]);
    }
}