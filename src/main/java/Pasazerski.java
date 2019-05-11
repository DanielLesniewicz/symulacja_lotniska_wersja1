public class Pasazerski extends Samolot {

    private int iloscPasazerow;
    private Zbiornik zbiornik;

    //konstruktor
    public Pasazerski(String nazwa, int rodzajPasa)
    {
        super(nazwa, 1);           // wywołanie konstruktora z klasy nadrzędnej
        iloscPasazerow = 120;               // domyślna wartość dla każdego samolotu
        setCzasZaladunku(1000);             // domyślna wartość dla każdego samolotu
        setCzasTankowania(1000);            // domyślna wartość dla każdego samolotu
        zbiornik = new Zbiornik(1000);      // ustawienie domyslnej pojemnosci zbiornika
    }

    @Override
    public int ileMiejsc()
    {
        return iloscPasazerow;
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
