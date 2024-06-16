package mengka.btrace_02;

import static com.sun.btrace.BTraceUtils.*;
import com.sun.btrace.annotations.*;

/**
 *  ˭������execute������
 *  
 *  btrace -cp btrace/build 6602 TraceMethodCallee.java
 * 
 * @author mengka.hyy
 *
 */
@BTrace
public class TraceMethodCallee {

	@OnMethod(clazz = "CaseObject", method = "execute")
	public static void traceExecute() {
		println("who call CaseObject.execute :");
		jstack();
	}
}
