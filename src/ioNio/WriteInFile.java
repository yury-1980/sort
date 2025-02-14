package ioNio;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2. Запись в файл
 * Задача:
 * Запросить у пользователя строку и записать её в файл (output.txt).
 * Использовать FileOutputStream.
 */
public class WriteInFile {

    public static void main(String[] args) {
        String FileName = "output.txt";
        try (BufferedReader readerString = new BufferedReader(new InputStreamReader(System.in));
             FileOutputStream fileOutputStream = new FileOutputStream(FileName, true)) {

            String readLine = readerString.readLine();
            fileOutputStream.write(readLine.getBytes());
            fileOutputStream.write(System.lineSeparator().getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
