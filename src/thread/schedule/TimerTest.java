package thread.schedule;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/2/16上午9:52
 * @描述
 */
public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTask(),
                 new GregorianCalendar(2021,2,16,10,5,0).getTime(),  100);
    }
}
class MyTask extends TimerTask{

    @Override
    public void run() {
        System.out.println("TimerTask start doing");
    }
}
