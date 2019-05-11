import java.util.Timer;
import java.util.TimerTask;

    //jakieś czary mary
    public class Reminder {
        Timer timer;

        public Reminder(int seconds) {
            timer = new Timer();
            timer.schedule(new RemindTask(), seconds*1000);
        }

        class RemindTask extends TimerTask {
            public void run() {
                System.out.format("Wylądowano pomyślnie!%n");
                timer.cancel(); //Wyłączamy taska
            }
        }

        // wywołanie odlicznia w mainie
        public static void main(String args[]) {
            //tu się wszystko dzieje
            new Reminder(5); //czas w sekundach, tutaj: 5 sekund
            System.out.format("Zaczynam lądowanie, potrwa 5 sekund!%n");
        }

    }

