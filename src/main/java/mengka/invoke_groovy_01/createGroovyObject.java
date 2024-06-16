package mengka.invoke_groovy_01;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyCodeSource;
import groovy.lang.GroovyObject;
import java.io.File;



/**
 * ����һ��groovy�ļ�������groovy����
 * 
 * @author mengka.hyy
 * 
 */
public class createGroovyObject {

	private static GroovyClassLoader groovyClassLoader = new GroovyClassLoader();

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		String path = "src//main//java//mengka//invoke_groovy_01//mengka.groovy";
		String method1 = "baicai";
		String method2 = "qingcai";

		File file = new File(path);
		GroovyObject groovyObject = createGroovyObject(file);
		
		/**
		 *  ����1���� �޲�������ִ��
		 * 
		 */
		groovyObject.invokeMethod(method1, null);
		
		
		/**
		 *  ����2���� ����������ִ��
		 * 
		 */
		Object[] argPath = {"�ײ�A","�ײ�B","�ײ�C"};
		groovyObject.invokeMethod(method1, argPath);
		
		
		/**
		 *  ����3���� ����groovy��������
		 * 
		 */
		groovyObject.setProperty("qingcai", "�����");
		groovyObject.invokeMethod(method2, null);
	}

	
	
	/**
	 *  ��groovy�ļ�ת���ɶ���
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static GroovyObject createGroovyObject(File file) throws Exception {
		String key = file.getAbsolutePath();
		GroovyCodeSource codeSource = new GroovyCodeSource(file, "GBK");
		/**
		 * ���ﲻ��groovy.lang.GroovyClassLoader.parseClass(File)��
		 * ��ΪGroovyCodeSourceĬ��cachable=true
		 */
		Class<?> scriptClass = groovyClassLoader.parseClass(codeSource, false);
		GroovyObject object = (GroovyObject) scriptClass.newInstance();
		return object;
	}
}
