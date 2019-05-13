import java.util.Scanner;

class Menu {

    private static WiezaKontroliLotow wieza = new WiezaKontroliLotow();


    public static void Odloty(int rodzaj) throws Exception {
        int typ = rodzaj - 1;
        int wybor;
        boolean czyOdlecial = false;                //zmienna przechowuje wartosc czy samolot odlecial z lotniska
        boolean czyOdstawionyDoMagazynu = false;    // zmienna przechowuje wartosc czy samolot zostal odstawiony do magazynu
        boolean czyWyjscZpetli = false;


        //petla zakonczy sie gdy uzytkownik odleci samolotem lub odstawi samolot do magazynu
        do {

            System.out.println("\nWybierz jedna z dostepnych opcji: ");
            System.out.println("-------------------------------------");
            System.out.println("1. Start samolotu.");
            System.out.println("2. Tankowanie.");
            System.out.println("3. Sprawdz zbiornik.");
            System.out.println("4. Zaladunek");
            System.out.println("5. Rozladunek.");
            System.out.println("6. Odstaw do magazynu");
            System.out.println("7. Wyswietl dostepnosc miejsc na pokladzie");

            wybor = Menu.wczytajOpcje();
            while (wybor < 0 || wybor > 7)
            {
                System.out.print("Wybierz prawidlowa opcje: ");
                wybor = Menu.wczytajOpcje();
            }

            switch (wybor) {
                case 1:                                         // gdy wybierzemy start samolotu
                {
                    if (wieza.czyMozeStartowac(typ)) {
                        System.out.println("Samolot odleci za: ");
                        Menu.odliczanie(3);
                        System.out.println("Samolot odlecial!");
                        czyWyjscZpetli = true;                     // zmienna potwierdza ze samolot odlecial
                    }
                    break;
                }
                case 2: {
                    wieza.zatankujSamolot(typ);           // dajemy informacje do wieży jaki samolot ma byc zatankowany
                    break;
                }
                case 3: {
                    wieza.sprawdzZbiornikSamolotu(typ);      // dajemy informacje dla ktorego samolotu mamy sprawdzic zbiornik
                    break;
                }
                case 4:
                    //zaladunek
                {
                    if(typ == 0)
                        wieza.zaladunekAwionetka();
                    else if(typ == 1)
                        wieza.zaladunekPasazerski();
                    else
                        wieza.zaladunekTowarowy();
                    break;
                }
                case 5: {
                    wieza.rozladunekSamolotu(typ);
                    break;
                }
                case 6: {
                    int ile = wieza.pokazMagazyn(typ);     // zmienna ile przechowuje ilosc zajetych miejsc

                    if(ile == wieza.ileMiejscaMagazyn())   //gdy wszystkie miejsca w magazynie sa zajete
                        System.out.println("Wszystkie miejsca w magazynie sa zajete. Musisz odleciec samolotem.");
                    else{
                        wieza.odstawDoMagazynu(typ);
                        czyWyjscZpetli = true;         // zmienna potwierdza ze samolot zostal odstawiony do magazynu
                    }
                    break;
                }
                case 7: {
                    int miejsca = wieza.ileMiejscPoklad(typ);
                    System.out.println("Na pokladzie jest: " + miejsca);
                    break;
                }
            }
        }while (czyWyjscZpetli == false);
    }






