package mengka.invoke_01;

import java.lang.reflect.Method;

/**
 *  采用反射生成执行方法调用的代码：<br>
 *     创建的过程、方法调用的过程时动态的<font color="red">（动态生成字节码，并加载到jvm中执行）</font>
 *  <hr>
 *  区别：直接调用实例对象代码，是编译后直接生成对象方法调用的字节码；但反射执行的话，是只能生成调用jvm反射实现的字节码；
 * <br><br>
 *  这种方式对于框架之类的代码而言非常重要；<br>
 *  <br><br>
 * 
 * @author mengka.hyy
 *
 */
public class Taa {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws Exception{
		
		//使用调用者所在的classLoader来加载创建出的class对象
		Class actionClass = Class.forName("mengka.invoke_01.Mengka");	
		Object object = actionClass.newInstance();
		
		/**
		 * 法一：
		 *    调用实现类mengka中的execute()
		 */
		Method method = actionClass.getMethod("execute", null);
		method.invoke(object, null);

		/**
		 * 法二：
		 *    调用实现类mengka中的execute()
		 */
		Mengka mengka = (Mengka)object;
		mengka.execute();
		
		/**
		 *  法三：
		 *    调用实现类mengka中的execute() 
		 */
		String className = "mengka.invoke_01.Mengka";
		String methodName = "execute";
		invoke(className, methodName);
	}

	/**
	 *  加载java类，并执行methodName方法
	 *  <hr>
	 *  getMethod(methodName, null)相对比较耗性能，一方面是权限的校验，另一方面是所有方法的扫描及method对象的复制，
	 *  因此，在反射调用多的系统中应缓存getMethod返回的Method对象；<br>
	 *  <br>
	 *  method.invoke(object, null)的性能则仅比直接调用低一点；<br>
	 *  <br>
	 * 
	 * @param className "mengka.invoke_01.Mengka"
	 * @param methodName "execute"
	 * @throws Exception
	 */
	public static void invoke(String className,String methodName)throws Exception{
		Class actionClass = Class.forName(className);	
		Object object = actionClass.newInstance();
		Method method = actionClass.getMethod(methodName, null);//需要缓存getMethod返回的Method对象
		method.invoke(object, null);
	}
}
