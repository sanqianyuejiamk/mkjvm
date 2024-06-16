package mengka.env;

/**
 *  打印系统的环境变量
 * 
 * @author mengka.hyy
 *
 */
public class java_home_01 {

	public static void main(String[] args)throws Exception {
		
		/**
		 *  例一：
		 *     打印系统环境变量
		 */
		String javaHome = System.getenv("JAVA_HOME");
		System.out.println("JAVA_HOME = "+javaHome);
		
		String path = System.getenv("PATH");
		System.out.println("PATH = "+path);
		
		/**
		 *  例二：
		 * 
		 */
		String pid = "4392";
		String probeScript = "/Users/hyy044101331/work_hyy/mkjvm/src/main/java/mengka/btrace_01/memory_01.java";
		String toolsLib = "/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Classes/classes.jar";
		String btraceLib = "/Users/hyy044101331/java_tools/btrace-1.2.5/build/btrace-client.jar";
		
		String java = "/Library/Java/JavaVirtualMachines/jdk1.7.0_40.jdk/Contents/Home/bin/java";
		String command = java+" -Xms256m -Xmx512m -Dcom.sun.btrace.probeDescPath=. -Dcom.sun.btrace.dumpClasses=false -Dcom.sun.btrace.debug=false -Dcom.sun.btrace.unsafe=false -cp "+btraceLib+":"+toolsLib+ " com.sun.btrace.client.Main "+pid+" "+probeScript;
		Process process = Runtime.getRuntime().exec(command);
		
	}

}
