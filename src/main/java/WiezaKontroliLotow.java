import java.util.Random;

public class WiezaKontroliLotow {

    private final int ileMiejscMagazyn = 5;
    private final int ilePasowAwionetki = 3;
    private final int ilePasowPasazerski = 4;
    private final int ilePasowTowarowy = 4;

    private boolean[] pasyAwionetki = new boolean[ilePasowAwionetki];
    private boolean[] pasyPasazerski = new boolean[ilePasowPasazerski];
    private boolean[] pasyTowatowy = new boolean[ilePasowTowarowy];

    // magazyn samolotow w ktorych sa dostepne samoloty do wystartowania
    private Samolot[][] magazynSamolotow = new Samolot[3][ileMiejscMagazyn];

    //trzy typy samolotow uzywane w programie
    private Pasazerski pasazerski;
    private Towarowy towarowy;
    private Awionetka awionetka;


    //konstruktor, samoloty ktore mamy na starcie w magazynie
    public WiezaKontroliLotow() {


        //samoloty obslugiwane w programie
        pasazerski = new Pasazerski("");
        towarowy = new Towarowy("");
        awionetka = new Awionetka("");

        // na poczatku symulacji mamy 2 awionetki w magazynie
        magazynSamolotow[0][0] = new Awionetka("Awionetka1");
        magazynSamolotow[0][1] = new Awionetka("Awionetka2");

        //na poczatku symulacji mamy 2 samoloty pasazaerskie w magazynie
        magazynSamolotow[1][0] = new Pasazerski("Pasazerski1");
        magazynSamolotow[1][1] = new Pasazerski("Pasazerski2");

        //na poczatku symulacji mamy 1 samolot towarowy w magazynie
        magazynSamolotow[2][0] = new Towarowy("Towarowy1");

    }


    //metoda sprawdza czy samolot moze wsytartowac z lotniska
    public boolean czyMozeStartowac(int typ) {
        // sprawdza czy moze wsytartowac samolot, jesli bedzie wiecej paliwa niz 75% pojemnosci to moze i zwraca true

        int wartosc = 0;        // zmienna przechowujaca czy czegos nie brakuje w samolocie

        if(typ == 0) // samolot to awionetka
        {
            if(awionetka.sprawdzZbiornik() < 0.75 * awionetka.pojemnoscZbiornika())
            {
                System.out.println("W zbiorniku jest za malo paliwa. Przed startem nalezy zatankowac samolot");
                wartosc++;
            }

            if(awionetka.ileMiejscPoklad() < 0.5 * awionetka.ileMiejsc())
            {
                System.out.println("Na pokladzie jest za duzo miejsca nalezy zapelnic samolot do 50% przeznaczonego miejsca");
                wartosc++;
            }
        }
        else if(typ == 1) //samolot pasazerski
        {
            if(pasazerski.sprawdzZbiornik() < 0.75 * pasazerski.pojemnoscZbiornika())
            {
                System.out.println("W zbiorniku jest za malo paliwa. Przed startem nalezy zatankowac samolot ");
                wartosc++;
            }

            if(pasazerski.ileMiejscPoklad() < 0.5 * pasazerski.ileMiejsc())
            {
                System.out.println("Na pokladzie jest za duzo miejsca nalezy zapelnic samolot do 50% przeznaczonego miejsca");
                wartosc++;
            }

        }
        else               // samolot transportowy
        {
            if(towarowy.sprawdzZbiornik() < 0.75 * towarowy.pojemnoscZbiornika())
            {
                System.out.println("W zbiorniku jest za malo paliwa. Przed startem nalezy zatankowac samolot ");
                wartosc++;
            }

            if(towarowy.ileMiejscPoklad() < 0.5 * towarowy.ileMiejsc())
            {
                System.out.println("Na pokladzie jest za duzo miejsca nalezy zapelnic samolot do 50% przeznaczonego miejsca ");
                wartosc++;
            }
        }


        if (wartosc == 0)        //wartosc == 0 czyli wszystko sie zgadza do odlotu
        {
            return true;
        } else                    // wartosc != 0 czyli nalezy wykonac jakas operacje przed odlotem
            return false;
    }



    // tankowanie samolotu
    public void zatankujSamolot(int typ) {

        if(typ == 0)
            awionetka.zatankuj();
        else if(typ == 1)
            pasazerski.zatankuj();
        else
            towarowy.zatankuj();
    }



