package mengka.us_01;

import java.util.ArrayList;

/**
 *  ConsumeCPUTask线程：
 *
 *      线程一直处于运行状态中，中途没有IO中断、锁等待等现象，因此造成CPU消耗严重
 *
 */
public class ConsumeCPUTask implements Runnable{

    /*
    ｛
      1.top
      2.jstack 5180
      3.找到对应的出错的代码行数
     }
    "Thread-3" prio=5 tid=0x00007fb7f38f7000 nid=0x6e03 waiting on condition [0x00000001943ca000]
   java.lang.Thread.State: TIMED_WAITING (sleeping)
	at java.lang.Thread.sleep(Native Method)
	at mengka.mkBug_us_01.ConsumeCPUTask.run(ConsumeCPUTask.java:24)
	at java.lang.Thread.run(Thread.java:724)
     */

    @Override
    public void run() {

        String aaString = "从前有个庙，庙里有个小和尚，有一天,老和尚要小和尚下山去买水喝，但是沿途叮嘱一定不能。。。jdjvbdfbjfdkjgdfsjgbdsjfgfdgjkfdhkj#fdgdfhdhfdhd";

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

