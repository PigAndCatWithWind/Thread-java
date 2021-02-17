package thread.other;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/2/16下午4:26
 * @描述
 */
public class ThreadLocalTest {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);
    private static ThreadLocal<Integer> inheritableThreadLocal = new InheritableThreadLocal<>();
    public static void main(String[] args) {
        new Thread(new MyRun()).start();
        inheritableThreadLocal.set(2);
        System.out.println(Thread.currentThread().getName()+" ---InheritableThreadLocal---> " + inheritableThreadLocal.get());
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+" ---InheritableThreadLocal---> " + inheritableThreadLocal.get());
        }).start();
    }
    public static class MyRun implements Runnable{
        public MyRun(){
            threadLocal.set(-100);
            System.out.println(Thread.currentThread().getName()+" ---withInitial---> "+threadLocal.get());
        }
        public void run(){
            System.out.println(Thread.currentThread().getName()+" ---withInitial---> "+threadLocal.get());
        }
    }
}

