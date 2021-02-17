package thread.syn;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/2/16上午10:26
 * @描述
 */
public class happenBefore {
    private static int a = 0;
    private static boolean flag = false ;
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            a = 1;
            flag = true ;
        });
        Thread thread2 = new Thread(() ->{
           if (flag)
               a = a * 1;
           if (a == 0)
               System.out.println("happen-before --->" +a);
        });
        thread1.start();
        thread2.start();
//        try {
//            thread2.join();
//            thread1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}
