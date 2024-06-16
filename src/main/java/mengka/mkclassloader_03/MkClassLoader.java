package mengka.mkclassloader_03;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * ��չClassLoader����<br>
 * ����Ŀ���Ǵӱ����ļ�ϵͳʹ������ʵ�ֵ���װ����װ��һ���ࡣ
 * <hr>
 * Ϊ�˴����Լ�����װ��������Ӧ����չClassLoader�࣬����һ�������� �����Ǵ���һ��FileClassLoader extends
 * ClassLoader��������Ҫ����ClassLoader�е�findClass(String
 * name)�������������ͨ��������ֶ��õ�һ��Class����
 * 
 * @author mengka.hyy
 * 
 */
public class MkClassLoader extends ClassLoader {

	/**
	 * ����ClassLoader�е�findClass(String name)�������������ͨ��������ֶ��õ�һ��Class����
	 * 
	 */
	public Class findClass(String name) {
		byte[] data = loadClassData(name);
		return defineClass(name, data, 0, data.length);
	}

	/**
	 * ���ǻ�Ӧ���ṩһ������loadClassData(String name)��ͨ��������Ʒ���class�ļ�����
	 * �����顣Ȼ��ʹ��ClassLoader�ṩ��defineClass()�������ǾͿ��Է���Class�����ˡ�
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
