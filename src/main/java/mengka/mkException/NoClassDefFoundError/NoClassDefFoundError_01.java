package mengka.mkException.NoClassDefFoundError;

/**
 * 
 * ��1��
 * <br><br>
 * public class A{<br>
 * <br>
 * B b = new B(); <br>
 * }<br>
 * <br>
 * 
 * �� ��class.forName����A��ʱ��
 * <br><br>
 * ��B.class�����ڣ����׳�NoClassDefFoundError
 * <br>
 * 
 * @author mengka.hyy
 * 
 */
public class NoClassDefFoundError_01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		A a = new A();

	}

}
