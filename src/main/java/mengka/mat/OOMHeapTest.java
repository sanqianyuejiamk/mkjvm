package mengka.mat;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 【heap dump】,堆溢出
 * <br><br>
 * 上面构造了很多的Pilot类实例，向数组和map中放。
 * <font color="red">由于是Strong Ref，GC自然不会回收这些对象</font>，一直放在heap中直到溢出。当然在运行前，先要在Eclipse中配置VM参数
 * -XX:+HeapDumpOnOutOfMemoryError。好了，一会儿功夫内存溢出，控制台打出如下信息。
 * <hr>
 * java.lang.OutOfMemoryError: Java heap space <br>
 * Dumping heap to java_pid3600.hprof <br>
 * Heap dump file created [78233961 bytes in 1.995 secs]<br>
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space<br>
 * 
 * <img src="http://img03.taobaocdn.com/imgextra/i1/14648030296751089/T2dcisXqhXXXXXXXXX_!!443534648-2-shop_backyard.png"/>
 * 
 * @author mengka.hyy
 * 
 */
public class OOMHeapTest {
	public static void main(String[] args) {
		oom();
	}

	private static void oom() {
		Map<String, Pilot> map = new HashMap<String, Pilot>();
		Object[] array = new Object[1000000];
		for (int i = 0; i < 1000000; i++) {
			String d = new Date().toString();
			Pilot p = new Pilot(d, i);
			map.put(i + "rosen jiang", p);
			array[i] = p;
		}
	}
}
