package com.mengka.jvm.eden_01;

import com.mengka.jvm.common.Constant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Scanner;

/**
 * ����������䣺
 * <ul>
 * <li>����󲿷ֶ����������Ϸ��䣻</li>
 * <li>���������gc��������Ȼ���ڣ���ᱻ����������У�</li>
 * </ul>
 * <br>
 * ������������������Ķ���
 * <ul>
 * <li>������Ķ���Ĵ�С��������Eden Gen�Ĵ�Сʱ�����ھ��������䣻</li>
 * <li>����ֵ��С���ڸ�ֵ��-XX:PretenureSizeThreshold=3145728��</li>
 * </ul>
 * <hr>
 * �������٣�<br>
 * ������Ķ���Ĵ�С��������Eden Gen�Ĵ�Сʱ�����ھ���������;<br>
 * <br>
 * 
 * ����jvm������<br>
 * -Xms20m -Xmx20m -Xmn10m -XX:+UseSerialGC <br>
 * <br>
 * ��������10m<br>
 * ��������20m���Ѵ�С�� - 10m���������� = 10m����������С��<br>
 * <br>
 * �����鿴Eden�ڴ�ʹ�ã�<br>
 * ps -ef|grep java<br>
 * jmap -heap 2181<br>
 * <br><br>
 * @author mengka.hyy
 * 
 */
public class Taa {

	private static final Log log = LogFactory.getLog(Taa.class);

	public static void main(String[] args) throws Exception {

		/**
		 * step01: ����6M�ڴ棬ʣ��minor = -Xmn10m - 6m = 4m
		 */
		byte[] byte1 = new byte[2 * Constant.SIZE_1M];
		byte[] byte2 = new byte[2 * Constant.SIZE_1M];
		byte[] byte3 = new byte[2 * Constant.SIZE_1M];

		Thread.sleep(10000);
		log.info("---------------, distribute Eden 6m , free minor Gen 4m..");

		/**
		 * step02: choose
		 */
		Scanner in = new Scanner(System.in);
		log.info("�Ƿ��������һ��6m��С�Ķ��� ��1����yes; ��2����no ");
		int choose = in.nextInt();
		if (choose != 1) {
			return;
		}

		log.info("---------------, distribute Eden 6m");

		/**
		 * step03: ����6M�ڴ棬ʣ��Eden < 6m�� ����Ĵ�С����Eden��ʣ��ռ��С������ֱ���ھ��������䣻
		 */
		byte[] byte4 = new byte[6 * Constant.SIZE_1M];
		Thread.sleep(10000);
	}

}
