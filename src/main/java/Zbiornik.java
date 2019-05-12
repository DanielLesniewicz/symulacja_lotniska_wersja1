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

    public int podajIloscPaliwa()
    {
        return iloscPaliwa;
    }

    public int podajPojemnosc()
    {
        return pojemnosc;
    }

    public void zatankuj()
    {
        iloscPaliwa = pojemnosc;
        System.out.println("Samolot zostal zatankowany");
    }
}
