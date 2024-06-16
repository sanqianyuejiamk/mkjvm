package mengka.monitor.gc;

/**
 * 
 * 【-Xms40M -Xmx40M -Xmn16M -verbose:gc -XX:+PrintGCDetails】<br>
 * -Xmn16M : 16M新生代内存<br>
 * Eden内存 ： <br>
 * 16M = Eden/S0 = 12m/2m = .. 【默认比例是8，但这里是6】<br>
 * 旧生代内存 = 40m - 16m =24m<br>
 * <hr>
 * 【例】：在Eden space不足的时候，发生monitor GC的情况<br>
 * [GC [DefNew: 12551K->152K(14784K), 0.0029062 secs] 12551K->152K(39360K),
 * 0.0029565 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] <font
 * color="red">
 * <h2>查看GC时内存情况： jstat -gcutil [pid]1000</h2> </font>
 * <hr>
 * 分配1.0M内存<br>
 * 分配1.0M内存<br>
 * 分配1.0M内存<br>
 * 分配1.0M内存<br>
 * 分配1.0M内存<br>
 * 分配1.0M内存<br>
 * 分配1.0M内存<br>
 * 分配1.0M内存<br>
 * 分配1.0M内存<br>
 * 分配1.0M内存<br>
 * 分配1.0M内存<br>
 * 分配1.0M内存<br>
 * [GC [ParNew: 12583K->408K(14784K), 0.0021804 secs] 12583K->408K(39360K),
 * 0.0043024 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] <br>
 * 开始 minor GC!<br>
 * 分配1.0M内存<br>
 * 分配1.0M内存<br>
 * 分配1.0M内存<br>
 * 分配1.0M内存<br>
 * 分配1.0M内存<br>
 * 分配1.0M内存<br>
 * 分配1.0M内存<br>
 * 分配1.0M内存<br>
 * 分配1.0M内存<br>
 * 分配1.0M内存<br>
 * 分配1.0M内存<br>
 * 分配1.0M内存<br>
 * [GC [ParNew: 13106K->562K(14784K), 0.0006075 secs] 13106K->562K(39360K),
 * 0.0006425 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]<br>
 * 开始 minor GC!<br>
 * 分配1.0M内存<br>
 * 分配1.0M内存<br>
 * Heap<br>
 * par new generation total 14784K, used 4257K [7f8600000, 7f9600000, 7f9600000)
 * <br>
 * eden space 13184K, 28% used [7f8600000, 7f899be28, 7f92e0000)<br>
 * from space 1600K, 35% used [7f92e0000, 7f936c820, 7f9470000)<br>
 * to space 1600K, 0% used [7f9470000, 7f9470000, 7f9600000)<br>
 * concurrent mark-sweep generation total 24576K, used 0K [7f9600000, 7fae00000,
 * 7fae00000)<br>
 * concurrent-mark-sweep perm gen total 21248K, used 5085K [7fae00000,
 * 7fc2c0000, 800000000)<br>
 * <br>
 * 
 * @author mengka
 * 
 */
public class MinorGC_01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		while (true) {
			for (int i = 0; i < 2; i++) {

				happenMinorGC(12);
				Thread.sleep(2000);

			}

			/**
			 * 在这句之前，已经占满了12M的Eden空间，所以在下面这句的时候，发生了monitor GC
			 */
			MemoryObject aaObject = new MemoryObject(1024 * 1024);

			MemoryObject bbObject = new MemoryObject(1024 * 1024);

		}
	}

	/**
	 * 产生aaIndex兆的内存，但是在最后一个产生之前，打印GC开始的提示String
	 * 
	 * @param aaIndex
	 * @throws Exception
	 */
	private static void happenMinorGC(int aaIndex) throws Exception {

		for (int i = 0; i < aaIndex; i++) {

			// 在Eden中，分配1M的对象
			new MemoryObject(1024 * 1024);

			/**
			 * 当12m的Eden内存被占满的时候
			 */
			if (i == aaIndex - 1) {
				Thread.sleep(2000);
				System.out.println("开始 minor GC!");
			}
		}
	}

}
