import java.util.Scanner;

public class WiezaKontroliLotow {

    private int pasyPasazerskieWolne;
    private int pasyPasazerskieZajete;
    private int pasyTowaroweWolne;
    private int pasyTowaroweZajete;
    private int pasyAwionetkiWolne;
    private int pasyAwionetkiZajete;

    // nie wiem jak robimy tą kolejkę, czy tablicami czy jak

    public void ladowaniePasazerski()
    {

    }

    public void zaladunekPasazerski()
    {

    }

    public void ladowanieTowarowy()
    {

    }

    public void zaladunekTowarowy()
    {

    }

    public void ladowanieAwionetka()
    {

    }

    public void zaladunekAwionetka()
    {

    }

    public static void odliczanie(int sekundy)
        {
            long current = System.currentTimeMillis(); int i = sekundy; while(i > 0) {
            if(System.currentTimeMillis() - current > 1000) {
                System.out.println(i--);
                current = System.currentTimeMillis();
            }
        }
            System.out.println("Wykonano!");
    }



        public static void main(String[] args) {

            Scanner in = new Scanner(System.in);


            System.out.println("Zaczynamy symulację!");
            System.out.println("Na starcie steruemy trzema samolotami różnych typów, możemy nimi lądować oraz startować");
            System.out.println("Z każdą operacją związane są dodatkowe niezbędne do wykonani czynności, jak np tankowanie samolotu");
            System.out.println("Możliwe jest też, że pasy będą zajęte i nie będzie można wylądować");

            //tu wyświetlić jakie samoloty mamy do dyspozycji może
            int wybor=-1, wybor_typu=-1;

            for (;;) {

                //tu wyświetlić jakie samoloty mamy do dyspozycji może
                //dodatkowo tez ich właściwości, np ile pasażerów na pokładzie itp

                //dalej menu co chcemy robić z nimi

                System.out.println("-------------------------------------");
                System.out.println("1. Odlot samolotu.");
                System.out.println("2. Przylot samolotu.");
                System.out.println("3. Koniec symulacji");

                System.out.println("Wybierz opcję i wpisz numer: ");
                wybor = in.nextInt();

                switch (wybor) {
                        case 1: {
                            System.out.println("Wybrano odlot samolotu.");
                            System.out.println("1. Awionetka");
                            System.out.println("2. Pasazerski");
                            System.out.println("3. Towarowy");

                            wybor_typu =in.nextInt();

                                switch (wybor_typu){
                                    case 1: {
                                        //działania dla awionetki
                                        System.out.println("jakieś instrukcje dla odlotu");
                                        break;
                                    }

                                    case 2: {
                                        //działania dla pasażerskiego
                                        System.out.println("jakieś instrukcje dla odlotu");
                                        break;
                                    }

                                    case 3: {
                                        //działania dla towarowego
                                        System.out.println("jakieś instrukcje dla odlotu");
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

                            wybor_typu =in.nextInt();

                            switch (wybor_typu){
                                case 1: {
                                    //działania dla awionetki
                                    System.out.println("jakieś instrukcje dla przylotu");
                                    break;
                                }

                                case 2: {
                                    //działania dla pasażerskiego
                                    System.out.println("jakieś instrukcje dla przylotu");
                                    break;
                                }

                                case 3: {
                                    //działania dla towarowego
                                    System.out.println("jakieś instrukcje dla przylotu");
                                    break;
                                }
                            }

                            //przylatuje to patrzymy czy jest wolny pas
                            //i ludzie wysiadają, wtedy odpowiednie parametry trzeba wyzerować

                            break;
                        }

                        case 3: {
                            System.out.println("KONIEC SYMULACJI");
                            System.exit( 0); // wywali program z zerem
                            break;
                        }

                        default: {

                        }

                }

            }


        }


        }