    public static void wyborTypu() throws Exception {
        int wybor;

        do {
            wieza.generatorSamolotow();                                         // generator zajetych pasow startowych
            System.out.println("\n-------------------------------------");
            System.out.println("1. Odlot samolotu.");
            System.out.println("2. Przylot samolotu.");
            System.out.println("3. Koniec symulacji");


            System.out.println("Wybierz opcje i wpisz numer.");
            wybor = wczytajOpcje();           // trzeba zrobic wyjatek zeby nie wywalilo

            while (wybor > 3 || wybor < 1)    // obsluga gdy uzytkownik wybierze nieprawidlowa opcje
            {
                System.out.println("Wybierz opcje od 1 do 3:");
                wybor = wczytajOpcje();
            }

            if (wybor == 3)
                System.out.println("Zakonczenie symulacji. Do widzenia!");

            else {
                int wybor_typu;

                switch (wybor) {
                    case 1: {
                        System.out.println("Wybrano odlot samolotu.");
                        System.out.println("1. Awionetka");
                        System.out.println("2. Pasazerski");
                        System.out.println("3. Towarowy");

                        wybor_typu = wczytajOpcje();

                        while (wybor_typu > 3 || wybor_typu <1)             // obsluga gdy uzytkownik wybierze nieprawidlowa opcje
                        {
                            System.out.println("Wybierz opcje od 1 do 3.");
                            wybor_typu = wczytajOpcje();
                        }

                        switch (wybor_typu) {
                            case 1: {
                                // działania dla awionetek
                                boolean czyWybrano = wieza.pokaz_wybierzMagazyn(1);

                                if(czyWybrano)
                                {
                                    int wartosc = wieza.wyswietlPasy(1);    // wyswietl dostepnosc pasow na lotnisku

                                    while (wartosc == -1)                         //dopoki wszystkie pasy zajete(funkcja wyswwietlPasy zwraca -1 wtedy)
                                    {
                                        System.out.println("Wszystkie pasy zajete. Nalezy poczekac do odlotu samolotow");
                                        System.out.println("Sytuacja na lotnisku po 50 min: ");
                                        Menu.odliczanie(5);
                                        wieza.generatorSamolotow();                // nowa sytuacja na lotnisku

                                        wartosc = wieza.wyswietlPasy(1);
                                    }

                                    System.out.println("Sa pasy wolne! Samolot ustawia sie na jednym z pasow.");
                                    Menu.Odloty(1);    // wybranie opcji dla odlotow
                                }
                                break;
                            }

                            case 2: {
                                //działania dla pasażerskiegh
                                boolean czyWybrano = wieza.pokaz_wybierzMagazyn(2);
                                if(czyWybrano)
                                {
                                    int wartosc = wieza.wyswietlPasy(2);
                                    while (wartosc == -1)
                                    {
                                        System.out.println("Wszystkie pasy zajete. Nalezy poczekac do odlotu samolotow");
                                        System.out.println("Sytuacja na lotnisku po 50 min: ");
                                        Menu.odliczanie(5);
                                        wieza.generatorSamolotow();                                     // nowa sytuacja na lotnisku

                                        wartosc = wieza.wyswietlPasy(2);
                                    }

                                    System.out.println("Sa wolne pasy! Samolot ustawia sie na jednym z pasow.");
                                    Menu.Odloty(2);
                                }
                                break;
                            }

                            case 3: {
                                //działania dla towarowego
                                boolean czyWybrano = wieza.pokaz_wybierzMagazyn(3);
                                if(czyWybrano)
                                {
                                    int wartosc = wieza.wyswietlPasy(3);
                                    while (wartosc == -1)
                                    {
                                        System.out.println("Wszystkie pasy zajete. Nalezy poczekac do odlotu samolotow");
                                        System.out.println("Sytuacja na lotnisku po 50 min: ");
                                        Menu.odliczanie(5);
                                        wieza.generatorSamolotow();                                 // nowa sytuacja na lotnisku

                                        wartosc = wieza.wyswietlPasy(3);
                                    }

                                    System.out.println("Sa wolne pasy! Samolot ustawia sie na jednym z pasow.");
                                    Menu.Odloty(3);  // wywołanie metody statycznej
                                }
                                break;
                            }
                        }
                        break;
                    }
                    //gdy uzytkownik wybiera przylot samolotu
                    case 2: {
                        System.out.println("Ta opcja bedzie dostepna pozniej");
                        break;
                    }

                    default: {
                    }
                }
            }

        } while (wybor != 3);

    }


    // odpowiada za odliczanie
    public static void odliczanie(int sekundy)
    {
        long current = System.currentTimeMillis();
        int i = sekundy;
        while (i > 0) {
            if (System.currentTimeMillis() - current > 1000) {
                System.out.println(i--);
                current = System.currentTimeMillis();
            }
        }
    }

    //funkcja wczytująca opcje wyboru
    public static int wczytajOpcje() throws Exception
    {
        int wybor= 0;
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Wybor: ");
            wybor = in.nextInt();
        }
        catch (Exception ex)
        {
            System.out.println("Wprowadz poprawna opcje.");
            wybor = wczytajOpcje();
        }
        return wybor;
    }

}
