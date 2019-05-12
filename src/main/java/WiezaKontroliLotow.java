import java.util.Scanner;
import java.util.Random;

public class WiezaKontroliLotow {

    private final int ileMiejscMagazyn = 5;
    private final int ilePasowAwionetki = 3;
    private final int ilePasowPasazerski = 4;
    private final int ilePasowTowarowy = 4;

    private boolean[] pasyAwionetki = new boolean[ilePasowAwionetki];
    private boolean[] pasyPasazerski = new boolean[ilePasowPasazerski];
    private boolean[] pasyTowatowy = new boolean[ilePasowTowarowy];

    // magazyn samolotow w ktorych sa dostepne samoloty do wystartowania
    Samolot[][] magazynSamolotow = new Samolot[3][ileMiejscMagazyn];

    //konstruktor, samoloty ktore mamy na starcie w magazynie
    public WiezaKontroliLotow() {
        // na poczatku symulacji mamy 2 awionetki w magazynie
        magazynSamolotow[0][0] = new Awionetka("Awionetka1");
        magazynSamolotow[0][1] = new Awionetka("Awionetka2");

        //na poczatku symulacji mamy 2 samoloty pasazaerskie w magazynie
        magazynSamolotow[1][0] = new Pasazerski("Pasazerski1");
        magazynSamolotow[1][1] = new Pasazerski("Pasazerski2");

        //na poczatku symulacji mamy 1 samolot towarowy w magazynie
        magazynSamolotow[2][0] = new Towarowy("Towarowy1");

    }

    public boolean czyMozeStartowac(int wybor, int index)
    {
        // sprawdza czy moze wsytartowac samolot, jesli bedzie wiecej paliwa niz 75% pojemnosci to moze i zwraca true
        if(magazynSamolotow[index][wybor].sprawdzZbiornik() > 0.75 * magazynSamolotow[index][wybor].pojemnoscZbiornika())
        {
            magazynSamolotow[index][wybor] = null;  // dany samolot odlatuje a wiec usuwamy go z magazynu
            return true;
        }
        else
            return  false;
    }


    // tankowanie samolotu
    public void zatankujSamolot(int wybor, int index)
    {
        magazynSamolotow[index][wybor].zatankuj();
    }

    public void sprawdzZbiornikSamolotu(int wybor, int index)
    {
        System.out.println("Zawartosc paliwa w zbiorniku: " + magazynSamolotow[index][wybor].sprawdzZbiornik()
        + ", pojemnosc maksymalna " + magazynSamolotow[index][wybor].pojemnoscZbiornika());
    }


    public void zaladunekPasazerski(int wybor) {
        System.out.println("Obecna liczba pasazerow na pokladzie: " + magazynSamolotow[1][wybor].ileMiejscPoklad());
        System.out.println("Liczba wszystkich miejsc: " + magazynSamolotow[1][wybor].ileMiejsc());

        //gdy samolot bedzie pelny
        if(magazynSamolotow[1][wybor].ileMiejscPoklad() == magazynSamolotow[1][wybor].ileMiejsc())
            System.out.println("Samolot jest juz pelny, nie mozna go zaladowac");
        else
            magazynSamolotow[1][wybor].dodajLadunek();                    // dodajemy ladunek

    }


    public void zaladunekTowarowy(int wybor) {
        System.out.println("Obecna liczba ladunku na pokladzie: " + magazynSamolotow[2][wybor].ileMiejscPoklad());
        System.out.println("Liczba maksymalnej ladowalnosci: " + magazynSamolotow[2][wybor].ileMiejsc());

        //gdy samolot bedzie pelny
        if(magazynSamolotow[2][wybor].ileMiejscPoklad() == magazynSamolotow[2][wybor].ileMiejsc())
            System.out.println("Samolot jest juz pelny, nie mozna go zaladowac");
        else
            magazynSamolotow[2][wybor].dodajLadunek();      //metoda dodaje ladunek da samolotu

    }


