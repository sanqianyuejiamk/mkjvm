package mengka.mkclassloader_02;

/**
 * ���������
 *   �� AppClassLoader;
 *   �� ExtClassLoader;
 *   �� Bootstrap ClassLoader; (JVM�Դ��ģ�c++��д��java�л�ȡ����������jdk�Ļ���jar����)
 *
 * <br/>
 * <a href="http://www.blogjava.net/mstar/archive/2006/08/24/65505.html">https://www.evernote.com/shard/s157/sh/69e801bc-265e-4646-9b1d-7ad7fd61483a/c6e6967aec4279c12355e32b69e473c3</a>
 *  <br>������������ļ����˵����ӳ���
 * 
 * @author mengka.hyy
 *
 */
public class mkClassLoader_02 {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		
		Class mkClass;
		ClassLoader aaLoader;
		
		/**
		 * ��ClassNotFoundException������: 
		 * 
		 *  1.sun.misc.Launcher$AppClassLoader@574f7121
		 *  
		 *                           classLoader���Ѿ����ص���������
		 *                           
		 *                           
		 *  2.parentIndex = 1 , sun.misc.Launcher$ExtClassLoader@208c5a4f    
		 *  
		 *                      ������parent ClassLoader������
		 *                      
		 * 
		 *  3.parentIndex = 2 , null
		 *  
		 *                      �ٴ�System ClassLoader������
		 *                      
		 *                      
		 *  4.��󣬵���findClass()Ѱ�ң���Ȼ�Ҳ��������׳���
		 *  
		 *                                 ClassNotFoundException����
		 *  
		 */
		aaLoader=ClassLoader.getSystemClassLoader();
		int parentIndex = 0;
		System.out.println("parentIndex = "+(parentIndex++)+" , "+aaLoader);
		

		while(aaLoader!=null){
			aaLoader = aaLoader.getParent();
			System.out.println("parentIndex = "+(parentIndex++)+" , "+aaLoader);
		}
		
		
		/**
		 * System CladdLoader:
		 *  
		 *         ������java.lang.Object����bootstrapװ�ص� 
		 *      
		 */
		mkClass = Class.forName("java.lang.Object");
		aaLoader = mkClass.getClassLoader();
		System.out.println("java.lang.Object��classLoader�� "+aaLoader);
		
		
		/**
		 *  �û����ڵ�ǰ��classLoader����
		 * 
		 */
		mkClass = Class.forName("mengka.mkclassloader_02.mkClassLoader_02");
		aaLoader = mkClass.getClassLoader();
		System.out.println("mkClassLoader_02��classLoader�� "+aaLoader);
	}

}
