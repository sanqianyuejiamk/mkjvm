package com.mengka.jvm.eden_01;

import com.mengka.jvm.common.Constant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Scanner;

/**
 * 》》对象分配：
 * <ul>
 * <li>对象大部分都在新生代上分配；</li>
 * <li>当经过多次gc，对象仍然存在，则会被划入旧生代中；</li>
 * </ul>
 * <br>
 * 》》不在新生代分配的对象：
 * <ul>
 * <li>当分配的对象的大小，超过了Eden Gen的大小时，则在旧生代分配；</li>
 * <li>对象值大小大于该值：-XX:PretenureSizeThreshold=3145728；</li>
 * </ul>
 * <hr>
 * 》》例②：<br>
 * 对象值大小大于该值：-XX:PretenureSizeThreshold=3145728；<br>
 * <br>
 * 
 * 》》jvm参数：<br>
 * -Xms20m -Xmx20m -Xmn10m -XX:PretenureSizeThreshold=3145728 -XX:+UseSerialGC <br>
 * <br>
 * 新生代：10m<br>
 * 旧生代：20m（堆大小） - 10m（新生代） = 10m（旧生代大小）<br>
 * 设置值：-XX:PretenureSizeThreshold=3145728，当新分配的对象大小超过4m的时候，则在旧生代直接分配；<br>
 * <br>
 * 》》查看Eden内存使用：<br>
 * ps -ef|grep java<br>
 * jmap -heap 2181<br>
 * <br><br>
 * @author mengka.hyy
 * 
 */
public class Tbb {

	private static final Log log = LogFactory.getLog(Tbb.class);

	public static void main(String[] args) throws Exception {

		// /**
		// * step01: 分配6M内存，剩余minor = -Xmn10m - 6m = 4m
		// */
		// byte[] byte1 = new byte[2 * Constant.SIZE_1M];
		// byte[] byte2 = new byte[2 * Constant.SIZE_1M];
		// byte[] byte3 = new byte[2 * Constant.SIZE_1M];

		log.info("---------------, start -XX:PretenureSizeThreshold=3145728 ..");
		Thread.sleep(10000);

		/**
		 * step02: choose
		 */
		Scanner in = new Scanner(System.in);
		log.info("是否继续分配一个4m大小的对象： 【1】：yes; 【2】：no ");
		int choose = in.nextInt();
		if (choose != 1) {
			return;
		}

		log.info("---------------, distribute Eden 4m");

		/**
		 * step03: 分配4M内存，剩余Eden < 4m； 对象的大小大于Eden的剩余空间大小，对象直接在旧生代分配；
		 */
		byte[] byte4 = new byte[6 * Constant.SIZE_1M];
		Thread.sleep(10000);
	}

}
