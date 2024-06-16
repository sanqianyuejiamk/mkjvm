package mengka.cmd_02;

/**
 *  java÷–÷¥––shell√¸¡Ó
 * 
 * @author mengka.hyy
 *
 */
public class cmd_02 {

	public static void main(String[] args) throws Exception{
		
		String cmd = "sh /Users/hyy044101331/work_hyy/mkjvm/src/main/java/mengka/cmd_02/mengka.sh";
		CmdUtil.execCommand(cmd);

		String cmd2 = "/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/bin/java -version";
		CmdUtil.execCommand(cmd2);
		
		String cmd3 = "sh /Users/hyy044101331/work_hyy/mkjvm/src/main/java/mengka/cmd_02/java_version.sh";
		CmdUtil.execCommand(cmd3);
	}
	
}
