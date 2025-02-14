package ioNio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 4. Подсчёт количества слов в файле
 * Задача:
 * Программа должна подсчитать количество слов в файле text.txt.
 * Слова разделяются пробелами или знаками пунктуации.
 * Использовать BufferedReader.
 */
public class CountWord {

    public static void main(String[] args) {
        String fileName = "text.txt";
        int count = 0;
        String line;
        String regex = "[^А-Яа-я0-9_]";//"\\P{L}+";// Разбиваем строку по символам, которые не являются буквами!

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader reader = new BufferedReader(fileReader)) {

            while ((line = reader.readLine()) != null) {
                String[] words = line.split(regex);

                for (String word : words) {
                    if (!word.isBlank()) {
                        count++;
                    }
                }
            }
            System.out.println("count = " + count);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
