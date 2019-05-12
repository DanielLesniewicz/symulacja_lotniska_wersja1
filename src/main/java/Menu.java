import java.util.Scanner;

public class Menu {

    private static WiezaKontroliLotow wieza = new WiezaKontroliLotow();


    public static void Odloty(int wybrany, int rodzaj)
    {
        int index = rodzaj - 1;
        System.out.println("Wybierz jedna z dostepnych opcji: ");
        System.out.println("\n-------------------------------------");
        System.out.println("1. Start samolotu.");
        System.out.println("2. Tankowanie.");
        System.out.println("3. Sprawdz zbiornik.");
        System.out.println("4. Zaladunek");
        System.out.println("5. Rozladunek.");
        System.out.println("6. Odstaw do magazynu");

        Scanner in = new Scanner(System.in);
        System.out.print("Wybor: ");
        int wybor = in.nextInt();                       // przechwycic wyjatek trzeba
        while(wybor < 0 && wybor > 6)
        {
            System.out.print("Wybierz prawidlowa opcje: ");
            wybor = in.nextInt();
        }

        switch(wybor)
        {
            case 1:
            {
                if(wieza.czyMozeStartowac(wybrany, index))
                {
                    System.out.println("Samolot odleci za: ");
                    Menu.odliczanie(3);
                    System.out.println("Samolot odlecial!");
                    Menu.wyborTypu();                           // samolot odlecial a wiec zaczynamy od poczatku
                }
                else {
                    System.out.println("Za malo paliwa w samolocie, musisz zatankowac samolot przed odlotem");
                    Menu.Odloty(wybor, rodzaj);                 // ponowne wyowlanie naszego menu odloty
                }
                break;
            }
            case 2:
            {
                wieza.zatankujSamolot(wybrany, index);           // dajemy informacje do wierzy jaki samolot ma byc zatankowany
                break;
            }
            case 3:
            {
                wieza.sprawdzZbiornikSamolotu(wybrany, index);      // dajemy informacje dla ktorego samolotu mamy sprawdzic zbiornik
                break;
            }
            case 4:
            {if(index == 0) // jesli awionetka (rodzaj - 1)
                wieza.zaladunekAwionetka(wybrany);
            else if(index == 1) //jesli pasazerski
                wieza.zaladunekPasazerski(wybrany);
            else                                         // jesli towarowy
                wieza.zaladunekTowarowy(wybrany);

            break;
            }
            case 5:
            {
                wieza.rozladunekSamolotu(wybrany, index);
            }
            case 6:
            {
                //trzeba sprawdzic czy magazyn jest wolny jesli tak to umozliwic podanie miejsca gdzie chcemy umiescic samolot
            }
        }



    }


    public static void wyborTypu()
    {
        Scanner in = new Scanner(System.in);
        int wybor;

        do {
            wieza.generatorSamolotow();                                         // generator zajetych pasow startowych
            System.out.println("\n-------------------------------------");
            System.out.println("1. Odlot samolotu.");
            System.out.println("2. Przylot samolotu.");
            System.out.println("3. Koniec symulacji");

            System.out.println("Wybierz opcje i wpisz numer: ");
            wybor = in.nextInt();           // trzeba zrobic wyjatek zeby nie wywalilo

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

                        wybor_typu = in.nextInt();

                        switch (wybor_typu) {
                            case 1: {
                                // działania dla awionetek
                                int wybrany = wieza.pokaz_wybierzMagazyn(1);
                                if(wybrany >= 0)
                                {
                                    int wartosc = wieza.wyswietlPasy(1);

                                    while (wartosc == -1)
                                    {
                                        System.out.println("Wszystkie pasy zajete. Nalezy poczekac do odlotu samolotow");
                                        System.out.println("Sytuacja na lotnisku po 50 min: ");
                                        Menu.odliczanie(5);
                                        wieza.generatorSamolotow();                                     // nowa sytuacja na lotnisku

                                        wartosc = wieza.wyswietlPasy(1);
                                    }

                                    Menu.Odloty(wybrany, 1);
                                }
                                break;
                            }

                            case 2: {
                                //działania dla pasażerskiegh
                                int wybrany = wieza.pokaz_wybierzMagazyn(2);
                                if(wybrany >= 0)
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

                                    Menu.Odloty(wybrany, 2);
                                }
                                break;
                            }

                            case 3: {
                                //działania dla towarowego
                                int wybrany = wieza.pokaz_wybierzMagazyn(3);
                                if(wybrany >= 0)
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

                                    Menu.Odloty(wybrany, 3);  // wywołanie metody statycznej
                                }
                                break;
                            }
                        }
                        //jak odlot to sprwdzić czy jest paliwo losując i jeśli nie ma to zatankować np.
                        // wpuścić ludzi/czy tam towary załadować itp

                        break;
                    }
                    case 2: {
                        System.out.println("Wybrano przylot samolotu.");
                        System.out.println("1. Awionetka");
                        System.out.println("2. Pasazerski");
                        System.out.println("3. Towarowy");

                        wybor_typu = in.nextInt();

                        switch (wybor_typu) {
                            case 1: {
                                //działania dla awionetki
                                System.out.println("jakieś instrukcje dla przylotu");
                                break;
                            }

                            case 2: {
                                //działania dla pasażerskiego
                                System.out.println("jakieś instrukcje dla przylotup");
                                break;
                            }

                            case 3: {
                                //działania dla towarowego
                                System.out.println("jakieś instrukcje dla przylotuo");
                                break;
                            }
                        }

                        //przylatuje to patrzymy czy jest wolny pas
                        //i ludzie wysiadają, wtedy odpowiednie parametry trzeba wyzerowa
                        break;
                    }

                    default: {
                    }
                }
            }

        } while (wybor != 3);

    }


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
}
