import java.util.Timer;
import java.util.TimerTask;
class Helper extends TimerTask {
    public static int i = 2;

    // TimerTask.run() method will be used to perform the action of the task

    public void run() {
        System.out.println("This is called " + i++ + " time");
    }
}
public class example {
    public static void main(String[] args) {

        Timer timer = new Timer();

        // Helper class extends TimerTask
        TimerTask task = new Helper();

        /*
         *  Schedule() method calls for timer class.
         *  void schedule(TimerTask task, Date firstTime, long period)
         */

        timer.schedule(task, 1000, 1000);

    }
}