package mengka.mkclassloader_03;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 扩展ClassLoader方法<br>
 * 我们目的是从本地文件系统使用我们实现的类装载器装载一个类。
 * <hr>
 * 为了创建自己的类装载器我们应该扩展ClassLoader类，这是一个抽象类 。我们创建一个FileClassLoader extends
 * ClassLoader。我们需要覆盖ClassLoader中的findClass(String
 * name)方法，这个方法通过类的名字而得到一个Class对象。
 * 
 * @author mengka.hyy
 * 
 */
public class MkClassLoader extends ClassLoader {

	/**
	 * 覆盖ClassLoader中的findClass(String name)方法，这个方法通过类的名字而得到一个Class对象。
	 * 
	 */
	public Class findClass(String name) {
		byte[] data = loadClassData(name);
		return defineClass(name, data, 0, data.length);
	}

	/**
	 * 我们还应该提供一个方法loadClassData(String name)，通过类的名称返回class文件的字
	 * 节数组。然后使用ClassLoader提供的defineClass()方法我们就可以返回Class对象了。
	 * 
	 * @param name
	 * @return
	 */
	@SuppressWarnings("resource")
	public byte[] loadClassData(String name) {
		FileInputStream fis = null;
		byte[] data = null;
		try {
			fis = new FileInputStream(new File("file://F:/work_hyy/mkjvm/target/classes/" + name + ".class"));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int ch = 0;
			while ((ch = fis.read()) != -1) {
				baos.write(ch);

			}
			data = baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}

}
