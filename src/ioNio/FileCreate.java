package ioNio;

import java.io.File;
import java.io.IOException;

public class FileCreate {

    public static void main(String[] args) throws IOException {
        File dirs = new File("resource/child");
//        System.out.println("dirs.mkdirs() = " + dirs.listFiles()mkdirs());

        File file = new File("resource/child/text.txt");
        System.out.println("file.createNewFile() = " + file.createNewFile());
        System.out.println("file.mkdirs() = " + file.mkdirs());

    }
}
