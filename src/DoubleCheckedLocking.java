/**
 * @创建人 PigAndCatWithWind
 * @创建时间 2021/2/16下午4:14
 * @描述
 *  单例模式
 *
 * 1. 构造器私有化 ---> 避免外部new构造器
 * 2. 提供私有的静态属性 ---> 存储对象的地址
 * 3. 提供公共的静态方法  ---> 获取属性
 */
public class DoubleCheckedLocking {
//    * 1. 构造器私有化 ---> 避免外部new构造器
    private DoubleCheckedLocking(){}
//    * 2. 提供私有的静态属性 ---> 存储对象的地址
    private volatile static DoubleCheckedLocking instance;
//    * 3. 提供公共的静态方法  ---> 获取属性
    public static DoubleCheckedLocking getInstance(){
        if (null != instance)
            return instance;
        synchronized (DoubleCheckedLocking.class){
            if (null == instance)
                instance = new DoubleCheckedLocking();
        }
        return instance;
    }
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(DoubleCheckedLocking.getInstance());
        }).start();
        System.out.println(DoubleCheckedLocking.getInstance());
    }
}
