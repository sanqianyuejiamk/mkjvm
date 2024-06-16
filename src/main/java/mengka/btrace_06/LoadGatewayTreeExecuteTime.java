package mengka.btrace_06;

import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;
import static com.sun.btrace.BTraceUtils.timeMillis;

/**
 * @author huangyy
 * @date 2017/09/25.
 */
@BTrace
public class LoadGatewayTreeExecuteTime {

    @TLS
    static long beginTime;

    @OnMethod(clazz = "com.innotek.cabbage.controller.base.DockDataController", method = "loadGatewayTree")
    public static void traceExecuteBegin() {
        /**
         *  初始时间
         */
        println("--------- , test btrace traceExecuteBegin");
        beginTime = timeMillis();
    }

    @OnMethod(clazz = "com.innotek.cabbage.controller.base.DockDataController", method = "loadGatewayTree", location = @Location(Kind.RETURN))
    public static void traceExecute(int sleepTime, @Return boolean result) {
        /**
         *  方法执行的消耗时间
         *
         */
        println("--------- , test btrace traceExecute");
        println(strcat(
                strcat("CaseObject.execute time is:", str(timeMillis()
                        - beginTime)), "ms"));
    }
}
