package mengka.mkclassloader_02;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * һ�������ռ�������ʹ����һ�������ռ���ࣺ<br>
 * <ul>
 * <li>mkClassLoader_03.java��ϵͳ��װ��������;</li>
 * <li>Mengka���Զ������װ��������;</li>
 * </ul>
 * <hr>
 * �����಻��ͬһ�����ռ䣬��LoaderSample2�õ���LoaderSample3����Ӧ��Class�����reference�����������Է���Mengka�й����ĳ�Ա(��age)��
 * <br><br>
 * ��ͬһ��װ��������װ�ص�������ͬ����������ˡ�����ʱ�����������������ǲ�������ͬһ������ʱ����
 * <ul><li>����Ҫ�����ǵİ����Ƿ���ͬ��</li><li>��Ҫ���Ķ�����װ�����Ƿ���ͬ��</li></ul>
 * ֻ�����ڡ�ͬһ����ʱ����������ܻ�����ʰ��ɼ�����ͳ�Ա��<br>
 * ���������Ʊ������û��Լ��Ĵ���ð�������������ʺ��������ɼ���Ա�������<br>
 * �����û��Լ�������һ����java.lang.Yes�������û��Զ������װ����װ�أ�����java.lang.Yes�ͺ������java.lang.*�ɲ�ͬ��װ����װ�أ��������ڲ�ͬ�ġ�����ʱ������<br>
 * ����java.lang.Yes���ܷ��ʺ������java.lang����İ��ɼ��ĳ�Ա�� <br>
 * <hr>
 * �ܽ᣺�����ռ䲢û����ȫ��ֹ���ڲ�ͬ�ռ����Ļ�����ʣ�˫��ί��ģ�ͼ�ǿ��Java�İ�ȫ������ʱ�������˶԰��ɼ���Ա�ı�����
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
			 *  ��ǰ��Ŀ��·���� F:\work_hyy\mkjvm
			 */
            String path  =  System.getProperty( "user.dir" );
            URL[] us  =  { new  URL( "file://"   +  path  +   "/src/main/java/mengka/mkclassloader**/" )};
            
            //step01: �Զ���װ����loader
            ClassLoader loader  =   new  URLClassLoader(us);
            
            //step02: װ���࣬��ȡ������
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
