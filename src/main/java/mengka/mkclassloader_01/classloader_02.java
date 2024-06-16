package mengka.mkclassloader_01;

/**
 *  打印ClassLoader类的层次结构
 *
 *  》》自底向上检查类是否已经加载：
 *  sun.misc.Launcher$AppClassLoader@59c87031
 *  sun.misc.Launcher$ExtClassLoader@763dcf03
 *  null，Bootstrap ClassLoader在java中获取不到；
 *
 *  》》自顶向下尝试加载类：
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
         * 打印ClassLoader类的层次结构:
         *  sun.misc.Launcher$AppClassLoader@59c87031
         *  sun.misc.Launcher$ExtClassLoader@763dcf03
         */
        ClassLoader loader = classloader_02.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader);
            loader = loader.getParent(); //获得父类加载器的引用 } System.out.println(loader);
        }
        System.out.println(loader);
    }
}
