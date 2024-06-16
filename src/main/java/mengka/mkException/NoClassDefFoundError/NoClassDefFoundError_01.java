package mengka.mkException.NoClassDefFoundError;

/**
 * 
 * 例1：
 * <br><br>
 * public class A{<br>
 * <br>
 * B b = new B(); <br>
 * }<br>
 * <br>
 * 
 * 》 当class.forName加载A的时候，
 * <br><br>
 * 若B.class不存在，则抛出NoClassDefFoundError
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
