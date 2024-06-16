package mengka.btrace_05;

import static com.sun.btrace.BTraceUtils.*;

import com.sun.btrace.annotations.*;

//import static org.openjdk.btrace.core.BTraceUtils.*;
//import org.openjdk.btrace.core.annotations.*;

/**
 * 排查在哪个地方调用Mengka这个类里面的方法｛http://bluedavy.me/?p=205｝
 * <p/>
 * btrace 58676 btrace_05.java
 * <hr>
 * who call Inflater.qingcai
 * mengka.btrace_05.Mengka.qingcai(Mengka.java)
 * mengka.btrace_05.Taa.main(Taa.java:15)
 * who call Inflater.qingcai
 * mengka.btrace_05.Mengka.qingcai(Mengka.java)
 * mengka.btrace_05.Taa.main(Taa.java:15)
 * who call Inflater.qingcai
 * mengka.btrace_05.Mengka.qingcai(Mengka.java)
 * mengka.btrace_05.Taa.main(Taa.java:15)
 * who call Inflater.qingcai
 * mengka.btrace_05.Mengka.qingcai(Mengka.java)
 * <p/>
 *
 * User: mengka.hyy
 * Date: 14-9-13-下午7:25
 */
@BTrace
public class btrace_05 {

    @OnMethod(clazz = "mengka.btrace_05.Mengka", method = "/.*/")
    public static void traceExecute(@ProbeMethodName String methodName) {
        println(concat("who call Mengka.", methodName));
        jstack();
    }

}
