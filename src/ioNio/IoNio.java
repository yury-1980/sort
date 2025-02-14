package ioNio;

import java.io.*;

public class IoNio {

    public static void main(String[] args) {
        String strWrite = "Привет !!!";

        try (FileOutputStream outputStream = new FileOutputStream("text.txt");
             FileInputStream inputStream = new FileInputStream("text.txt");
             InputStreamReader reader = new InputStreamReader(inputStream)) {

            outputStream.write(strWrite.getBytes());
            outputStream.flush();

            int line;
            while ((line = reader.read()) != -1) {
                System.out.print((char) line);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
