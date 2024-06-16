package mengka.btrace_01;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnTimer;
import static com.sun.btrace.BTraceUtils.*;

/**
 * 查看内存使用<br><br>
 * 
 * 》》打包<br>
 * mvn assembly:assembly<br>
 * <br>
 * 
 * 》》运行java程序：<br>
 * /System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/bin/java
 * -jar mkjvm-0.0.1-SNAPSHOT-jar-with-dependencies.jar
 * 
 * <hr>
 * btrace命令：<br>
 * btrace 4587 memory_01.java <br>
 * <br>
 * Heap<br>
 * par new generation total 19136K, used 2430K [7f3000000, 7f44c0000, 7f44c0000)
 * <br>
 * eden space 17024K, 14% used [7f3000000, 7f325f9f0, 7f40a0000)<br>
 * from space 2112K, 0% used [7f40a0000, 7f40a0000, 7f42b0000)<br>
 * to space 2112K, 0% used [7f42b0000, 7f42b0000, 7f44c0000)<br>
 * concurrent mark-sweep generation total 63872K, used 0K [7f44c0000, 7f8320000,
 * 7fae00000)<br>
 * concurrent-mark-sweep perm gen total 21248K, used 5570K [7fae00000,
 * 7fc2c0000, 800000000)<br>
 * 
 * @author mengka.hyy
 * 
 */
@BTrace
public class memory_02 {

	@OnTimer(4000)
	public static void printM() {
		// 打印内存信息
		println("-------------, heap:");
		println(heapUsage());
		println("-------------, no-heap:");
		println(nonHeapUsage());
	}
}
