package thread.function;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/2/14下午6:54
 * @描述
 */
public class Daemon {
    public static void main(String[] args) {
        new Thread(new you()).start();
        Thread thread = new Thread(new god());
        thread.setDaemon(true);
        thread.start();
    }
}

class you extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <365*100 ; i++) {
            System.out.println("happy life " + i + " day");
        }
        System.out.println("dev..........");
    }
}

class god extends Thread{
    @Override
    public void run() {
        for (;true;){
            System.out.println("bless you ...");
        }
    }
}
