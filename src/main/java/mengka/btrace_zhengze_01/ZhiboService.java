package mengka.btrace_zhengze_01;

import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;

/**
 * btrace 41120 TraceMethodExecuteTime.java
 * <p/>
 * User: mengka
 * Date: 14-10-22
 */
@BTrace
public class ZhiboService {

    @TLS
    static long beginTime_getRoom;

    @TLS
    static long beginTime_getByRoomId;

    @TLS
    static long beginTime_getPrograms;

    @TLS
    static long beginTime_getResponseProgramById;

    @TLS
    static long beginTime_getRightCornerPro;

    @TLS
    static long beginTime_getCountDown;

    @TLS
    static long beginTime_getRoomReview;

    @TLS
    static long beginTime_postFeedBack;

    @TLS
    static long beginTime_getMessageListByStreamId;

    @TLS
    static long beginTime_getMessages;

    @OnMethod(clazz = "com.sohu.mobile.zhibo.service.impl.ZhiboStreamServiceImpl", method = "getMessages")
    public static void traceExecuteBegin__getMessages() {
        beginTime_getMessages = timeMillis();
    }

    @OnMethod(clazz = "com.sohu.mobile.zhibo.service.impl.ZhiboStreamServiceImpl", method = "getMessages", location = @Location(Kind.RETURN))
    public static void traceExecute__getMessages() {
        println(strcat(str(timestamp("yyyy-MM-dd HH:mm:ss")),
                strcat(strcat("  ZhiboStreamServiceImpl getMessages time is:", str(timeMillis()- beginTime_getMessages)), "ms")));
    }

    @OnMethod(clazz = "com.sohu.mobile.zhibo.service.impl.ZhiboStreamServiceImpl", method = "getMessageListByStreamId")
    public static void traceExecuteBegin_getMessageListByStreamId() {
        beginTime_getMessageListByStreamId = timeMillis();
    }

    @OnMethod(clazz = "com.sohu.mobile.zhibo.service.impl.ZhiboStreamServiceImpl", method = "getMessageListByStreamId", location = @Location(Kind.RETURN))
    public static void traceExecute_getMessageListByStreamId() {
        println(strcat(str(timestamp("yyyy-MM-dd HH:mm:ss")),
                strcat(strcat("  ZhiboStreamServiceImpl getMessageListByStreamId time is:", str(timeMillis() - beginTime_getMessageListByStreamId)), "ms")));
    }

    @OnMethod(clazz = "com.sohu.mobile.zhibo.service.impl.ZhiboRoomServiceImpl", method = "postFeedBack")
    public static void traceExecuteBegin_postFeedBack() {
        beginTime_postFeedBack = timeMillis();
    }

    @OnMethod(clazz = "com.sohu.mobile.zhibo.service.impl.ZhiboRoomServiceImpl", method = "postFeedBack", location = @Location(Kind.RETURN))
    public static void traceExecute_postFeedBack() {
        println(strcat(str(timestamp("yyyy-MM-dd HH:mm:ss")),
                strcat(strcat("  ZhiboRoomServiceImpl postFeedBack time is:", str(timeMillis()- beginTime_postFeedBack)), "ms")));

    }

    @OnMethod(clazz = "com.sohu.mobile.zhibo.service.impl.ZhiboRoomServiceImpl", method = "getRoomReview")
    public static void traceExecuteBegin_getRoomReview() {
        beginTime_getRoomReview = timeMillis();
    }

    @OnMethod(clazz = "com.sohu.mobile.zhibo.service.impl.ZhiboRoomServiceImpl", method = "getRoomReview", location = @Location(Kind.RETURN))
    public static void traceExecute_getRoomReview() {
        println(strcat(str(timestamp("yyyy-MM-dd HH:mm:ss")),
                strcat(strcat("  ZhiboRoomServiceImpl getRoomReview time is:", str(timeMillis()- beginTime_getRoomReview)), "ms")));
    }

    @OnMethod(clazz = "com.sohu.mobile.zhibo.service.impl.ZhiboRoomServiceImpl", method = "getCountDown")
    public static void traceExecuteBegin_getCountDown() {
        beginTime_getCountDown = timeMillis();
    }

