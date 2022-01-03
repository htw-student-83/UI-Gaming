import java.util.concurrent.*;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Timer {
    Aufgabe punkte = new Aufgabe();
    public void countdown(){
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        final Runnable runnable = new Runnable() {
            int countdownStarter = 20;

            public void run() {

                //System.out.println(countdownStarter);
                countdownStarter--;

                    if (countdownStarter < 0) {
                        System.out.println("Time Over!");
                        System.out.println("Deine bereits erspielten Punkte: ");
                        int gesamtpunkte = punkte.getPunkte();
                        System.out.println(gesamtpunkte + " Punkte.");
                        System.exit(0);
                        scheduler.shutdown();
                    }
                }
            };
            scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
    }
}

