package E04StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class E09CopyAPicture {
    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream("src/EF04StreamsFilesAndDirectories/picture.jpg");
             FileOutputStream fos = new FileOutputStream("src/EF04StreamsFilesAndDirectories/picture-copy.jpg")) {

            byte[] buffer = fis.readAllBytes();

            fos.write(buffer);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}