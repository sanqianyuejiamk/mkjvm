package mengka.mkclassloader_01;

import java.net.URL;

/**
 * Bootstrap ClassLoader
 * <p/>
 * 》》启动类加载器；
 * <p/>
 * 》》是Java类加载层次中最顶层的类加载器，负责加载JDK中的核心类库，如：rt.jar、resources.jar、charsets.jar等；
 * <p/>
 * Created by xiafeng
 * on 16-2-23.
 */
public class classloader_01 {

    public static void main(String[] args) {

        /**
         *  法①：
         *     获取启动类加载器，Bootstrap ClassLoader加载的JDK中的核心类库
         */
        String jarPath = System.getProperty("sun.boot.class.path");
        System.out.println("jarPath = " + jarPath);

        /**
         *  法②：
         *     获取Bootstrap ClassLoader加载的JDK中的核心类库
         */
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }
    }
}
