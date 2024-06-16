package mengka.btrace_01;

import static com.sun.btrace.BTraceUtils.println;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.Return;

/**
 * 
 * ����btrace����������ķ���ֵ�Ͳ���ֵ
 * 
 * <hr>
 * ��������java����<br>
 * /System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/bin/java -jar udp-nio-server.jar<br>
 * socket_UDP_02.udp_nio_server_01<br>
 * socket_UDP_02.TaaMessageListener<br>
 * <br>
 *  /System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/bin/java -jar udp-nio-client.jar<br>
 *  socket_UDP_02.udp_nio_client_01<br>
 *  
 * 
 * <br><br>
 * ��������btrace���<br>
 * mengka-2:btrace_01 hyy044101331$ btrace 6405 Mengka.java 
 * <br><br>
 * --------- , test btrace<br>
 * ��ײ�bbb..[btrace-2014-08-23 16:25:00] <font color="red">==================>>{{�����ķ���ֵ}}</font><br>
 * {value=[C@435bb0f, offset=0, count=153, hash=0, }<br>
 * --------- , test btrace<br>
 * ��ײ�bbb.. <font color="red">==================>>{{�����Ĵ������ֵ}}</font><br>
 * {value=[C@638bd7f1, offset=0, count=125, hash=0, }<br>
 * --------- , test btrace<br>
 * �����aaa..[btrace-2014-08-23 16:25:00]<br>
 * {value=[C@5f1eb199, offset=0, count=153, hash=0, }<br>
 * --------- , test btrace<br>
 * �����aaa..<br>
 * {value=[C@581de498, offset=0, count=125, hash=0, }<br>
 * 
 * @author mengka.hyy
 * 
 */
@BTrace
public class Mengka {

	@OnMethod(clazz = "socket_UDP_02.TaaMessageListener", method = "testBtraceMessage", location = @Location(Kind.RETURN))
	public static void execute(@Return String result, String arg1) {
		println("--------- , test btrace");
		println(result);
		BTraceUtils.printFields(result);

		println("--------- , test btrace");
		println(arg1);
		BTraceUtils.printFields(arg1);
	}

}
