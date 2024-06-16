package mengka.cmd_02;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CmdUtil {

	private static Log log = LogFactory.getLog(CmdUtil.class);

	private static int PEOCESS_EXEC_NORMAL = 0;// ��������

	private static int PEOCESS_EXEC_NOT_NORMAL = 1;// ����������

	public static void execCommand(String command) throws Exception {
		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec(command);
		process.waitFor();

		BufferedInputStream inputStream = new BufferedInputStream(
				process.getInputStream());
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(inputStream));

		String line;
		StringBuffer result = new StringBuffer();
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
			result.append(line).append("\n");
		}
		log.info("exec command..");
		log.info(result.toString());

		// ��������Ƿ�ִ��ʧ��
		if (process.waitFor() != 0) {
			if (process.exitValue() == PEOCESS_EXEC_NOT_NORMAL) {
				log.error("����ִ��ʧ��! command = " + command);
			}
		}

		bufferedReader.close();
		inputStream.close();
	}
}
