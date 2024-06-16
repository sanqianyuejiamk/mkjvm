package mengka.monitor.gc;

/**
 * 
 * ��-Xms40M -Xmx40M -Xmn16M -verbose:gc -XX:+PrintGCDetails��<br>
 * -Xmn16M : 16M�������ڴ�<br>
 * Eden�ڴ� �� <br>
 * 16M = Eden/S0 = 12m/2m = .. ��Ĭ�ϱ�����8����������6��<br>
 * �������ڴ� = 40m - 16m =24m<br>
 * <hr>
 * ����������Eden space�����ʱ�򣬷���monitor GC�����<br>
 * [GC [DefNew: 12551K->152K(14784K), 0.0029062 secs] 12551K->152K(39360K),
 * 0.0029565 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] <font
 * color="red">
 * <h2>�鿴GCʱ�ڴ������ jstat -gcutil [pid]1000</h2> </font>
 * <hr>
 * ����1.0M�ڴ�<br>
 * ����1.0M�ڴ�<br>
 * ����1.0M�ڴ�<br>
 * ����1.0M�ڴ�<br>
 * ����1.0M�ڴ�<br>
 * ����1.0M�ڴ�<br>
 * ����1.0M�ڴ�<br>
 * ����1.0M�ڴ�<br>
 * ����1.0M�ڴ�<br>
 * ����1.0M�ڴ�<br>
 * ����1.0M�ڴ�<br>
 * ����1.0M�ڴ�<br>
 * [GC [ParNew: 12583K->408K(14784K), 0.0021804 secs] 12583K->408K(39360K),
 * 0.0043024 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] <br>
 * ��ʼ minor GC!<br>
 * ����1.0M�ڴ�<br>
 * ����1.0M�ڴ�<br>
 * ����1.0M�ڴ�<br>
 * ����1.0M�ڴ�<br>
 * ����1.0M�ڴ�<br>
 * ����1.0M�ڴ�<br>
 * ����1.0M�ڴ�<br>
 * ����1.0M�ڴ�<br>
 * ����1.0M�ڴ�<br>
 * ����1.0M�ڴ�<br>
 * ����1.0M�ڴ�<br>
 * ����1.0M�ڴ�<br>
 * [GC [ParNew: 13106K->562K(14784K), 0.0006075 secs] 13106K->562K(39360K),
 * 0.0006425 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]<br>
 * ��ʼ minor GC!<br>
 * ����1.0M�ڴ�<br>
 * ����1.0M�ڴ�<br>
 * Heap<br>
 * par new generation total 14784K, used 4257K [7f8600000, 7f9600000, 7f9600000)
 * <br>
 * eden space 13184K, 28% used [7f8600000, 7f899be28, 7f92e0000)<br>
 * from space 1600K, 35% used [7f92e0000, 7f936c820, 7f9470000)<br>
 * to space 1600K, 0% used [7f9470000, 7f9470000, 7f9600000)<br>
 * concurrent mark-sweep generation total 24576K, used 0K [7f9600000, 7fae00000,
 * 7fae00000)<br>
 * concurrent-mark-sweep perm gen total 21248K, used 5085K [7fae00000,
 * 7fc2c0000, 800000000)<br>
 * <br>
 * 
 * @author mengka
 * 
 */
public class MinorGC_01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		while (true) {
			for (int i = 0; i < 2; i++) {

				happenMinorGC(12);
				Thread.sleep(2000);

			}

			/**
			 * �����֮ǰ���Ѿ�ռ����12M��Eden�ռ䣬��������������ʱ�򣬷�����monitor GC
			 */
			MemoryObject aaObject = new MemoryObject(1024 * 1024);

			MemoryObject bbObject = new MemoryObject(1024 * 1024);

		}
	}

	/**
	 * ����aaIndex�׵��ڴ棬���������һ������֮ǰ����ӡGC��ʼ����ʾString
	 * 
	 * @param aaIndex
	 * @throws Exception
	 */
	private static void happenMinorGC(int aaIndex) throws Exception {

		for (int i = 0; i < aaIndex; i++) {

			// ��Eden�У�����1M�Ķ���
			new MemoryObject(1024 * 1024);

			/**
			 * ��12m��Eden�ڴ汻ռ����ʱ��
			 */
			if (i == aaIndex - 1) {
				Thread.sleep(2000);
				System.out.println("��ʼ minor GC!");
			}
		}
	}

}
