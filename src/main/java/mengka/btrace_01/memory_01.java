package mengka.btrace_01;

import java.lang.management.MemoryUsage;
import static com.sun.btrace.BTraceUtils.*;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnLowMemory;

/**
 * º‡øÿƒ⁄¥Ê π”√
 * 
 * <hr>
 * btrace√¸¡Ó£∫<br>
 * btrace 4587 memory_01.java 
 * <br><br>
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
public class memory_01 {

	@OnLowMemory(pool = "Tenured Gen", threshold = 6000000)
	public static void printMem(MemoryUsage mu) {
		print("MemoryUsage : ");
		println(mu);
		print("FreeMem : ");
		println(freeMemory());
		print("Heap:");
		println(heapUsage());
		print("Non-Heap:");
		println(nonHeapUsage());
	}
}
