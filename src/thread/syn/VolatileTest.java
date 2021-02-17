package thread.syn;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/2/16下午4:07
 * @描述
 */
public class VolatileTest {
    private volatile static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (num == 0){

            }
        }).start();
        Thread.sleep(100);
        num = 1;
    }
}