    //sprawdzenie zbiornika paliwa
    public void sprawdzZbiornikSamolotu(int typ)
    {
        int paliwo = 0;         //zmienna przechowuje obecna ilosc paliwa w zbiorniku
        int max = 0;            // zmienna przechowuje maksymalna ilosc paliwa w zbiorniku

        if(typ == 0)
        {
            paliwo = awionetka.sprawdzZbiornik();
            max = awionetka.pojemnoscZbiornika();
        }
        else if(typ == 1)
        {
            paliwo = pasazerski.sprawdzZbiornik();
            max = pasazerski.pojemnoscZbiornika();
        }
        else
            {
            paliwo = towarowy.sprawdzZbiornik();
            max = towarowy.pojemnoscZbiornika();
        }


        System.out.println("Zawartosc paliwa w zbiorniku: " + paliwo + ", pojemnosc maksymalna " + max);
    }



    // zaladunek samolotu pasazerskiego
    public void zaladunekPasazerski() throws Exception{
        System.out.println("Obecna liczba pasazerow na pokladzie: " + pasazerski.ileMiejscPoklad());
        System.out.println("Liczba wszystkich miejsc: " + pasazerski.ileMiejsc());

        //gdy samolot bedzie pelny
        if (pasazerski.ileMiejscPoklad() == pasazerski.ileMiejsc())
            System.out.println("Samolot jest juz pelny, nie mozna go zaladowac");
        else
            pasazerski.dodajLadunek();                    // dodajemy ladunek
    }


    public void zaladunekTowarowy() throws Exception{
        System.out.println("Obecna liczba ladunku na pokladzie: " + towarowy.ileMiejscPoklad());
        System.out.println("Liczba maksymalnej ladowalnosci: " + towarowy.ileMiejsc());

        //gdy samolot bedzie pelny
        if (towarowy.ileMiejscPoklad() == towarowy.ileMiejsc())
            System.out.println("Samolot jest juz pelny, nie mozna go zaladowac");
        else
            towarowy.dodajLadunek();      //metoda dodaje ladunek da samolotu

    }


    public void zaladunekAwionetka() throws Exception {
        System.out.println("Obecna liczba pasazerow na pokladzie: " + awionetka.ileMiejscPoklad());
        System.out.println("Liczba wszystkich miejsc: " + awionetka.ileMiejsc());

        //gdy samolot bedzie pelny
        if (awionetka.ileMiejscPoklad() == awionetka.ileMiejsc())
            System.out.println("Samolot jest juz pelny, nie mozna go zaladowac");
        else
            awionetka.dodajLadunek();                    // dodajemy pasazerow
    }



    //zwraca obecna liczbe miejsc na pokladzie samolotu
    public int ileMiejscPoklad(int typ)
    {
        if(typ == 0)
            return awionetka.ileMiejscPoklad();
        else if (typ == 1)
            return pasazerski.ileMiejscPoklad();
        else
            return towarowy.ileMiejscPoklad();
    }


    // rozładowuje samolot
    public void rozladunekSamolotu(int typ)
    {
        if(typ == 0)
            awionetka.rozladuj();
        else if(typ == 1)
            pasazerski.rozladuj();
        else
            towarowy.rozladuj();
    }




    //pokazuje magazyn i wybiera jeden z samolotow
    public boolean pokaz_wybierzMagazyn(int rodzaj) throws Exception {
        int typ = rodzaj - 1;                     //zmienna potrzebna do indeksu w tablicy dwuwymiarowej

        System.out.println("Wybierz samolot z magazynu: ");

        int ile = pokazMagazyn(typ);


        if (ile != 0)                       //gdy są wolne miejsca
        {
            int wybor = Menu.wczytajOpcje();

            while (wybor > ileMiejscMagazyn || wybor < 1)       //gdy uzytkownik wybierze miejsce nie z zakresu dostepnych
            {
                System.out.println("Nie ma takiego miejsca, prosze wybrac poprawna opcje.");
                wybor = Menu.wczytajOpcje();
            }

            while (magazynSamolotow[typ][wybor - 1] == null)   //gdy uzytkownik wybierze puste miejsce
            {
                System.out.println("Wybrane miejsce jest puste. Sprobuj ponownie.");
                wybor = Menu.wczytajOpcje();
            }

            System.out.println("Wybrano samolot: " + magazynSamolotow[typ][wybor - 1].getnazwa());



            //ustawienie typu jakim bedziemy poslugiwac sie w programie
            if(typ == 0) //samolot jest awionetka
            {
                awionetka = new Awionetka( (Awionetka) magazynSamolotow[typ][wybor -1]);
            }
            else if(typ == 1) // samolot jest pasazerski
            {
                pasazerski = new Pasazerski( (Pasazerski) magazynSamolotow[typ][wybor-1]);
            }
            else
                towarowy = new Towarowy( (Towarowy) magazynSamolotow[typ][wybor -1]);


            magazynSamolotow[typ][wybor - 1] = null;            // zwolnienie miejsca w magazynie
            return true;                                        // udalo sie wybrac samolot a wiec wzwracamy true

        } else
            {
            System.out.println("Magazyn jest pusty. Aby wystartowac jakis samolot musi przyleciec i zaparkowac w magazynie");
            return false;                                       // nie udalo sie wybrac samolotu wiec zwracamy false
        }
    }





