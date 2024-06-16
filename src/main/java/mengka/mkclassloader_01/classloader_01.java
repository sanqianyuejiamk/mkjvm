package mengka.mkclassloader_01;

import java.net.URL;

/**
 * Bootstrap ClassLoader
 * <p/>
 * �����������������
 * <p/>
 * ������Java����ز������������������������JDK�еĺ�����⣬�磺rt.jar��resources.jar��charsets.jar�ȣ�
 * <p/>
 * Created by xiafeng
 * on 16-2-23.
 */
public class classloader_01 {

    public static void main(String[] args) {

        /**
         *  ���٣�
         *     ��ȡ�������������Bootstrap ClassLoader���ص�JDK�еĺ������
         */
        String jarPath = System.getProperty("sun.boot.class.path");
        System.out.println("jarPath = " + jarPath);

        /**
         *  ���ڣ�
         *     ��ȡBootstrap ClassLoader���ص�JDK�еĺ������
         */
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }
    }
}
