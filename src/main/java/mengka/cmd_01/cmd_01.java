package mengka.cmd_01;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Java语言以其跨平台性和简易性而著称;<br>
 * Runtime类: <br>
 * Java程序与该程序所运行的环境交互的接口<br>
 * 
 * 
 * 
 * @author mengka.hyy
 * 
 */
public class cmd_01 {

	private static Log log = LogFactory.getLog(cmd_01.class);

	private static int PEOCESS_EXEC_NORMAL = 0;// 正常结束

	private static int PEOCESS_EXEC_NOT_NORMAL = 1;// 非正常结束

	public static void main(String[] args) throws Exception {

		// String command =
		// "java -version";//"/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/bin/java -version";
		// String command = "ping www.sohu.com";
		String command = "ls -l";

		execCommand(command);
		
	}

	
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