    public int pokazMagazyn(int typ)    // zwraca liczbe zajetych miejsc
    {
        int ile = 0;
        for (int i = 0; i < ileMiejscMagazyn; i++)
        {
            if (magazynSamolotow[typ][i] != null)
            {
                System.out.println("Miejsce " + (i + 1) + ": " + magazynSamolotow[typ][i].getnazwa());
                ile++;
            } else
                System.out.println("Miejsce " + (i + 1) + ": ----");
        }
         return ile;
    }



        //odstawia samolot do magazynu na wybrane miejsce
        public void odstawDoMagazynu(int typ) throws Exception
        {
            System.out.print("Wybierz miejsce w ktore chcesz odstawic samolot: ");
            int miejsce;
            boolean czyWybrano = false;

            do {

                miejsce = Menu.wczytajOpcje();

                if (miejsce > ileMiejscMagazyn || miejsce < 1)            // gdy zmienna wykracza poaza zakres miejsc
                {
                    System.out.println("Wybrane miejsce nie istnieje");
                    System.out.print("Podaj prawidlowe miejsce: ");
                }
                else {
                    if (magazynSamolotow[typ][miejsce - 1] != null)         //gyd wybrane miejsce bedzie zajete
                    {
                        System.out.println("Wybrane miejsce jest zajete. Wybierz wolne miejsce");
                    }
                    else
                    {
                        // miejsce jest prawidlowe a wiec nalezy wstawic samolot do magazynu
                        if(typ == 0)
                            magazynSamolotow[typ][miejsce - 1] = new Awionetka(awionetka);
                        else if(typ == 1)
                            magazynSamolotow[typ][miejsce-1] = new Pasazerski(pasazerski);
                        else
                            magazynSamolotow[typ][miejsce-1] = new Towarowy(towarowy);


                        System.out.println("Samolot pomyslnie umieszczony w magazynie na miejscu nr: " + miejsce);
                        czyWybrano = true;
                    }
                }

            } while (czyWybrano == false);
        }


        public int ileMiejscaMagazyn ()
        {
            return ileMiejscMagazyn;
        }





        public int wyswietlPasy ( int rodzaj){
            System.out.println("Dostepnosc pasow: ");


            int ile = 0;        // przechowuje liczbe wolnych pasow
            if (rodzaj == 1)
                for (int i = 0; i < ilePasowAwionetki; i++) {
                    if (pasyAwionetki[i]) {
                        System.out.println("Pas nr " + (i + 1) + ": wolny");
                        ile++;
                    } else
                        System.out.println("Pas nr " + (i + 1) + ": zajety");
                }
            else if (rodzaj == 2)
                for (int i = 0; i < ilePasowPasazerski; i++) {
                    if (pasyPasazerski[i]) {
                        System.out.println("Pas nr " + (i + 1) + ": wolny");
                        ile++;
                    } else
                        System.out.println("Pas nr " + (i + 1) + ": zajety");
                }
            else
                for (int i = 0; i < ilePasowTowarowy; i++) {
                    if (pasyTowatowy[i]) {
                        System.out.println("Pas nr " + (i + 1) + ": wolny");
                        ile++;
                    } else
                        System.out.println("Pas nr " + (i + 1) + ": zajety");
                }

            if (ile == 0)        // wszystkie pasy zajete
                return -1;
            else
                return 1;
        }

    public void ladowanieAwionetka() {

    }

    public void ladowaniePasazerski() {

    }

    public void ladowanieTowarowy() {

    }



        // odpowiada za generacje dostepnosci pasow na lotnisku
        public void generatorSamolotow() {
            Random r = new Random();
            for (int i = 0; i < ilePasowAwionetki; i++)
                pasyAwionetki[i] = r.nextBoolean();

            for (int i = 0; i < ilePasowPasazerski; i++)
                pasyPasazerski[i] = r.nextBoolean();

            for (int i = 0; i < ilePasowTowarowy; i++)
                pasyTowatowy[i] = r.nextBoolean();
        }

}







