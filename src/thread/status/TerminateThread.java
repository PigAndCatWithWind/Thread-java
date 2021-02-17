package thread.status;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/2/12下午3:38
 * @描述
 */
public class TerminateThread implements Runnable{
    private String name;
    private boolean flag = true;

    public TerminateThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (flag){
            System.out.println(Math.random());
        }
    }

    public void terminateStop(){
        this.flag = false;
    }

    public static void main(String[] args) {
        TerminateThread terminateThread = new TerminateThread("stop");
        new Thread(terminateThread).start();
        for (int i = 0; i <100 ; i++) {
            System.out.println("main -----> "+i);
            if (i==90){
                terminateThread.terminateStop();
                System.out.println("thread is stop");
            }
        }
    }
}
