package serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class Service {

    public static void main(String[] args) {
        Employe employe = new Employe(1L, "Юра", 300_000, LocalDate.now());

        try (FileOutputStream fileOutputStream = new FileOutputStream("employ.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){

            objectOutputStream.writeObject(employe);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Employe employe1 = new Employe();


        try (FileInputStream fileInputStream = new FileInputStream("employ.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){

            System.out.println( (Employe) objectInputStream.readObject());



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
