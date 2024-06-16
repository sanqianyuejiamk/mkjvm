package mengka.btrace_01;

import java.util.Date;

import com.mengka.common.TimeUtil;

public class Taa {

	public static void main(String[] args) throws Exception{
		
       while(true){
    	   System.out.println(TimeUtil.toDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
    	   Thread.sleep(1000);
       }
		
	}

}
