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

    //ustawienie czasu zaladunku
    public void setCzasZaladunku(int czasZaladunku)
    {
        this.czasZaladunku = czasZaladunku;
    }

    public void setCzasTankowania(int czasTankowania)
    {
        this.czasTankowania = czasTankowania;
    }

    public void setCzasRozladunku(int czasRozladunku) {this.czasRozladunku = czasRozladunku;};

    public String getnazwa(){
        return nazwa;
    }

    public  int sprawdzZbiornik()
    {
        return zbiornik.podajIloscPaliwa();
    }

    public int pojemnoscZbiornika()
    {
        return zbiornik.podajPojemnosc();
    }

    public int podajCzasZaladunku() {return czasZaladunku;}

    public int podajCzasRozladunku() {return czasRozladunku;}

    public int podajCzasTankowania() {return  czasTankowania;}

    public void tankowanie()
    {
        zbiornik.zatankuj();
    }


    public abstract int ileMiejscPoklad();                  // zwraca liczbe miejsc na pokladzie
    public abstract int ileMiejsc();
    public abstract void dodajLadunek();
    public abstract void rozladuj();
    public abstract void ladowanie();
    public abstract void odlot();
    public abstract void odstawMagazyn();
    public  abstract void zatankuj();

}
