package com.mengka.jvm.minor_gc_01;

import java.util.Scanner;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mengka.jvm.common.Constant;

/**
 * 经过minor gc仍然存活的对象，则会被划入旧生代 <br>
 * <br>
 * 》》-XX:MaxTenuringThreshold=2<br>
 * 当经过2次gc，对象仍然存在，则会被划入旧生代中;<br>
 * <br>
 * 》》jvm参数：<br>
 * -Xms20m -Xmx20m -Xmn10m -XX:+UseSerialGC -XX:MaxTenuringThreshold=1<br>
 * <br>
 * <br>
 * 
 * @author mengka.hyy
 * 
 */
public class Taa {

	private static final Log log = LogFactory.getLog(Taa.class);

	private static int count = 1;

	public static void main(String[] args) throws Exception {

		MemoryObject object1 = new MemoryObject(256 * Constant.SIZE_1KB);
		MemoryObject object2 = new MemoryObject(2 * Constant.SIZE_1M);

		/**
		 * step01:
		 * 
		 */
		if (!choose()) {
			return;
		}
		MemoryObject object3 = new MemoryObject(2 * Constant.SIZE_1M);

		/**
		 * step02:
		 */
		if (!choose()) {
			return;
		}
		MemoryObject object4 = new MemoryObject(2 * Constant.SIZE_1M);
		object2 = null;
		object3 = null;

		/**
		 * step03:
		 * 
		 */
		if (!choose()) {
			return;
		}
		byte[] object5 = new byte[2 * Constant.SIZE_1M];

		/**
		 * step04:
		 * 
		 */
		if (!choose()) {
			return;
		}
		object2 = new MemoryObject(2 * Constant.SIZE_1M);
		object3 = new MemoryObject(2 * Constant.SIZE_1M);
		object2 = null;
		object3 = null;
		object5 = null;

		/**
		 * step05:
		 */
		if (choose()) {
			MemoryObject object6 = new MemoryObject(2 * Constant.SIZE_1M);
		}

		Thread.sleep(10000);
	}

	public static boolean choose() {
		boolean result = false;
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("第" + count + "次分配对象： 【1】：yes; 【2】：no ");
			int choose = in.nextInt();
			if (choose != 1) {
				return false;
			}
			result = true;
		} catch (Exception e) {
			log.error("choose error!", e);
		}
		count++;
		return result;
	}

}
