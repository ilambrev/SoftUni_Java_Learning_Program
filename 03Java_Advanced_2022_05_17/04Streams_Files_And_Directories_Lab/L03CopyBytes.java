package L04StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class L03CopyBytes {
    public static void main(String[] args) {

        try (FileInputStream fileInputStream = new FileInputStream("src/LF04StreamsFilesAndDirectories/input.txt");
             FileOutputStream fileOutputStream = new FileOutputStream("src/LF04StreamsFilesAndDirectories/output.txt")) {
            int asByte = fileInputStream.read();
            while (asByte != -1) {
                if (asByte == 32 || asByte == 10) {
                    fileOutputStream.write(asByte);
                } else {
                    String digits = String.valueOf(asByte);
                    for (int i = 0; i < digits.length(); i++) {
                        fileOutputStream.write(digits.charAt(i));
                    }
                }
                asByte = fileInputStream.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}