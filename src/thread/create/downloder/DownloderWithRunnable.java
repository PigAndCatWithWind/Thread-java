package thread.create.downloder;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/1/30下午7:42
 * @描述
 */
public class DownloderWithRunnable {
    public void downloder(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class R implements Runnable{
    String url;
    String name;
    public R(String url,String name){
        this.name = name;
        this.url = url;
    }
    @Override
    public void run() {
        DownloderWithRunnable downloder = new DownloderWithRunnable();
        downloder.downloder(url,name);
    }

    public static void main(String[] args) {
        new Thread(
                new R("http://pic1.win4000.com/mobile/b/5580de7e23eb1.jpg","OnePiece.jpg")
        ).start();
        new Thread(
                new R("http://pic1.win4000.com/mobile/3/557a4223d8dc2.jpg","zombie.jpg")
        ).start();
        new Thread(
                new R("http://pic1.win4000.com/mobile/6/5216dbb7f2480.jpg","exorcism.jpg")
        ).start();
    }
}
