package mengka.invoke_groovy_01;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyCodeSource;
import groovy.lang.GroovyObject;
import java.io.File;



/**
 * 根据一个groovy文件，创建groovy对象
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
		 *  【例1】： 无参数方法执行
		 * 
		 */
		groovyObject.invokeMethod(method1, null);
		
		
		/**
		 *  【例2】： 带参数方法执行
		 * 
		 */
		Object[] argPath = {"白菜A","白菜B","白菜C"};
		groovyObject.invokeMethod(method1, argPath);
		
		
		/**
		 *  【例3】： 设置groovy方法属性
		 * 
		 */
		groovyObject.setProperty("qingcai", "大青菜");
		groovyObject.invokeMethod(method2, null);
	}

	
	
	/**
	 *  将groovy文件转化成对象
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static GroovyObject createGroovyObject(File file) throws Exception {
		String key = file.getAbsolutePath();
		GroovyCodeSource codeSource = new GroovyCodeSource(file, "GBK");
		/**
		 * 这里不用groovy.lang.GroovyClassLoader.parseClass(File)，
		 * 因为GroovyCodeSource默认cachable=true
		 */
		Class<?> scriptClass = groovyClassLoader.parseClass(codeSource, false);
		GroovyObject object = (GroovyObject) scriptClass.newInstance();
		return object;
	}
}
