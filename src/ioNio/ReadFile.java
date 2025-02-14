package ioNio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 1. Чтение файла построчно
 * Задача:
 * Написать программу, которая читает текстовый файл (data.txt) и выводит его содержимое построчно в консоль.
 * Использовать BufferedReader.
 */
public class ReadFile {

    public static void main(String[] args) {
        String fileName = ("data.txt");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            String readString;

            while ((readString = bufferedReader.readLine()) != null) {
                System.out.println(readString);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
