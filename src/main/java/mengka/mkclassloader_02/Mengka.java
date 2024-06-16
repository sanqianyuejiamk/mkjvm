package mengka.mkclassloader_02;

/**
 *  用于被mkClassLoader_03访问，不同的类装载器，不同的命名空间类的访问
 * 
 * @author mengka.hyy
 *
 */
public class Mengka {

	 //在类初始化的时候，就会执行一次
	 static{
		 System.out.println("Mengka class loaded...");
	 }
	 
	 public int age = 24;
	
	 public String baicai(){
		 System.out.println("baicai AAA...");
		 return "mengka method test...";
	 }
	 
}
