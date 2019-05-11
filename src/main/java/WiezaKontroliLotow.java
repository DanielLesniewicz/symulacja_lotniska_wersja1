

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


        //przykłądowo wybrano

            odliczanie(5);

        }


    }





