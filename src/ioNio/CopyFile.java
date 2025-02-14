package ioNio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 3. Копирование файла (побайтово)
 * Задача:
 * Реализовать копирование файла, считывая его побайтово с помощью FileInputStream и записывая в FileOutputStream.
 */
public class CopyFile {

    public static void main(String[] args) {
        String fileName = "data.txt";
        String fileNameNew = "dataNew.txt";

        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             FileOutputStream fileOutputStream = new FileOutputStream(fileNameNew)) {

            int readByte;
            int sizeBuffer = 4096;
            byte[] buffer = new byte[sizeBuffer];

            while ((readByte = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, readByte);// off - смещается автоматически
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
