public class Awionetka extends Samolot {

    private int iloscPasazerow;
    private Zbiornik zbiornik;

    //konstruktor
    public Awionetka(String nazwa, int rodzajPasa)
    {
        super(nazwa, 3);           // wywołanie konstruktora z klasy nadrzędnej
        iloscPasazerow = 4;                 // domyślna wartość dla każdego samolotu
        setCzasZaladunku(300);             // domyślna wartość dla każdego samolotu
        setCzasTankowania(100);            // domyślna wartość dla każdego samolotu
        zbiornik = new Zbiornik(100);      // ustawienie domyslnej pojemnosci zbiornika
    }

    @Override
    public int ileMiejsc()
    {
        return iloscPasazerow;
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
