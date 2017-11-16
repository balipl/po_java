package lab_5.ex_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cryptographer {
    static void cryptfile(String file1, String file2 , Algorithm algorytm) throws FileNotFoundException {
        File plik = new File(file1);
        File plik2 = new File(file2);
        Scanner odczyt = new Scanner(plik);
        PrintWriter zapis = new PrintWriter(plik2);
        String text = odczyt.nextLine();
        text = algorytm.crypt(text);
        zapis.println(text);
    }
    static void decryptfile(String file1, String file2 , Algorithm algorytm)throws FileNotFoundException{
        File plik = new File(file1);
        File plik2 = new File(file2);
        Scanner odczyt = new Scanner(new File(file1));
        PrintWriter zapis = new PrintWriter(file2);
        String text = odczyt.nextLine();
        text = algorytm.decrypt(text);
        zapis.println(text);

    }

}
