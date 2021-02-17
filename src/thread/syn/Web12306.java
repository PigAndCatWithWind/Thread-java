package thread.syn;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/2/14下午8:21
 * @描述
 *
 */
public class Web12306 {
    public static void main(String[] args) {
        web web = new web();
        new Thread(web,"路人甲").start();
        new Thread(web,"黄牛已").start();
        new Thread(web,"攻城师").start();
    }
}
class web implements Runnable{
    private int num = 10 ;
    private boolean flag = true ;

    @Override
    public void run() {
        while (flag)
            test6();
    }

    //not safe
    public void test1(){
        if (num <= 0){
            flag = false;
            return;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" have "+num--);
    }

    //safe
    public synchronized void test2(){
        if (num <= 0){
            flag = false ;
            return;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" have "+num--);
    }

    //safe
    public void test3() throws InterruptedException {
        synchronized (this){
            if (num <= 0){
                flag = false;
                return;
            }
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName()+" have "+num--);
        }
    }

    //not safe
    public void test4(){
        synchronized (this){
            if (num <= 0){
                flag = false;
                return;
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" have "+num--);
    }

    //not safe
    public void test5() throws InterruptedException {
        synchronized ((Integer)num){
            if (num <= 0){
                flag = false;
                return;
            }
        }
        Thread.sleep(500);
        System.out.println(Thread.currentThread().getName()+" have "+num--);
    }

    // not safe
    public void test6(){
        if (num <= 0){
            flag = false;
            return;
        }
        synchronized (this){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" have "+num--);
        }
    }
}
