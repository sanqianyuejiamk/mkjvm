package mengka.OSR_01;

/**
 * OSR编译，只在循环体的代码部分执行编译后的代码，其他代码仍是解释执行
 * <hr>
 * <br>
 *   compileThreshold*(onStackReplacePercentage - InterpreterProfilePercentage)/100
 * <br><br>
 *     = 10000*(140 - 33)/100
 * <br><br>
 *      = 10700
 * <br><br>
 * <ul>
 *    <li>回边计数器： 一段代码的执行次数，当次数到达10700次时，就会触发OSR编译;</li>
 *    <li>方法计数器：compileThreshold，默认是10000，当回边计数到达10700时，就会将compileThreshold变成10000</li>  
 * </ul>
 * <hr>
 * 差不多在第三次，调用bar()的时候，就会完成JIT编译，所以观察结果可以发现，超过1s的时间的都是出现在i=1,2,3的时候，尤其是第三次出现的概率最大
 *  <ul>
 *    <li>性能测试时：高性能测试时，在事先做好足够的调用次数，以保证测试是公平的；</li>
 *    <li>程序性能: 一些关键功能，在事先自行进行一定的调用，以保证关键功能性能；</li>
 *  </ul>
 * @author mengka.hyy
 * 
 */
public class OSR_01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		OSR_01 a = new OSR_01();

		/**
		 * 在第i=1次，执行结束的时候，
		 * 
		 * 回边计数器 = 10700(次),触发OSR编译，
		 * 
		 * bar()方法调用
		 * 
		 */
		for (int i = 0; i < 10; i++) {

			long start = System.currentTimeMillis();

			a.bar();

			long endTime = System.currentTimeMillis();
			System.out.println(endTime - start);
		}
	}

	
	/**
	 *  方法bar()里面的这段代码重复执行超过了最大阀值之后，<br>
	 *   就会触发OSR编译，使循环的那部分代码，在以后执行的时候，都是执行编译后的代码；
	 */
	public void bar() {

		// bar code
		for (int i = 0; i < 10700; i++) {
			bar2();
		}

	}

	/**
	 * bar2()的方法计数器： <br>
	 * CompileThreshold = 10000<br>
	 * <hr>
	 *  当回边计数到达阀值的时候，就会使CompileThreshold = 10000
	 * 
	 */
	public void bar2() {
		// bar2 code
	}
}
