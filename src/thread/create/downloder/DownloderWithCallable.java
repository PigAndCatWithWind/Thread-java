package thread.create.downloder;

import org.apache.commons.io.FileUtils;

import javax.jnlp.ExtendedService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/1/30下午7:42
 * @描述
 */
public class DownloderWithCallable {
    public void downloder(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class C implements Callable{

    String url;
    String name;
    public C(String url,String name){
        this.name = name;
        this.url = url;
    }
    @Override
    public Object call() throws Exception {
        DownloderWithCallable downloderWithCallable = new DownloderWithCallable();
        downloderWithCallable.downloder(url,name);
        return true;
    }

    public static void main(String[] args) {
        C c1 = new C("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fi.17173cdn.com%2F2fhnvk%2FYWxqaGBf%2Fcms3%2FrGdIXRbmCnsABei.jpg&refer=http%3A%2F%2Fi.17173cdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1614600004&t=06f13384e5d32b4cdee7fd5615f0cbc0","c1.jpg");
        C c2 = new C("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fi.17173cdn.com%2F2fhnvk%2FYWxqaGBf%2Fcms3%2FrGdIXRbmCnsABei.jpg&refer=http%3A%2F%2Fi.17173cdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1614600004&t=06f13384e5d32b4cdee7fd5615f0cbc0","c2.jpg");
        C c3 = new C("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fi.17173cdn.com%2F2fhnvk%2FYWxqaGBf%2Fcms3%2FrGdIXRbmCnsABei.jpg&refer=http%3A%2F%2Fi.17173cdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1614600004&t=06f13384e5d32b4cdee7fd5615f0cbc0","c3.jpg");
//        ExecutorService service = Executor.newFixedThreadPool(3)
    }
}