package mengka.btrace_zhengze_01;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;

/**
 *  打印出package com.sohu.mobile.zhibo.service下面的所有的接口的调用时间
 *
 *     btrace 4535 ZhiboService_Package.java
 *
 * User: mengka
 * Date: 14-10-23
 */
@BTrace
public class ZhiboService_Package {

    @TLS
    private static long startTime = 0;

    @OnMethod(clazz = "/com\\.sohu\\.mobile\\.zhibo\\.service\\..*/",
            method = "/.*/")
    public static void startMethod() {
        startTime = timeMillis();
    }

    @OnMethod(clazz = "/com\\.sohu\\.mobile\\.zhibo\\.service\\..*/",
            method = "/.*/", location = @Location(Kind.RETURN))
    public static void endMethod(@ProbeClassName String className, @ProbeMethodName String methodName) {
        println(strcat(strcat(strcat(str(timestamp("yyyy-MM-dd HH:mm:ss  ")), className), strcat(" ", methodName)), strcat(" take "
                , strcat(str(BTraceUtils.timeMillis() - startTime),"ms") )));
     }
}
