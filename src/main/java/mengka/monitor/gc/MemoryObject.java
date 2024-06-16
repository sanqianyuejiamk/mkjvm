package mengka.monitor.gc;

/**
 * 用来分配内存的对象
 * <hr>
 * <br>
mengka-2:~ hyy044101331$ jmap -histo 17779

 num     #instances         #bytes  class name
----------------------------------------------
   1:           819        7470728  [B
   2:          8131        1111432  <methodKlass>
   3:          8131        1067080  <constMethodKlass>
   4:         13362         746960  <symbolKlass>
   5:           595         697984  <constantPoolKlass>
   6:           568         489888  <constantPoolCacheKlass>
   7:           595         433424  <instanceKlassKlass>
   8:           806         312808  [I
   9:          2822         300368  [C
  10:          2874          91968  java.lang.String
  11:           699          72696  java.lang.Class
  12:           904          62264  [S
  13:           968          57392  [[I
  14:            75          43800  <objArrayKlassKlass>
  15:           790          31600  java.util.TreeMap$Entry
  16:           120          17976  [Ljava.util.HashMap$Entry;
  17:            33          17792  <methodDataKlass>
  18:           354          15552  [Ljava.lang.Object;
 * <br>
 * <br>
 * 
 * @author mengka
 * 
 */
public class MemoryObject {

	private byte[] bytes;

	public MemoryObject(int aaSize) {
		System.out.println("分配" + aaSize * 1.0 / 1024 / 1024 + "M内存");
		this.bytes = new byte[aaSize];
	}

}
