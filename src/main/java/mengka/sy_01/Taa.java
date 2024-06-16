package mengka.sy_01;

import java.util.Random;

/**
 * sy: 内核线程处理所占的百分比 （线程多、I/O等待多）<br>
 * [例一]：<br>
 *    ATask和BTask之间不断的切换状态，500个线程一直都在“等待”和“唤醒”2个状态之间切换，导致系统的sy值一直飙高
 * <hr>
 *   CPU usage: 5.38% user, 91.86% sys
 *   <img src="http://img01.taobaocdn.com/imgextra/i1/14648030742550154/T2TiKVXcBcXXXXXXXX_!!443534648-0-shop_backyard.jpg"/>
 *<br><br>
 *
 * 1.top查看线程消耗：<br>  
 *            top<br>  
 *    <br>  
 * 2.查看每个线程的cpu消耗：<br>  
 *           ps aux|grep java<br>  
 *      <br>    
 * 3.jstack查看线程的状态：<br>  
 *           jstack -l 696<br>  
 *     <br>      
 *  "Thread-994" prio=5 tid=0x00007fa5d4091000 nid=0x81b03 in Object.wait() [0x0000000152037000]<br>  
 *  java.lang.Thread.State: TIMED_WAITING (on object monitor)<br>  
 *	at java.lang.Object.wait(Native Method)<br>  
 *	at mengka.sy_01.Taa$ATask.run(Taa.java:86)<br>  
 *	- locked <0x0000000780002a88> (a java.lang.Object)<br>  
 *	at java.lang.Thread.run(Thread.java:724)<br>  
 *<br>
 *  Locked ownable synchronizers:<br>  
 *	- None<br>  
 * <br>
 * [注]：线程大部分处于“TIMED_WAITING”的状态之中，一直都在Runnable和waiting状态之间切换，
 * 可以找到锁竞争激烈的代码“ATask.run(Taa.java:86)”，这也是造成系统时间耗费在线程上下文切换的原因；
 *<br><br>
 * Created with IntelliJ IDEA.
 * User: hyy044101331
 * Date: 13-11-21-下午2:58
 */
public class Taa {

    private Object[] locks;

    private static int threadCount = 500;

    public static void main(String[] args)throws Exception{
         Taa taa = new Taa();
         taa.runSYTest();
    }

    /**
     *  线程不断的在等待和唤醒2个操作之间切换，导致sy值不断飙高
     *
     */
    public void runSYTest(){
        locks = new Object[threadCount];
        for(int i=0;i<threadCount;i++){
            locks[i] = new Object();
        }

        for(int i=0;i<threadCount;i++){
            new Thread(new ATask(i)).start();
            new Thread(new BTask(i)).start();
        }
    }


    /**
     *  BTask不断的唤醒
     *
     */
    public class BTask implements Runnable{

        private Object lockObject = null;

        public BTask(int i){
           lockObject = locks[i];
        }

        public void run(){
            while(true){
                synchronized (lockObject){
                    lockObject.notifyAll();
                }
                try{
                    Thread.sleep(new Random().nextInt(10));
                }catch (Exception e){

                }
            }
        }
    }

    /**
     * ATask线程不断的进入等待状态
     *
     */
    public class ATask implements Runnable {

        private Object lockObject = null;

        public ATask(int i){
            lockObject =  locks[i];
        }

        public void run(){
             while (true){
                 try{
                     synchronized (lockObject){
                         lockObject.wait(new Random().nextInt(10));
                     }
                 }catch(Exception e){

                 }
             }
        }

    }

}
