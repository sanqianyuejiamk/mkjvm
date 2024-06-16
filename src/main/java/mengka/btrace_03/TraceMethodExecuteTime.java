package mengka.btrace_03;

import static com.sun.btrace.BTraceUtils.*;

import com.sun.btrace.annotations.*;

/**
 * execute方法执行耗时是多久？[出处：http://bluedavy.me/?p=185]
 * 当程序中调用到caseobject的execute方法时，就会在btrace的console中输出相应的信息
 * <p/>
 * btrace 41120 TraceMethodExecuteTime.java
 * <p/>
 * <hr>
 * --------- , test btrace traceExecuteBegin
 * --------- , test btrace traceExecute
 * CaseObject.execute time is:1001ms
 * --------- , test btrace traceExecuteBegin
 * --------- , test btrace traceExecute
 * CaseObject.execute time is:1000ms
 * --------- , test btrace traceExecuteBegin
 * --------- , test btrace traceExecute
 * CaseObject.execute time is:1001ms
 * --------- , test btrace traceExecuteBegin
 * --------- , test btrace traceExecute
 *
 * @author mengka.hyy
 */
@BTrace
public class TraceMethodExecuteTime {

    @TLS
    static long beginTime;

    @OnMethod(clazz = "mengka.btrace_03.CaseObject", method = "execute")
    public static void traceExecuteBegin() {
        /**
         *  初始时间
         */
        println("--------- , test btrace traceExecuteBegin");
        beginTime = timeMillis();
    }

    @OnMethod(clazz = "mengka.btrace_03.CaseObject", method = "execute", location = @Location(Kind.RETURN))
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
