package mengka.cmd_02;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CmdUtil {

	private static Log log = LogFactory.getLog(CmdUtil.class);

	private static int PEOCESS_EXEC_NORMAL = 0;// 正常结束

	private static int PEOCESS_EXEC_NOT_NORMAL = 1;// 非正常结束

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

		// 检查命令是否执行失败
		if (process.waitFor() != 0) {
			if (process.exitValue() == PEOCESS_EXEC_NOT_NORMAL) {
				log.error("命令执行失败! command = " + command);
			}
		}

		bufferedReader.close();
		inputStream.close();
	}
}
