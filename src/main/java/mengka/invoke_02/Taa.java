package mengka.invoke_02;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 性能对比： 直接执行、反射执行
 * <hr>
 * 启动参数：-server -Xms128m -Xmx128m <br>
 * <br>
 * 禁止jit编译： -server -Xms128m -Xmx128m -Xint <br>
 * <br>
 * OSR编译：<br>
 * 当循环代码体部分执行次数超过一次的阀值后，只在循环代码体部分就会只执行编译后的机器码，其他部分仍然是解释执行；<br>
 * -server模式下，阀值＝10700；
 * <ul>
 * <li>执行机器码明显执行速度上，会比解释执行要快；</li>
 * <li>解释执行比编译执行更节省内存；</li>
 * <li>server模式下，这种方式是根据运行状况来进行动态编译，将经常调用的代码编译成机器码，提升执行速度，在解释执行和动态编译之间选取了一个权衡值；</li>
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

		// 保证反射能生成字节码，及相关的测试代码能够被JIT编译
		for (int i = 0; i < 20; i++) {
			taa.testDirectCall();
			taa.testCacheMethodCall();
			taa.testNoCacheMethodCall();
		}

		/**
		 * 例一： 直接调用，2ms <br>
		 * 禁止jit编译：103ms
		 */
		long aaBeginTime = System.currentTimeMillis();
		taa.testDirectCall();
		long aaEndTime = System.currentTimeMillis();
		System.out.println("直接调用消耗的时间为：" + (aaEndTime - aaBeginTime) + "ms");

		/**
		 * 例二： 没有缓存的反射调用，5ms <br>
		 * 禁止jit编译：167ms
		 */
		long bbBeginTime = System.currentTimeMillis();
		taa.testNoCacheMethodCall();
		long bbEndTime = System.currentTimeMillis();
		System.out.println("不缓存method，反射调用消耗的时间为：" + (bbEndTime - bbBeginTime)
				+ "ms");

		/**
		 * 例三： 缓存的反射调用，3ms <br>
		 * 禁止jit编译：117ms
		 */
		long ccBeginTime = System.currentTimeMillis();
		taa.testCacheMethodCall();
		long ccEndTime = System.currentTimeMillis();
		System.out.println("缓存method，反射调用消耗的时间为：" + (ccEndTime - ccBeginTime)
				+ "ms");

	}

	/**
	 * 直接调用
	 * 
	 */
	public void testDirectCall() {
		for (int i = 0; i < Constant.JVM_OSR_WARMUP_COUNT; i++) {
			mengka.execute("baicai AAA..");
		}
	}

	/**
	 * 已经缓存了mengka类的execute方法
	 * 
	 * @throws Exception
	 */
	public void testCacheMethodCall() throws Exception {
		for (int i = 0; i < Constant.JVM_OSR_WARMUP_COUNT; i++) {
			method.invoke(mengka, new Object[] { "qingcai AAA.." });
		}
	}

	/**
	 * 不缓存，每次都重新根据方法名获取一次方法
	 * 
	 * @throws Exception
	 */
	public void testNoCacheMethodCall() throws Exception {
		for (int i = 0; i < Constant.JVM_OSR_WARMUP_COUNT; i++) {
			/**
			 * getMethod(methodName,null)相对比较耗性能，一方面是权限的校验，
			 * 另一方面是所有方法的扫描及method对象的复制， 因此，在反射调用多的系统中应缓存getMethod返回的Method对象；
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
