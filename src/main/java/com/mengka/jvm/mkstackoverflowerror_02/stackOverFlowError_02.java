package com.mengka.jvm.mkstackoverflowerror_02;

/**
 * 快速排序，递归方法调用次数太多，导致方法栈溢出 <br>
 * <br>
 * 【-Xss默认大小】：<br>
 * JDK5.0以后每个线程堆栈大小为1M,以前每个线程堆栈大小为256K<br>
 * <br>
 * 【解决】：<br>
 * 将方法栈大小调整为2M，-Xss1M
 * <hr>
 * Exception in thread "main" java.lang.StackOverflowError<br>
 * at com.mengka.jvm.mkstackoverflowerror_02.QuicksortUtil.quicksort(
 * QuicksortUtil.java:19)<br>
 * at com.mengka.jvm.mkstackoverflowerror_02.QuicksortUtil.quicksort(
 * QuicksortUtil.java:22)<br>
 * at com.mengka.jvm.mkstackoverflowerror_02.QuicksortUtil.quicksort(
 * QuicksortUtil.java:22)<br>
 * at com.mengka.jvm.mkstackoverflowerror_02.QuicksortUtil.quicksort(
 * QuicksortUtil.java:23)<br>
 * at com.mengka.jvm.mkstackoverflowerror_02.QuicksortUtil.quicksort(
 * QuicksortUtil.java:22)<br>
 * at com.mengka.jvm.mkstackoverflowerror_02.QuicksortUtil.quicksort(
 * QuicksortUtil.java:23)<br>
 * at com.mengka.jvm.mkstackoverflowerror_02.QuicksortUtil.quicksort(
 * QuicksortUtil.java:22)<br>
 * at com.mengka.jvm.mkstackoverflowerror_02.QuicksortUtil.quicksort(
 * QuicksortUtil.java:23)<br>
 * <br>
 * 
 * @author mengka.hyy
 * 
 */
public class stackOverFlowError_02 {

	public static void main(String[] args) {

		int[] aa = new int[10000];
		for (int i = 0; i < 10000; i++) {
			aa[i] = 10000 - i;
		}

		int low = 0;
		int high = aa.length - 1;

		/**
		 * 递归次数太多，导致方法栈溢出
		 */
		QuicksortUtil.quicksort(aa, low, high);

		for (int i = 0; i < aa.length; i++) {
			System.out.print(aa[i] + ",");
		}
	}

}
