import java.util.Timer;
import java.util.TimerTask;

public class PlayerTimer {

    static void Timer() {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int counter = 10;

            @Override
            public void run() {
                counter--;
                System.out.println(counter);
                if (counter == 0) {
                    System.out.println("GAME OVER!!!!!");
                    cancel();
                }
            }

        }, 1000, 4000);
    }
}
