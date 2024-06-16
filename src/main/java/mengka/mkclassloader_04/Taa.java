package mengka.mkclassloader_04;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.lang.reflect.Method;

/**
 *  �Զ���һ��NetworkClassLoader�����ڼ��������ϵ�class�ļ�
 *
 * Created by xiafeng
 * on 16-2-24.
 */
public class Taa {

    private static final Log log = LogFactory.getLog(Taa.class);

    public static void main(String[] args) throws Exception {

        /**
         * step01:
         *     �Զ���������������������ϵ�class
         */
        String rootUrl = "http://127.0.0.1:8089/classes/";
        NetworkClassLoader networkClassLoader = new NetworkClassLoader(rootUrl);

        /**
         * step02��
         *    ����Mengka��ķ����������ؽ��
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
