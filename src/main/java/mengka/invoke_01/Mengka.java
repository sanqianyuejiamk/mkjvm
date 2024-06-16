package mengka.invoke_01;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Mengka {

	public static Log log = LogFactory.getLog(Mengka.class);

	// 在类初始化的时候，就会执行一次
	static {
		System.out.println("Mengka class loaded...");
	}

	public void execute() {
		log.info("---------- , mengka invoke..");
	}
}
