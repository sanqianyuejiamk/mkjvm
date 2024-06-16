package mengka.mkclassloader_02;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 一个命名空间的类如何使用另一个命名空间的类：<br>
 * <ul>
 * <li>mkClassLoader_03.java由系统类装载器加载;</li>
 * <li>Mengka由自定义的类装载器加载;</li>
 * </ul>
 * <hr>
 * 两个类不在同一命名空间，但LoaderSample2得到了LoaderSample3所对应的Class对象的reference，所以它可以访问Mengka中公共的成员(如age)。
 * <br><br>
 * 由同一类装载器定义装载的属于相同包的类组成了【运行时包】，决定两个类是不是属于同一个运行时包，
 * <ul><li>不仅要看它们的包名是否相同，</li><li>还要看的定义类装载器是否相同。</li></ul>
 * 只有属于【同一运行时包】的类才能互相访问包可见的类和成员。<br>
 * 这样的限制避免了用户自己的代码冒充核心类库的类访问核心类库包可见成员的情况。<br>
 * 假设用户自己定义了一个类java.lang.Yes，并用用户自定义的类装载器装载，由于java.lang.Yes和核心类库java.lang.*由不同的装载器装载，它们属于不同的【运行时包】，<br>
 * 所以java.lang.Yes不能访问核心类库java.lang中类的包可见的成员。 <br>
 * <hr>
 * 总结：命名空间并没有完全禁止属于不同空间的类的互相访问，双亲委托模型加强了Java的安全，运行时包增加了对包可见成员的保护。
 * @author mengka.hyy
 * 
 */
public class mkClassLoader_03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		System.gc();
		
		try  {
			/**
			 *  当前项目的路径： F:\work_hyy\mkjvm
			 */
            String path  =  System.getProperty( "user.dir" );
            URL[] us  =  { new  URL( "file://"   +  path  +   "/src/main/java/mengka/mkclassloader**/" )};
            
            //step01: 自定义装载器loader
            ClassLoader loader  =   new  URLClassLoader(us);
            
            //step02: 装载类，并取出该类
            Class mkClass  =  loader.loadClass( "mengka.mkclassloader_02.Mengka" );
            Object obj  =  mkClass.newInstance();
            Field field  =  mkClass.getField( "age");

            Thread.sleep(5000);

            Mengka mengka = (Mengka)obj;
            String baicai = mengka.baicai();
            System.out.println("baicai = "+baicai);

            int  age  =  field.getInt(obj);
            System.out.println( " age is  "   +  age);
            

        }  catch  (Exception e) {
            e.printStackTrace();
        }

	}

}
