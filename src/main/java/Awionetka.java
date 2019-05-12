import java.util.Scanner;

public class Awionetka extends Samolot {

    private int iloscPasazerow;
    private int iloscPasazerowPoklad;

    //konstruktor
    public Awionetka(String nazwa)
    {
        super(nazwa, 3, 200);           // wywołanie konstruktora z klasy nadrzędnej
        iloscPasazerow = 4;                 // domyślna wartość dla każdego samolotu
        iloscPasazerowPoklad = 0;
        setCzasZaladunku(3);             // domyślna wartość dla każdego samolotu
        setCzasTankowania(2);            // domyślna wartość dla każdego samolotu
        setCzasRozladunku(5);            // domślna wartość dla każdego samolotu
    }



    @Override
    public int ileMiejsc()
    {
        return iloscPasazerow;
    }

    @Override
    public int ileMiejscPoklad() { return iloscPasazerowPoklad; }


    Scanner in = new Scanner(System.in);
    @Override
    public void dodajLadunek()
    {
        int osoby = in.nextInt();                                               // przechwycic wyjatek
        if(osoby + iloscPasazerowPoklad > iloscPasazerow)  // jesli liczba bedzie przekraczac liczbe dostepnych miejsc
        {
            System.out.println("Tyle osob nie zmiesci sie w samolocie");
            System.out.println("Liczba osob oddelegowanych: " + (osoby - (iloscPasazerow - iloscPasazerowPoklad)));
            iloscPasazerowPoklad = iloscPasazerow;
            System.out.println("Liczba osob na pokladzie: " + iloscPasazerowPoklad);
        }
        else
        {
            System.out.println("Wejscie pasazerow na poklad: ");
            Menu.odliczanie(podajCzasZaladunku());
            System.out.println("Wejscie na poklad pasazerow zakonczone pomyslnie.");
            iloscPasazerowPoklad += osoby;
            System.out.println("Obecna liczba pasazrow na pokladzie: " + iloscPasazerowPoklad);
        }
    }

    @Override
    public void rozladuj() {
        if (iloscPasazerowPoklad == 0)
            System.out.println("Samolot jest pusty, nie mozna go rozladowac");
        else {
            System.out.println("Liczba osob wysiadajacych z samolotu: " + iloscPasazerowPoklad);
            System.out.println("Rozladunek:");
            Menu.odliczanie(podajCzasRozladunku());
            System.out.println("Wyjscie ludzi z samolotu pomyslne");
        }
    }

    @Override
    public void zatankuj()
    {
        System.out.println("Zatankowano awionetkę!");
    }
    @Override
    public void ladowanie()
    {

    }

    @Override
    public void odlot()
    {

    }

    @Override
    public void odstawMagazyn()
    {

    }
}
