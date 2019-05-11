public abstract class Samolot {
    private String nazwa;
    private int rodzajPasa;
    private long czasZaladunku;
    private long czasTankowania;

    //konstruktor
    public Samolot(String nazwa, int rodzajPasa)
    {
        this.nazwa = nazwa;
        this.rodzajPasa = rodzajPasa;
    }

    //ustawienie czasu zaladunku
    public void setCzasZaladunku(long czasZaladunku)
    {
        this.czasZaladunku = czasZaladunku;
    }

    public void setCzasTankowania(long czasTankowania)
    {
        this.czasTankowania = czasTankowania;
    }

    public abstract int ileMiejsc();
    public abstract void ladowanie();
    public abstract void odlot();
    public abstract void odstawMagazyn();
    public  abstract void zatankuj();
}
