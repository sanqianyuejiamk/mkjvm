package mengka.mkclassloader_01;

/**
 *  ��ӡClassLoader��Ĳ�νṹ
 *
 *  �����Ե����ϼ�����Ƿ��Ѿ����أ�
 *  sun.misc.Launcher$AppClassLoader@59c87031
 *  sun.misc.Launcher$ExtClassLoader@763dcf03
 *  null��Bootstrap ClassLoader��java�л�ȡ������
 *
 *  �����Զ����³��Լ����ࣺ
 *  Bootstrap ClassLoader
 *  sun.misc.Launcher$ExtClassLoader@763dcf03
 *  sun.misc.Launcher$AppClassLoader@59c87031
 *
 * Created by xiafeng
 * on 16-2-24.
 */
public class classloader_02 {

    public static void main(String[] args) {
        /**
         * ��ӡClassLoader��Ĳ�νṹ:
         *  sun.misc.Launcher$AppClassLoader@59c87031
         *  sun.misc.Launcher$ExtClassLoader@763dcf03
         */
        ClassLoader loader = classloader_02.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader);
            loader = loader.getParent(); //��ø�������������� } System.out.println(loader);
        }
        System.out.println(loader);
    }
}
