package mengka.btrace_04;

public class CaseObject {
	
	private static int mengka = 0;

	public boolean execute(int sleepTime,String baicai) throws Exception {
		System.out.println("sleep: " + sleepTime);
		mengka += sleepTime;
		Thread.sleep(sleepTime);
		return true;
	}
}
