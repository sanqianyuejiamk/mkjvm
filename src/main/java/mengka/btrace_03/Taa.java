package mengka.btrace_03;

import java.util.Random;

/**
 *   ����caseObject������ÿ�ε�ִ��ʱ��
 *
 *   <hr>
 *  mvn assembly:assembly
 *
 *  /System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/bin/java -jar mkjvm-0.0.1-SNAPSHOT-jar-with-dependencies.jar
 * 
 * @author mengka.hyy
 *
 */
public class Taa {

	public static void main(String[] args) throws Exception {
		Random random = new Random();
		CaseObject caseObject = new CaseObject();
		boolean result = true;
		while (result) {
			result = caseObject.execute(random.nextInt(1000));
			//result = caseObject.execute(1000);
			Thread.sleep(1000);
		}
	}

}
