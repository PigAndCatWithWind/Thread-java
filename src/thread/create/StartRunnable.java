package thread.create;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/1/30下午9:48
 * @描述
 */
public class StartRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("sing.....");
        }
    }

    public static void main(String[] args) {
//        StartRunnable startRunnable = new StartRunnable();
//        Thread thread = new Thread(startRunnable);
//        thread.start();
        new Thread(new StartRunnable()).start();
        for (int i = 0; i < 200; i++) {
            System.out.println("....coding");
        }
    }
}
