package com.mengka.jvm.minor_gc_01;

import static com.sun.btrace.BTraceUtils.freeMemory;
import static com.sun.btrace.BTraceUtils.heapUsage;
import static com.sun.btrace.BTraceUtils.nonHeapUsage;
import static com.sun.btrace.BTraceUtils.print;
import static com.sun.btrace.BTraceUtils.println;
import java.lang.management.MemoryUsage;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnLowMemory;

/**
 *  查看"检查触发"full gc的内存使用情况
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