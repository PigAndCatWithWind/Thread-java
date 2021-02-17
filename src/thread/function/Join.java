package thread.function;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/2/13上午10:10
 * @描述
 */
public class Join {
    public static void main(String[] args) {
       Thread thread = new Thread(() -> {
            for (int i = 0; i < 100 ; i++) {
                System.out.println("Thread ...." + i);
            }
        });
       thread.start();
        for (int i = 0; i <100 ; i++) {
            try {
                if (i == 20)
                    thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main ...." +i);
        }
    }
}