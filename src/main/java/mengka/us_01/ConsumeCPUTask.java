package mengka.us_01;

import java.util.ArrayList;

/**
 *  ConsumeCPUTask�̣߳�
 *
 *      �߳�һֱ��������״̬�У���;û��IO�жϡ����ȴ�������������CPU��������
 *
 */
public class ConsumeCPUTask implements Runnable{

    /*
    ��
      1.top
      2.jstack 5180
      3.�ҵ���Ӧ�ĳ���Ĵ�������
     }
    "Thread-3" prio=5 tid=0x00007fb7f38f7000 nid=0x6e03 waiting on condition [0x00000001943ca000]
   java.lang.Thread.State: TIMED_WAITING (sleeping)
	at java.lang.Thread.sleep(Native Method)
	at mengka.mkBug_us_01.ConsumeCPUTask.run(ConsumeCPUTask.java:24)
	at java.lang.Thread.run(Thread.java:724)
     */

    @Override
    public void run() {

        String aaString = "��ǰ�и��������и�С���У���һ��,�Ϻ���ҪС������ɽȥ��ˮ�ȣ�������;����һ�����ܡ�����jdjvbdfbjfdkjgdfsjgbdsjfgfdgjkfdhkj#fdgdfhdhfdhd";

        while(true){
            aaString.indexOf("#");
            ArrayList<String> aaList=new ArrayList<String>();
            for(int i=0;i<1000;i++){
                aaList.add(aaString+String.valueOf(i));
                try{
                    Thread.sleep(10);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }

    }
}

