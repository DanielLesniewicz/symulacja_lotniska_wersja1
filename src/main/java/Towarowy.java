import java.util.Scanner;

public class Towarowy extends  Samolot {

    private int ladownosc;
    private int iloscTowaru;

    //konstruktor
    public Towarowy(String nazwa)
    {
        super(nazwa, 2, 1000);
        setCzasTankowania(5);
        setCzasZaladunku(4);
        setCzasRozladunku(3);
        ladownosc = 1000;
        iloscTowaru = 0;
    }


    Scanner in = new Scanner(System.in);
    @Override
    public void dodajLadunek()
    {
        System.out.print("Podaj wartosc ladunku ktory chcesz zaladowac na poklad: ");
        int ladunek = in.nextInt();
        if(ladunek + iloscTowaru  > ladownosc )
        {
            iloscTowaru = ladownosc;
            System.out.println("Nie udalo zaladowac sie wszystkiego poniewaz skonczylo sie miejsce");
            System.out.println("Ilosc ladunku niezaladowanego: " + (ladunek - (ladownosc - iloscTowaru)));
        }
        else
        {
            System.out.println("Zaladunek samolotu:  ");
            Menu.odliczanie(podajCzasZaladunku());
            iloscTowaru += ladunek;
            System.out.println("Zaladunek wykonano pomyslnie.");
            System.out.println("Obecna liczba ladunku na pokladzie: " + iloscTowaru);
        }
    }

    @Override
    public void rozladuj()
    {
        if(iloscTowaru == 0)
            System.out.println("Samolot jest pusty, brak towaru do rozladowania.");
        else
        {
            System.out.println("Liczba towarow do rozladowania: " + iloscTowaru);
            System.out.println("Rozladowywanie towaru: ");
            Menu.odliczanie(podajCzasRozladunku());
            System.out.println("Samolot rozladowano pomyslnie");
        }
    }

    @Override
    public int ileMiejscPoklad()
    {
        return iloscTowaru;
    }

    @Override
    public int ileMiejsc()
    {
        return ladownosc;
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
    public void zatankuj()
    {
        System.out.println("Zatankowano samolot towarowy!");
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
