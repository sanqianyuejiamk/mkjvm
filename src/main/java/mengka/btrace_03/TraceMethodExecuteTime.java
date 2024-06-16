package mengka.btrace_03;

import static com.sun.btrace.BTraceUtils.*;

import com.sun.btrace.annotations.*;

/**
 * execute����ִ�к�ʱ�Ƕ�ã�[������http://bluedavy.me/?p=185]
 * �������е��õ�caseobject��execute����ʱ���ͻ���btrace��console�������Ӧ����Ϣ
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
         *  ��ʼʱ��
         */
        println("--------- , test btrace traceExecuteBegin");
        beginTime = timeMillis();
    }

    @OnMethod(clazz = "mengka.btrace_03.CaseObject", method = "execute", location = @Location(Kind.RETURN))
    public static void traceExecute(int sleepTime, @Return boolean result) {
        /**
         *  ����ִ�е�����ʱ��
         *
         */
        println("--------- , test btrace traceExecute");
        println(strcat(
                strcat("CaseObject.execute time is:", str(timeMillis()
                        - beginTime)), "ms"));
    }
}
