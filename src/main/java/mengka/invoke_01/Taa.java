package mengka.invoke_01;

import java.lang.reflect.Method;

/**
 *  ���÷�������ִ�з������õĴ��룺<br>
 *     �����Ĺ��̡��������õĹ���ʱ��̬��<font color="red">����̬�����ֽ��룬�����ص�jvm��ִ�У�</font>
 *  <hr>
 *  ����ֱ�ӵ���ʵ��������룬�Ǳ����ֱ�����ɶ��󷽷����õ��ֽ��룻������ִ�еĻ�����ֻ�����ɵ���jvm����ʵ�ֵ��ֽ��룻
 * <br><br>
 *  ���ַ�ʽ���ڿ��֮��Ĵ�����Էǳ���Ҫ��<br>
 *  <br><br>
 * 
 * @author mengka.hyy
 *
 */
public class Taa {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws Exception{
		
		//ʹ�õ��������ڵ�classLoader�����ش�������class����
		Class actionClass = Class.forName("mengka.invoke_01.Mengka");	
		Object object = actionClass.newInstance();
		
		/**
		 * ��һ��
		 *    ����ʵ����mengka�е�execute()
		 */
		Method method = actionClass.getMethod("execute", null);
		method.invoke(object, null);

		/**
		 * ������
		 *    ����ʵ����mengka�е�execute()
		 */
		Mengka mengka = (Mengka)object;
		mengka.execute();
		
		/**
		 *  ������
		 *    ����ʵ����mengka�е�execute() 
		 */
		String className = "mengka.invoke_01.Mengka";
		String methodName = "execute";
		invoke(className, methodName);
	}

	/**
	 *  ����java�࣬��ִ��methodName����
	 *  <hr>
	 *  getMethod(methodName, null)��ԱȽϺ����ܣ�һ������Ȩ�޵�У�飬��һ���������з�����ɨ�輰method����ĸ��ƣ�
	 *  ��ˣ��ڷ�����ö��ϵͳ��Ӧ����getMethod���ص�Method����<br>
	 *  <br>
	 *  method.invoke(object, null)�����������ֱ�ӵ��õ�һ�㣻<br>
	 *  <br>
	 * 
	 * @param className "mengka.invoke_01.Mengka"
	 * @param methodName "execute"
	 * @throws Exception
	 */
	public static void invoke(String className,String methodName)throws Exception{
		Class actionClass = Class.forName(className);	
		Object object = actionClass.newInstance();
		Method method = actionClass.getMethod(methodName, null);//��Ҫ����getMethod���ص�Method����
		method.invoke(object, null);
	}
}
