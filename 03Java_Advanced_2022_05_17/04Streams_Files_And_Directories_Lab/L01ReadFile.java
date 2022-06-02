package L04StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;

public class L01ReadFile {
    public static void main(String[] args) {

        try (FileInputStream fileInputStream = new FileInputStream("src/LF04StreamsFilesAndDirectories/input.txt")) {
            int oneByte = fileInputStream.read();
            while (oneByte != -1) {
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = fileInputStream.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}