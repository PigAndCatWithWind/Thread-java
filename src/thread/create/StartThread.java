package thread.create;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/1/30下午7:32
 * @描述
 */
public class StartThread extends Thread {
    public static void main(String[] args) {
        StartThread startThread = new StartThread();
        startThread.start();
        for (int i = 0; i <200 ; i++) {
            System.out.println("......coding");
        }
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 200 ;i++){
            System.out.println("sing......");
        }
    }
}
