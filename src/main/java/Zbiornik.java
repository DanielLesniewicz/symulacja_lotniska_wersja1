import java.util.Random;

public class Zbiornik {
    private int pojemnosc;
    private int iloscPaliwa;

    //konstruktor
    public Zbiornik(int pojemnosc)
    {
        Random r = new Random();
        this.pojemnosc = pojemnosc;
        iloscPaliwa = r.nextInt(pojemnosc);
    }

    //podaje obecna ilosc paliwa
    public int podajIloscPaliwa()
    {
        return iloscPaliwa;
    }

    //podaje pojemnosc zbiornika na paliwo
    public int podajPojemnosc()
    {
        return pojemnosc;
    }

    //tankuje samolot
    public void zatankuj()
    {
        iloscPaliwa = pojemnosc;
        System.out.println("Zatankowano samolot!");
    }
}
