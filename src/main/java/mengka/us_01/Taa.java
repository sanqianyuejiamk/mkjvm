package mengka.us_01;

/**
 * us�� �û����̴�����ռ�İٷֱ� ������ѭ������������GCƵ����
 * <hr>
 *  1.top<br>
 *  2.jstack 5180<br>
 *    jstack 5067|grep 'nid=0x20603'<br>
 *  3.�ҵ���Ӧ�ĳ���Ĵ�������<br>
 *
 * User: hyy044101331
 * Date: 13-10-23-����5:39
 */
public class Taa {

    public static void main(String[] args)throws Exception{
        System.out.println("mengka test********");
        Taa demo =new Taa();
        demo.runTest();
    }

    private void runTest()throws Exception{
        int count= Runtime.getRuntime().availableProcessors();
        for(int i=0;i<count;i++){
            new Thread(new ConsumeCPUTask()).start();
        }
        for(int i=0;i<200;i++){
            new Thread(new NotConsumeCPUTask()).start();
        }
    }

}
