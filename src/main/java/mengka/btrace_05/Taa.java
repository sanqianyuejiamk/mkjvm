package mengka.btrace_05;

/**
 *   �ҳ��ĸ��ط�����Mengka�����
 *  <hr>
 *  mvn assembly:assembly
 *
 *  /System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/bin/java -jar mkjvm-0.0.1-SNAPSHOT-jar-with-dependencies.jar
 *
 *
 * User: mengka.hyy
 * Date: 14-9-13-����7:20
 */
public class Taa {

    public static final void main(String[] args) throws Exception{

        Mengka mengka = new Mengka();
        while (true) {
            String taa = mengka.qingcai("mengka AAA..");
            System.out.println(taa);
            Thread.sleep(1000);
        }

    }
}
