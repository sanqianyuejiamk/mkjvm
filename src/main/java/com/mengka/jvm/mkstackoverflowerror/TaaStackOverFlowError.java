package com.mengka.jvm.mkstackoverflowerror;

/**
 * 方法栈大小的设置: -Xss1K<br>
 * 运行后，出现StackOverFlowError错误，超出了方法栈的大小
 * 
 * @author mengka
 * 
 */
public class TaaStackOverFlowError {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new Thread(new Runnable() {

			public void run() {
				loop(0);
			}

			/**
			 * 如果i小于1000，则一直递归增加
			 * 
			 * @param i
			 */
			private void loop(int i) {
				if (i != 1000) {
					System.out.println("i =" + i);
					i++;
					loop(i);
				} else {
					return;
				}
			}
		}).start();

		// aaThread.run();

	}

}
