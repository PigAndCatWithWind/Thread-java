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
public class DownloderWithThread {
    public void downloder(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class T extends Thread{
    String url;
    String name;
    public T(String url,String name){
        this.name = name;
        this.url = url;
    }
    @Override
    public void run() {
        DownloderWithThread downloder = new DownloderWithThread();
        downloder.downloder(url,name);
    }

    public static void main(String[] args) {
        T t1 =
                new T("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fi.17173cdn.com%2F2fhnvk%2FYWxqaGBf%2Fcms3%2FrGdIXRbmCnsABei.jpg&refer=http%3A%2F%2Fi.17173cdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1614600004&t=06f13384e5d32b4cdee7fd5615f0cbc0","equinox-flower1.jpg");
        T t2 =
                new T("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=235723995,1695100115&fm=26&gp=0.jpg","equinox-flower2.jpg");
        T t3 =
                new T("https://image.9game.cn/s/9game/g/2020/12/31/197106085.jpg","equinox-flower3.jpg");
        t1.start();
        t2.start();
        t3.start();
    }
}
