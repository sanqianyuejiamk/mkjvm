package mengka.mkclassloader_02;

/**
 *  ���ڱ�mkClassLoader_03���ʣ���ͬ����װ��������ͬ�������ռ���ķ���
 * 
 * @author mengka.hyy
 *
 */
public class Mengka {

	 //�����ʼ����ʱ�򣬾ͻ�ִ��һ��
	 static{
		 System.out.println("Mengka class loaded...");
	 }
	 
	 public int age = 24;
	
	 public String baicai(){
		 System.out.println("baicai AAA...");
		 return "mengka method test...";
	 }
	 
}
