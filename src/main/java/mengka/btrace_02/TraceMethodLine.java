package mengka.btrace_02;

import static com.sun.btrace.BTraceUtils.*;
import com.sun.btrace.annotations.*;

/**
 *  有没有人调用CaseObject中的哪一行代码？
 * 
 * @author mengka.hyy
 *
 */
@BTrace
public class TraceMethodLine {

	@OnMethod(clazz = "CaseObject", location = @Location(value = Kind.LINE, line = 5))
	public static void traceExecute(@ProbeClassName String pcn,
			@ProbeMethodName String pmn, int line) {
		println(strcat(strcat(strcat("call ", pcn), "."), pmn));
	}

}
