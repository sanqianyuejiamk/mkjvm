package mengka.btrace_04;

import static com.sun.btrace.BTraceUtils.*;
import com.sun.btrace.annotations.*;

//import static org.openjdk.btrace.core.BTraceUtils.*;
//import org.openjdk.btrace.core.annotations.*;

/**
 * btrace 51475 TraceMethodArgsAndReturn.java
 * <p/>
 * <hr>
 * --------- , test btrace
 * sleepTime is:53 , baicai = baicai AAA..[2014-09-13 18:46:33]
 * mengka is:37858
 * return value is:true
 * --------- , test btrace
 * sleepTime is:352 , baicai = baicai AAA..[2014-09-13 18:46:34]
 * mengka is:38210
 * return value is:true
 * --------- , test btrace
 * sleepTime is:174 , baicai = baicai AAA..[2014-09-13 18:46:36]
 * mengka is:38384
 * return value is:true
 * --------- , test btrace
 * sleepTime is:958 , baicai = baicai AAA..[2014-09-13 18:46:37]
 * mengka is:39342
 * return value is:true
 * <p/>
 * <p/>
 * <p/>
 * User: mengka.hyy
 * Date: 14-9-13-����5:00
 */
@BTrace
public class TraceMethodArgsAndReturn {


    //@Self mengka.btrace_04.CaseObject instance,
    @OnMethod(clazz = "mengka.btrace_04.CaseObject", method = "execute", location = @Location(Kind.RETURN))
    public static void traceExecute(@Self Object caseObject, int sleepTime, String baicai, @Return boolean result) {
        println("--------- , test btrace");

        /**
         *  ��ӡ�����Ĵ������
         *
         */
        print(strcat("sleepTime is:", str(sleepTime)));

        println(strcat(" , baicai = ", str(baicai)));

        /**
         *  ��ӡCaseObject���ĳ����Ա����
         *
         */
        println(strcat("mengka is:", str(get(field("mengka.btrace_04.CaseObject", "mengka"), caseObject))));

        /**
         *  ��ӡ�����ķ���ֵ
         *
         */
        println(strcat("return value is:", str(result)));
    }

}
