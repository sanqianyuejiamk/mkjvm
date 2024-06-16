package mengka.btrace_zhengze_01;

import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;

/**
 * User: mengka
 * Date: 14-10-23
 */
@BTrace
public class ZhiboRoomServiceImpl_getRoomById {

    @TLS
    static long beginTime;

    @OnMethod(clazz = "com.sohu.mobile.zhibo.service.impl.ZhiboRoomServiceImpl", method = "getRoomById")
    public static void traceExecuteBegin() {
        beginTime = timeMillis();
    }

    @OnMethod(clazz = "com.sohu.mobile.zhibo.service.impl.ZhiboRoomServiceImpl", method = "getRoomById", location = @Location(Kind.RETURN))
    public static void traceExecute() {
        println(strcat(str(timestamp("yyyy-MM-dd HH:mm:ss")),
                strcat(strcat("  ZhiboRoomServiceImpl getRoomById time is:", str(timeMillis()- beginTime)), "ms")));
    }
}
