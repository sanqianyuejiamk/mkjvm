package mengka.invoke_01;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Mengka {

	public static Log log = LogFactory.getLog(Mengka.class);

	// �����ʼ����ʱ�򣬾ͻ�ִ��һ��
	static {
		System.out.println("Mengka class loaded...");
	}

	public void execute() {
		log.info("---------- , mengka invoke..");
	}
}
