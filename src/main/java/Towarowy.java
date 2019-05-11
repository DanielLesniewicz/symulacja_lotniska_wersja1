import java.util.Scanner;

public class Towarowy extends  Samolot {

    private int ladownosc;
    private int iloscTowaru;
    private Zbiornik zbiornik;

    //konstruktor
    public Towarowy(String nazwa)
    {
        super(nazwa, 2);
        ladownosc = 1000;
        iloscTowaru = 0;
        zbiornik = new Zbiornik(1000);
    }

    public void dodajLadunek(int ladunek)
    {
        if(ladunek + iloscTowaru  > ladownosc )
        {
            iloscTowaru = ladownosc;
            System.out.println("Nie udalo zaladowac sie wszystkiego poniewaz skonczylo sie miejsce");
            System.out.println("Ilosc ladunku niezaladowanego: " + (ladunek - (ladownosc - iloscTowaru)));
        }
        else if(iloscTowaru == ladownosc)
        {
            System.out.println("Nie mozna zaladowac samolotu, samolot jest juz pelny");
        }
        else
        {
            iloscTowaru += ladunek;
        }
    }

    public void rozladujLadunek()
    {
        if(iloscTowaru == 0)
        {
            System.out.println("Samolot jest pusty, nie mozna go zaladowac");
        }
        else
        {
            System.out.println("Ilosc towaru w samolocie: " + iloscTowaru);
            System.out.println("Podaj jaka ilosc chcesz rozladowac: ");
            Scanner in = new Scanner(System.in);
            int rozladunek = in.nextInt();
            if(rozladunek > iloscTowaru)
                System.out.println("Nie mozesz rozladowac wiecej towaru nic jest");
            else
            {
                iloscTowaru -= rozladunek;
            }
        }
    }


    @Override
    public int ileMiejsc()
    {
        return iloscTowaru;
    }

    @Override
    public void zatankuj()
    {

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
