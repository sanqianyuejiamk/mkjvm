package com.mengka.jvm.fullgc_01;

import java.util.Scanner;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mengka.jvm.common.Constant;

/**
 * 》》触发full gc的情况②：<br>
 * 统计到的minor gc晋升到旧生代的平均大小，大于旧生代的剩余空间；（检查触发） <br>
 * <br>
 * 》》jvm参数：<br>
 * -Xms20m -Xmx20m -Xmn10m -XX:+UseSerialGC<br>
 * <br>
 * 》》内存情况：
 * <ul>
 * <li>新生代：S0+Eden = 9M（-Xmn10m）</li>
 * <li>Eden = 8M</li>
 * <li>S0 = 1M</li>
 * <li>S1 = 1M</li>
 * <li>旧生代：old Gen = 10M</li>
 * </ul>
 * 》》查看gc次数和gc时间：<br>
 * jstat -gcutil 16615 2000<br>
 * <br>
 * 》》查看内存使用：<br>
 * btrace 16615 memory_01.java<br>
 * <br>
 * Heap<br>
 * def new generation total 9216K, used 4202K [7f9a00000, 7fa400000, 7fa400000)<br>
 * eden space 8192K, 51% used [7f9a00000, 7f9e14920, 7fa200000)<br>
 * from space 1024K, 2% used [7fa200000, 7fa205fb0, 7fa300000)<br>
 * to space 1024K, 0% used [7fa300000, 7fa300000, 7fa400000)<br>
 * tenured generation total 10240K, used 6651K [7fa400000, 7fae00000, 7fae00000)<br>
 * the space 10240K, 64% used [7fa400000, 7faa7edb0, 7faa7ee00, 7fae00000)<br>
 * compacting perm gen total 21248K, used 6110K [7fae00000, 7fc2c0000,
 * 800000000)<br>
 * the space 21248K, 28% used [7fae00000, 7fb3f7b10, 7fb3f7c00, 7fc2c0000)<br>
 * No shared spaces configured.<br>
 * 
 * <br>
 * 
 * @author mengka.hyyx
 * 
 */
public class Taa {

	private static final Log log = LogFactory.getLog(Taa.class);

	public static void main(String[] args) throws Exception {
		Thread.sleep(5000);
		/**
		 * step01:<br>
		 * eden Gen space 8192K, 85% used<br>
		 * old Gen space 10240K, 0% used<br>
		 */
		byte[] byte1 = new byte[2 * Constant.SIZE_1M];
		byte[] byte2 = new byte[2 * Constant.SIZE_1M];

		/**
		 * step02: <br>
		 * 触发一次young gc;<br>
		 * 
		 * eden Gen space 8192K, 28% used<br>
		 * old Gen space 10240K, 40% used<br>
		 */
		Scanner in = new Scanner(System.in);
		System.out.println("是否触发一次young gc： 【1】：yes; 【2】：no ");
		int choose = in.nextInt();
		if (choose != 1) {
			return;
		}
		byte[] byte3 = new byte[2 * Constant.SIZE_1M];

		/**
		 * 再分配一次<br>
		 * eden Gen space 8192K, 53% used;<br>
		 * old Gen space 10240K, 40% used;<br>
		 */
		if (choose()) {
			byte[] byte4 = new byte[2 * Constant.SIZE_1M];
		}

		/**
		 * 再分配一次<br>
		 * eden Gen space 8192K, 79% used;<br>
		 * old Gen space 10240K, 40% used;<br>
		 */
		if (choose()) {
			byte[] byte5 = new byte[2 * Constant.SIZE_1M];
		}

		/**
		 * step03: <br>
		 * 触发full gc；<br>
		 * 
		 * eden Gen space 8192K, 25% used;<br>
		 * old Gen space 10240K, 80% used;<br>
		 */
		if (!choose()) {
			return;
		}

		byte[] byte6 = new byte[2 * Constant.SIZE_1M];

		/**
		 * 再分配一次<br>
		 * eden Gen space 8192K, 51% used;<br>
		 * old Gen space 10240K, 64% used;<br>
		 */
		if (!choose()) {
			return;
		}
		byte[] byte7 = new byte[2 * Constant.SIZE_1M];

		if (!choose()) {
			return;
		}
		byte[] byte8 = new byte[2 * Constant.SIZE_1M];

		if (!choose()) {
			return;
		}
		byte[] byte9 = new byte[2 * Constant.SIZE_1M];

		if (!choose()) {
			return;
		}
		byte[] byte10 = new byte[2 * Constant.SIZE_1M];

		if (!choose()) {
			return;
		}
		byte[] byte11 = new byte[2 * Constant.SIZE_1M];

		if (!choose()) {
			return;
		}
		byte[] byte12 = new byte[2 * Constant.SIZE_1M];

		if (!choose()) {
			return;
		}
		byte[] byte13 = new byte[2 * Constant.SIZE_1M];

		Thread.sleep(10000);
	}

	public static boolean choose() {
		boolean result = false;
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("是否继续分配对象： 【1】：yes; 【2】：no ");
			int choose = in.nextInt();
			if (choose != 1) {
				return false;
			}
			result = true;
		} catch (Exception e) {
			log.error("choose error!", e);
		}
		return result;
	}

}
