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
            int wybor=-1;

            for (; ; ) {

                //tu wyświetlić jakie samoloty mamy do dyspozycji może

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
                            System.out.println("jakieś instrukcje dla odlotu");

                            break;
                        }
                        case 2: {
                            System.out.println("Wybrano przylot samolotu.");
                            System.out.println("jakieś instrukcje dla przylotu");

                            break;
                        }

                        case 3: {
                            System.out.println("KONIEC");
                            System.exit( 0); // wywali program z zerem
                            break;
                        }

                        default: {

                        }

                }

            }


        }


        }








