package mengka.mkclassloader_01;

import java.io.File;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLClassLoader;

/**
 *  classLoader例子，还需要深入学习
 * 
 * @author mengka.hyy
 * 
 */
public class MkClassLoader_01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{

		URL agentJar = new File("").toURI().toURL();

	}
	
	
	/**
	 *  从聚石的com.github.zhongl.housemd.duck.Duck中，拷贝过来的代码<br>
	 *  【参考】
	 * 
	 * @param arguments
	 * @param instrumentation
	 * @throws Exception
	 */
	 public static void agentmain(String arguments, Instrumentation instrumentation) throws Exception {
	        String[] parts = arguments.split("\\s+", 4);
	        URL agentJar = new File(parts[0]).toURI().toURL();
	        String telephoneClassName = parts[1];
	        int port = Integer.parseInt(parts[2]);

	        ClassLoader classLoader = new URLClassLoader(new URL[]{agentJar}) {
	            @Override
	            protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
	                Class<?> loadedClass = findLoadedClass(name);
	                if (loadedClass != null) return loadedClass;

	                try {
	                    Class<?> aClass = findClass(name);
	                    if (resolve) resolveClass(aClass);
	                    return aClass;
	                } catch (Exception e) {
	                    return super.loadClass(name, resolve);
	                }
	            }
	        };

	        Class<?>[] commandClasses = loadClasses(parts[3].split("\\s+"), classLoader);

	        Runnable executor = (Runnable) classLoader.loadClass(telephoneClassName)
	                .getConstructor(Instrumentation.class, int.class, Class[].class)
	                .newInstance(instrumentation, port, commandClasses);

	        Thread thread = new Thread(executor, "HouseMD-Duck");
	        thread.setDaemon(true);
	        thread.start();
	    }
	 
	 private static Class<?>[] loadClasses(String[] classNames, ClassLoader classLoader) throws ClassNotFoundException {
	        Class<?>[] classes = (Class<?>[]) Array.newInstance(Class.class, classNames.length);
	        for (int i = 0; i < classes.length; i++) {
	            classes[i] = Class.forName(classNames[i], false, classLoader);
	        }
	        return classes;
	    }

}
