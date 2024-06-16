package mengka.IntegerCache_02;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author mengka
 * @date 2017/05/31.
 */
public class Taa {

    private static final Log log = LogFactory.getLog(Taa.class);

    public static void main(String[] args) throws Exception {
        // Extract the IntegerCache through reflection
        //获取类
        Class<?> clazz = Class.forName("mengka.IntegerCache_02.MengkaInteger$MengkaIntegerCache");

        //获取cache成员变量
        Field field = clazz.getDeclaredField("cache");
        field.setAccessible(true);
        String[] cache = (String[]) field.get(clazz);
        System.out.println("cache = " + Arrays.toString(cache));
    }
}
