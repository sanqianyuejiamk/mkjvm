package mengka.sy_01;

import java.util.Random;

/**
 * sy: �ں��̴߳�����ռ�İٷֱ� ���̶߳ࡢI/O�ȴ��ࣩ<br>
 * [��һ]��<br>
 *    ATask��BTask֮�䲻�ϵ��л�״̬��500���߳�һֱ���ڡ��ȴ����͡����ѡ�2��״̬֮���л�������ϵͳ��syֵһֱ쭸�
 * <hr>
 *   CPU usage: 5.38% user, 91.86% sys
 *   <img src="http://img01.taobaocdn.com/imgextra/i1/14648030742550154/T2TiKVXcBcXXXXXXXX_!!443534648-0-shop_backyard.jpg"/>
 *<br><br>
 *
 * 1.top�鿴�߳����ģ�<br>  
 *            top<br>  
 *    <br>  
 * 2.�鿴ÿ���̵߳�cpu���ģ�<br>  
 *           ps aux|grep java<br>  
 *      <br>    
 * 3.jstack�鿴�̵߳�״̬��<br>  
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
 * [ע]���̴߳󲿷ִ��ڡ�TIMED_WAITING����״̬֮�У�һֱ����Runnable��waiting״̬֮���л���
 * �����ҵ����������ҵĴ��롰ATask.run(Taa.java:86)������Ҳ�����ϵͳʱ��ķ����߳��������л���ԭ��
 *<br><br>
 * Created with IntelliJ IDEA.
 * User: hyy044101331
 * Date: 13-11-21-����2:58
 */
public class Taa {

    private Object[] locks;

    private static int threadCount = 500;

    public static void main(String[] args)throws Exception{
         Taa taa = new Taa();
         taa.runSYTest();
    }

    /**
     *  �̲߳��ϵ��ڵȴ��ͻ���2������֮���л�������syֵ����쭸�
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
     *  BTask���ϵĻ���
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
     * ATask�̲߳��ϵĽ���ȴ�״̬
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
