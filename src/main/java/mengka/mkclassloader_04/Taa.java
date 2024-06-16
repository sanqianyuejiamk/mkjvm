package mengka.mkclassloader_04;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.lang.reflect.Method;

/**
 *  自定义一个NetworkClassLoader，用于加载网络上的class文件
 *
 * Created by xiafeng
 * on 16-2-24.
 */
public class Taa {

    private static final Log log = LogFactory.getLog(Taa.class);

    public static void main(String[] args) throws Exception {

        /**
         * step01:
         *     自定义类加载器，加载网络上的class
         */
        String rootUrl = "http://127.0.0.1:8089/classes/";
        NetworkClassLoader networkClassLoader = new NetworkClassLoader(rootUrl);

        /**
         * step02：
         *    调用Mengka类的方法，并返回结果
         */
        String classname = "mengka.mkclassloader_02.Mengka";
        Class clazz = networkClassLoader.loadClass(classname);
        Object obj = clazz.newInstance();
        Method method = clazz.getMethod("baicai", null);
        String result = (String)method.invoke(obj,null);
        log.info("---------, result = "+result);

        log.info("---------, classLoader = "+clazz.getClassLoader());
    }

}
