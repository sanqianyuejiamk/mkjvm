package mengka.us_01;

/**
 *  每次sleep 20分钟，但是不消耗CPU的线程
 *
 * User: hyy044101331
 * Date: 13-10-23-下午5:37
 */
public class NotConsumeCPUTask implements Runnable{

    /*
    ｛
      1.top

      2.jstack 5180

          jstack 5067|grep 'nid=0x20603'
          "Thread-207" prio=5 tid=0x00007f9af48fd800 nid=0x20603 waiting on condition [0x000000019e535000]

      3.找到对应的出错的代码行数
     }
   "Thread-182" prio=5 tid=0x00007fb7f3925000 nid=0x1d403 waiting on condition [0x000000019f8e4000]
   java.lang.Thread.State: TIMED_WAITING (sleeping)
	at java.lang.Thread.sleep(Native Method)
	at mengka.mkBug_us_01.NotConsumeCPUTask.run(NotConsumeCPUTask.java:16)
	at java.lang.Thread.run(Thread.java:724)
     */

    @Override
    public void run() {
        while(true){
            try{
               Thread.sleep(1000000);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