    public void zaladunekAwionetka(int wybor) {
        System.out.println("Obecna liczba pasazerow na pokladzie: " + magazynSamolotow[0][wybor].ileMiejscPoklad());
        System.out.println("Liczba wszystkich miejsc: " + magazynSamolotow[0][wybor].ileMiejsc());

        //gdy samolot bedzie pelny
        if(magazynSamolotow[0][wybor].ileMiejscPoklad() == magazynSamolotow[0][wybor].ileMiejsc())
            System.out.println("Samolot jest juz pelny, nie mozna go zaladowac");
        else
            magazynSamolotow[0][wybor].dodajLadunek();                    // dodajemy pasazerow
    }

    public void rozladunekSamolotu(int wybor, int index)
    {
        magazynSamolotow[index][wybor].rozladuj();
    }










    // trzeba sprawdzic czy pasy wolne, jesli nie to odliczanie i nowa generacja
    public void ladowanieAwionetka() {

    }

    public void ladowaniePasazerski() {

    }

    public void ladowanieTowarowy() {

    }










    private Scanner in = new Scanner(System.in);

    public int pokaz_wybierzMagazyn(int rodzaj) {
        int index = rodzaj - 1;
        int ile = 0;
        System.out.println("Wybierz samolot z magazynu: ");
        for (int i = 0; i < ileMiejscMagazyn; i++) {
            if (magazynSamolotow[index][i] != null) {
                System.out.println("Miejsce " + (i + 1) + ": " + magazynSamolotow[index][i].getnazwa());
                ile++;
            } else
                System.out.println("Miejsce " + (i + 1) + ": ----");
        }
        if (ile != 0) {
            System.out.println("\nWybor: ");
            int wybor = in.nextInt();                       //nalezy przechwycic wyjatek
            while (magazynSamolotow[index][wybor - 1] == null) {
                System.out.println("Wybrane miejsce jest puste. Sprobuj ponownie.");
                System.out.print("Wybor: ");
                wybor = in.nextInt();                        // obsluzyc wyjatek
            }

            System.out.println("Wybrano samolot: " + magazynSamolotow[index][wybor - 1].getnazwa());
            return wybor - 1;
        } else {
            System.out.println("Magazyn jest pusty. Aby wystartowac samolot musi zaparkowac w magazynie");
            return -1;
        }

    }


    public int wyswietlPasy(int rodzaj) {
        System.out.println("Dostepnosc pasow: ");

        int ile = 0;        // przechowuje liczbe wolnych pasow
        if (rodzaj == 1)
            for (int i = 0; i < ilePasowAwionetki; i++) {
                if (pasyAwionetki[i] == true) {
                    System.out.println("Pas nr " + (i + 1) + ": wolny");
                    ile++;
                } else
                    System.out.println("Pas nr " + (i + 1) + ": zajety");
            }
        else if (rodzaj == 2)
            for (int i = 0; i < ilePasowPasazerski; i++) {
                if (pasyPasazerski[i] == true) {
                    System.out.println("Pas nr " + (i + 1) + ": wolny");
                    ile++;
                } else
                    System.out.println("Pas nr " + (i + 1) + ": zajety");
            }
        else
            for (int i = 0; i < ilePasowTowarowy; i++) {
                if (pasyTowatowy[i] == true) {
                    System.out.println("Pas nr " + (i + 1) + ": wolny");
                    ile++;
                } else
                    System.out.println("Pas nr " + (i + 1) + ": zajety");
            }

        if (ile == 0)        // wszystkie pasy zajete
            return -1;
        else
            return 1;
    }


    public void generatorSamolotow() {
        Random r = new Random();
        for (int i = 0; i < ilePasowAwionetki; i++)
            pasyAwionetki[i] = r.nextBoolean();

        for (int i = 0; i < ilePasowPasazerski; i++)
            pasyPasazerski[i] = r.nextBoolean();

        for (int i = 0; i < ilePasowTowarowy; i++)
            pasyTowatowy[i] = r.nextBoolean();
    }

}







