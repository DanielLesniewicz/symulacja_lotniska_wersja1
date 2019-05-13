public abstract class Samolot {
    private String nazwa;
    private int rodzajPasa;
    private int czasZaladunku;
    private int czasTankowania;
    private int czasRozladunku;
    private Zbiornik zbiornik;

    //konstruktor
    public Samolot(String nazwa, int rodzajPasa, int pojemnoscZbiornika)
    {
        this.nazwa = nazwa;
        this.rodzajPasa = rodzajPasa;
        zbiornik = new Zbiornik(pojemnoscZbiornika);      // ustawienie domyslnej pojemnosci zbiornika
    }

    public Samolot()
    {}

    //ustawienie czasu zaladunku
    public void setCzasZaladunku(int czasZaladunku)
    {
        this.czasZaladunku = czasZaladunku;
    }

    //ustawienie czasu tankowania
    public void setCzasTankowania(int czasTankowania)
    {
        this.czasTankowania = czasTankowania;
    }

    //ustawienie czasu rozladunku
    public void setCzasRozladunku(int czasRozladunku) {this.czasRozladunku = czasRozladunku;};


    //podaje nazwe samolotu
    public String getnazwa(){
        return nazwa;
    }

    //sprawdza obecna pojemnosc zbiornika
    public  int sprawdzZbiornik()
    {
        return zbiornik.podajIloscPaliwa();
    }

    //sprawdza pojemnosc zbiornika
    public int pojemnoscZbiornika()
    {
        return zbiornik.podajPojemnosc();
    }

    //zwraca czas zaladunku
    public int podajCzasZaladunku() {return czasZaladunku;}

    //zwraca czas rozladunku
    public int podajCzasRozladunku() {return czasRozladunku;}

    //zwraca czas tankowania
    public int podajCzasTankowania() {return  czasTankowania;}

    public int podajRodzajPasa() {return rodzajPasa;}

    public void zatankuj()
    {
        zbiornik.zatankuj();
    }

    public void tankowanie()
    {
        zbiornik.zatankuj();
    }

    public abstract int ileMiejscPoklad();                  // zwraca liczbe miejsc na pokladzie
    public abstract int ileMiejsc();
    public abstract void dodajLadunek() throws Exception;
    public abstract void rozladuj();
}
