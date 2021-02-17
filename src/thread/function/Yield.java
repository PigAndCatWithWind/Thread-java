package thread.function;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/2/13上午9:59
 * @描述
 */
public class Yield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();


        new Thread(() ->{
            for (int i = 0 ; i < 100 ; i++){
                System.out.println("Thread ---> "+i);
            }
        }).start();
        for (int i = 0; i < 100 ; i++) {
            if (i%10==0)
                Thread.yield();
            System.out.println("main ---> " +i);
        }
    }
}

class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"--->start");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"--->end");
    }
}
