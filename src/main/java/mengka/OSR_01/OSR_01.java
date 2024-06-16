package mengka.OSR_01;

/**
 * OSR���룬ֻ��ѭ����Ĵ��벿��ִ�б����Ĵ��룬�����������ǽ���ִ��
 * <hr>
 * <br>
 *   compileThreshold*(onStackReplacePercentage - InterpreterProfilePercentage)/100
 * <br><br>
 *     = 10000*(140 - 33)/100
 * <br><br>
 *      = 10700
 * <br><br>
 * <ul>
 *    <li>�ر߼������� һ�δ����ִ�д���������������10700��ʱ���ͻᴥ��OSR����;</li>
 *    <li>������������compileThreshold��Ĭ����10000�����ر߼�������10700ʱ���ͻὫcompileThreshold���10000</li>  
 * </ul>
 * <hr>
 * ����ڵ����Σ�����bar()��ʱ�򣬾ͻ����JIT���룬���Թ۲������Է��֣�����1s��ʱ��Ķ��ǳ�����i=1,2,3��ʱ�������ǵ����γ��ֵĸ������
 *  <ul>
 *    <li>���ܲ���ʱ�������ܲ���ʱ�������������㹻�ĵ��ô������Ա�֤�����ǹ�ƽ�ģ�</li>
 *    <li>��������: һЩ�ؼ����ܣ����������н���һ���ĵ��ã��Ա�֤�ؼ��������ܣ�</li>
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
		 * �ڵ�i=1�Σ�ִ�н�����ʱ��
		 * 
		 * �ر߼����� = 10700(��),����OSR���룬
		 * 
		 * bar()��������
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
	 *  ����bar()�������δ����ظ�ִ�г��������ֵ֮��<br>
	 *   �ͻᴥ��OSR���룬ʹѭ�����ǲ��ִ��룬���Ժ�ִ�е�ʱ�򣬶���ִ�б����Ĵ��룻
	 */
	public void bar() {

		// bar code
		for (int i = 0; i < 10700; i++) {
			bar2();
		}

	}

	/**
	 * bar2()�ķ����������� <br>
	 * CompileThreshold = 10000<br>
	 * <hr>
	 *  ���ر߼������﷧ֵ��ʱ�򣬾ͻ�ʹCompileThreshold = 10000
	 * 
	 */
	public void bar2() {
		// bar2 code
	}
}