    @OnMethod(clazz = "com.sohu.mobile.zhibo.service.impl.ZhiboRoomServiceImpl", method = "getCountDown", location = @Location(Kind.RETURN))
    public static void traceExecute_getCountDown() {
        println(strcat(str(timestamp("yyyy-MM-dd HH:mm:ss")),
                strcat(strcat("  ZhiboRoomServiceImpl getCountDown time is:", str(timeMillis()- beginTime_getCountDown)), "ms")));
    }

    @OnMethod(clazz = "com.sohu.mobile.zhibo.service.impl.ZhiboProgramServiceImpl", method = "getRightCornerPro")
    public static void traceExecuteBegin_getRightCornerPro() {
        beginTime_getRightCornerPro = timeMillis();
    }

    @OnMethod(clazz = "com.sohu.mobile.zhibo.service.impl.ZhiboProgramServiceImpl", method = "getRightCornerPro", location = @Location(Kind.RETURN))
    public static void traceExecute_getRightCornerPro() {
        println(strcat(str(timestamp("yyyy-MM-dd HH:mm:ss")),
                strcat(strcat("  ZhiboProgramServiceImpl getRightCornerPro time is:", str(timeMillis()- beginTime_getRightCornerPro)), "ms")));

    }

    @OnMethod(clazz = "com.sohu.mobile.zhibo.service.impl.ZhiboProgramServiceImpl", method = "getResponseProgramById")
    public static void traceExecuteBegin_getResponseProgramById() {
        beginTime_getResponseProgramById = timeMillis();
    }

    @OnMethod(clazz = "com.sohu.mobile.zhibo.service.impl.ZhiboProgramServiceImpl", method = "getResponseProgramById", location = @Location(Kind.RETURN))
    public static void traceExecute_getResponseProgramById() {
        println(strcat(str(timestamp("yyyy-MM-dd HH:mm:ss")),
                strcat(strcat("  ZhiboProgramServiceImpl getResponseProgramById time is:", str(timeMillis()- beginTime_getResponseProgramById)), "ms")));
    }

    @OnMethod(clazz = "com.sohu.mobile.zhibo.service.impl.ZhiboProgramServiceImpl", method = "getPrograms")
    public static void traceExecuteBegin_getPrograms() {
        beginTime_getPrograms = timeMillis();
    }

    @OnMethod(clazz = "com.sohu.mobile.zhibo.service.impl.ZhiboProgramServiceImpl", method = "getPrograms", location = @Location(Kind.RETURN))
    public static void traceExecute_getPrograms() {
        println(strcat(str(timestamp("yyyy-MM-dd HH:mm:ss")),
                strcat(strcat("  ZhiboProgramServiceImpl getPrograms time is:", str(timeMillis()- beginTime_getPrograms)), "ms")));
    }

    @OnMethod(clazz = "com.sohu.mobile.zhibo.service.impl.ZhiboRoomServiceImpl", method = "getRoom")
    public static void traceExecuteBegin() {
        beginTime_getRoom = timeMillis();
    }

    @OnMethod(clazz = "com.sohu.mobile.zhibo.service.impl.ZhiboRoomServiceImpl", method = "getRoom", location = @Location(Kind.RETURN))
    public static void traceExecute() {
        println(strcat(str(timestamp("yyyy-MM-dd HH:mm:ss")),
                strcat(strcat("  ZhiboRoomServiceImpl getRoom time is:", str(timeMillis()- beginTime_getRoom)), "ms")));
    }

    @OnMethod(clazz = "com.sohu.mobile.zhibo.service.impl.ZhiboRoomServiceImpl", method = "getRoomById")
    public static void traceExecuteBegin_byRoomId() {
        beginTime_getByRoomId = timeMillis();
    }

    @OnMethod(clazz = "com.sohu.mobile.zhibo.service.impl.ZhiboRoomServiceImpl", method = "getRoomById", location = @Location(Kind.RETURN))
    public static void traceExecute_byRoomId() {
        println(strcat(str(timestamp("yyyy-MM-dd HH:mm:ss")),
                strcat(strcat("  ZhiboRoomServiceImpl getRoomById time is:", str(timeMillis()- beginTime_getByRoomId)), "ms")));
    }
}
