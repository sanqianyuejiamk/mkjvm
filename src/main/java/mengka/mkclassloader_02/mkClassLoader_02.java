package mengka.mkclassloader_02;

/**
 * 类加载器：
 *   ① AppClassLoader;
 *   ② ExtClassLoader;
 *   ③ Bootstrap ClassLoader; (JVM自带的，c++编写，java中获取不到；加载jdk的基础jar包；)
 *
 * <br/>
 * <a href="http://www.blogjava.net/mstar/archive/2006/08/24/65505.html">https://www.evernote.com/shard/s157/sh/69e801bc-265e-4646-9b1d-7ad7fd61483a/c6e6967aec4279c12355e32b69e473c3</a>
 *  <br>关于类加载器的简单明了的例子出处
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
		 * 【ClassNotFoundException】错误: 
		 * 
		 *  1.sun.misc.Launcher$AppClassLoader@574f7121
		 *  
		 *                           classLoader从已经加载的类里面找
		 *                           
		 *                           
		 *  2.parentIndex = 1 , sun.misc.Launcher$ExtClassLoader@208c5a4f    
		 *  
		 *                      继续从parent ClassLoader里面找
		 *                      
		 * 
		 *  3.parentIndex = 2 , null
		 *  
		 *                      再从System ClassLoader里面找
		 *                      
		 *                      
		 *  4.最后，调用findClass()寻找，任然找不到，就抛出：
		 *  
		 *                                 ClassNotFoundException错误
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
		 *         核心类java.lang.Object是由bootstrap装载的 
		 *      
		 */
		mkClass = Class.forName("java.lang.Object");
		aaLoader = mkClass.getClassLoader();
		System.out.println("java.lang.Object的classLoader： "+aaLoader);
		
		
		/**
		 *  用户类在当前的classLoader里面
		 * 
		 */
		mkClass = Class.forName("mengka.mkclassloader_02.mkClassLoader_02");
		aaLoader = mkClass.getClassLoader();
		System.out.println("mkClassLoader_02的classLoader： "+aaLoader);
	}

}
