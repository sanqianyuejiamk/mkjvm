package com.mengka.jvm.mkstackoverflowerror;

/**
 * ����ջ��С������: -Xss1K<br>
 * ���к󣬳���StackOverFlowError���󣬳����˷���ջ�Ĵ�С
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
			 * ���iС��1000����һֱ�ݹ�����
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
