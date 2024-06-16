package com.mengka.jvm.fullgc_01;

import java.util.Scanner;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mengka.jvm.common.Constant;

/**
 * ��������full gc������ڣ�<br>
 * ͳ�Ƶ���minor gc��������������ƽ����С�����ھ�������ʣ��ռ䣻����鴥���� <br>
 * <br>
 * ����jvm������<br>
 * -Xms20m -Xmx20m -Xmn10m -XX:+UseSerialGC<br>
 * <br>
 * �����ڴ������
 * <ul>
 * <li>��������S0+Eden = 9M��-Xmn10m��</li>
 * <li>Eden = 8M</li>
 * <li>S0 = 1M</li>
 * <li>S1 = 1M</li>
 * <li>��������old Gen = 10M</li>
 * </ul>
 * �����鿴gc������gcʱ�䣺<br>
 * jstat -gcutil 16615 2000<br>
 * <br>
 * �����鿴�ڴ�ʹ�ã�<br>
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
		 * ����һ��young gc;<br>
		 * 
		 * eden Gen space 8192K, 28% used<br>
		 * old Gen space 10240K, 40% used<br>
		 */
		Scanner in = new Scanner(System.in);
		System.out.println("�Ƿ񴥷�һ��young gc�� ��1����yes; ��2����no ");
		int choose = in.nextInt();
		if (choose != 1) {
			return;
		}
		byte[] byte3 = new byte[2 * Constant.SIZE_1M];

		/**
		 * �ٷ���һ��<br>
		 * eden Gen space 8192K, 53% used;<br>
		 * old Gen space 10240K, 40% used;<br>
		 */
		if (choose()) {
			byte[] byte4 = new byte[2 * Constant.SIZE_1M];
		}

		/**
		 * �ٷ���һ��<br>
		 * eden Gen space 8192K, 79% used;<br>
		 * old Gen space 10240K, 40% used;<br>
		 */
		if (choose()) {
			byte[] byte5 = new byte[2 * Constant.SIZE_1M];
		}

		/**
		 * step03: <br>
		 * ����full gc��<br>
		 * 
		 * eden Gen space 8192K, 25% used;<br>
		 * old Gen space 10240K, 80% used;<br>
		 */
		if (!choose()) {
			return;
		}

		byte[] byte6 = new byte[2 * Constant.SIZE_1M];

		/**
		 * �ٷ���һ��<br>
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
			System.out.println("�Ƿ����������� ��1����yes; ��2����no ");
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
