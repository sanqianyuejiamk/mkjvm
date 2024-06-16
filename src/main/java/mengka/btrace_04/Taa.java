package mengka.btrace_04;


import com.mengka.common.TimeUtil;

import java.util.Date;
import java.util.Random;

/**
 *   控制caseObject方法的每次的执行时间
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
            String baicai = "mengka AAA..["+TimeUtil.toDate(new Date(),TimeUtil.format_1)+"]";
			result = caseObject.execute(random.nextInt(1000),baicai);
			//result = caseObject.execute(1000);
			System.out.println(baicai);
			Thread.sleep(1000);
		}
	}

}
