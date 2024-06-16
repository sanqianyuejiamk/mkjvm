package mengka.objectSize;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 *  打印出一个对象的大小：<br>
 * <br>
 *    1809217  ==>>  1.8M
 *  
 * 
 * @author mengka.hyy
 *
 */
public class Instrumentation_01 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws IOException {

//		long beforeMemory=Runtime.getRuntime().totalMemory();

		HashMap aaMap = new HashMap();
		for (int i = 33027138; i < 33039138; i++) {
			aaMap.put(i, 1);
		}
		
//		long afterMemory=Runtime.getRuntime().totalMemory();
//        System.out.println("Memory used:"+(beforeMemory-afterMemory));
        
        
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bs);
        os.writeObject(aaMap);
        os.flush();
        System.out.println(bs.size());
        
	}

}
