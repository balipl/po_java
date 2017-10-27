package lab_1.ex_7;
import lab_1.ex_1.javaIn.JIn;


public class Macierz {
    private Integer _wysokosc;
    private Integer _szerokosc;
    private int[][] _tablica;

    Macierz(Integer wysokosc, Integer szerokosc){
        _wysokosc = wysokosc;
        _szerokosc = szerokosc;
        _tablica = new int[_wysokosc][_szerokosc];


    }
    void wczytajDane(){
        for (int i = 0; i < _wysokosc; i++) {
            for (int j = 0; j < _szerokosc; j++) {
                System.out.println("Podaj wartosc ["+i+"][" + j + "]");
                _tablica[i][j] = JIn.getInteger();
            }
        }
    }

    void wypiszDane(){
        for (int i = 0; i < _wysokosc; i++) {
            for (int j = 0; j < _szerokosc; j++) {
                System.out.println("Wartosc["+i+"]["+j+"]"+_tablica[i][j]);
            }
        }
    }

    Macierz add(Macierz macierz2) {
        Macierz wynik = new Macierz(_wysokosc,_szerokosc);
        if (_wysokosc == macierz2._wysokosc && _szerokosc == macierz2._szerokosc) {
            for (int i = 0; i < _wysokosc; i++) {
                for (int j = 0; j < _szerokosc; j++) {
                    wynik._tablica[i][j]=_tablica[i][j] + macierz2._tablica[i][j];
                }
            }
            return wynik;
        }
        else{
            System.out.println("Blad");
            return this;
        }
    }

    Macierz sub(Macierz macierz2) {
        Macierz wynik = new Macierz(_wysokosc,_szerokosc);
        if (_wysokosc == macierz2._wysokosc && _szerokosc == macierz2._szerokosc) {
            for (int i = 0; i < _wysokosc; i++) {
                for (int j = 0; j < _szerokosc; j++) {
                    wynik._tablica[i][j]=_tablica[i][j] - macierz2._tablica[i][j];
                }
            }
            return wynik;
        }
        else{
            System.out.println("Blad");
            return this;
        }
    }

    Macierz mul(Macierz macierz2){
        Macierz wynik = new Macierz(_wysokosc,_szerokosc);
        if (_wysokosc == macierz2._szerokosc ){
            for (int i = 0; i < _wysokosc; i++) {
                for (int j = 0; j < macierz2._szerokosc; j++) {
                    for (int k = 0; k < _szerokosc; k++) {

                    wynik._tablica[i][j]+= _tablica[i][k] * macierz2._tablica[k][j];
                }
                }
            }
            return wynik;
        }
        else{
            System.out.println("Blad");
            return this;
        }


    }

}
