package mengka.invoke_02;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ���ܶԱȣ� ֱ��ִ�С�����ִ��
 * <hr>
 * ����������-server -Xms128m -Xmx128m <br>
 * <br>
 * ��ֹjit���룺 -server -Xms128m -Xmx128m -Xint <br>
 * <br>
 * OSR���룺<br>
 * ��ѭ�������岿��ִ�д�������һ�εķ�ֵ��ֻ��ѭ�������岿�־ͻ�ִֻ�б����Ļ����룬����������Ȼ�ǽ���ִ�У�<br>
 * -serverģʽ�£���ֵ��10700��
 * <ul>
 * <li>ִ�л���������ִ���ٶ��ϣ���Ƚ���ִ��Ҫ�죻</li>
 * <li>����ִ�бȱ���ִ�и���ʡ�ڴ棻</li>
 * <li>serverģʽ�£����ַ�ʽ�Ǹ�������״�������ж�̬���룬���������õĴ������ɻ����룬����ִ���ٶȣ��ڽ���ִ�кͶ�̬����֮��ѡȡ��һ��Ȩ��ֵ��</li>
 * </ul>
 * <br>
 * <br>
 * 
 * @author mengka.hyy
 * 
 */
public class Taa {

	public static Log log = LogFactory.getLog(Taa.class);

	private Mengka mengka = new Mengka();

	private static Method method = null;

	public static void main(String[] args) throws Exception {

		String methodName = "execute";

		method = Mengka.class.getMethod(methodName,
				new Class<?>[] { String.class });

		Taa taa = new Taa();

		// ��֤�����������ֽ��룬����صĲ��Դ����ܹ���JIT����
		for (int i = 0; i < 20; i++) {
			taa.testDirectCall();
			taa.testCacheMethodCall();
			taa.testNoCacheMethodCall();
		}

		/**
		 * ��һ�� ֱ�ӵ��ã�2ms <br>
		 * ��ֹjit���룺103ms
		 */
		long aaBeginTime = System.currentTimeMillis();
		taa.testDirectCall();
		long aaEndTime = System.currentTimeMillis();
		System.out.println("ֱ�ӵ������ĵ�ʱ��Ϊ��" + (aaEndTime - aaBeginTime) + "ms");

		/**
		 * ������ û�л���ķ�����ã�5ms <br>
		 * ��ֹjit���룺167ms
		 */
		long bbBeginTime = System.currentTimeMillis();
		taa.testNoCacheMethodCall();
		long bbEndTime = System.currentTimeMillis();
		System.out.println("������method������������ĵ�ʱ��Ϊ��" + (bbEndTime - bbBeginTime)
				+ "ms");

		/**
		 * ������ ����ķ�����ã�3ms <br>
		 * ��ֹjit���룺117ms
		 */
		long ccBeginTime = System.currentTimeMillis();
		taa.testCacheMethodCall();
		long ccEndTime = System.currentTimeMillis();
		System.out.println("����method������������ĵ�ʱ��Ϊ��" + (ccEndTime - ccBeginTime)
				+ "ms");

	}

	/**
	 * ֱ�ӵ���
	 * 
	 */
	public void testDirectCall() {
		for (int i = 0; i < Constant.JVM_OSR_WARMUP_COUNT; i++) {
			mengka.execute("baicai AAA..");
		}
	}

	/**
	 * �Ѿ�������mengka���execute����
	 * 
	 * @throws Exception
	 */
	public void testCacheMethodCall() throws Exception {
		for (int i = 0; i < Constant.JVM_OSR_WARMUP_COUNT; i++) {
			method.invoke(mengka, new Object[] { "qingcai AAA.." });
		}
	}

	/**
	 * �����棬ÿ�ζ����¸��ݷ�������ȡһ�η���
	 * 
	 * @throws Exception
	 */
	public void testNoCacheMethodCall() throws Exception {
		for (int i = 0; i < Constant.JVM_OSR_WARMUP_COUNT; i++) {
			/**
			 * getMethod(methodName,null)��ԱȽϺ����ܣ�һ������Ȩ�޵�У�飬
			 * ��һ���������з�����ɨ�輰method����ĸ��ƣ� ��ˣ��ڷ�����ö��ϵͳ��Ӧ����getMethod���ص�Method����
			 */
			Method mengkaMethod = Mengka.class.getMethod("execute",
					new Class<?>[] { String.class });
			mengkaMethod.invoke(mengka, new Object[] { "xigua AAA.." });
		}
	}

	public class Mengka {

		private Map<String, String> caches = new HashMap<String, String>();

		public void execute(String message) {
			String key = this.toString() + message;
			caches.put(key, message);
			// log.info("mengka key = " + key + " , message = " + message);
		}
	}

}
