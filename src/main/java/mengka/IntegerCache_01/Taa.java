package mengka.IntegerCache_01;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Random;

/**
 * >>Integer类有一个私有嵌套类：
 * IntegerCache，包含int值从 -127 到 128 的Integer对象；
 *
 * >>当代码要把一个int数据类型封装成Integer对象，并且int值在范围 -127~128 内时，
 * Java运行时环境使用缓存而不是重新创建一个Integer对象;
 *
 * >>
 *
 * @author mengka
 * @date 2017/05/31.
 */
public class Taa {

    /**
     *  通过反射获取了IntegerCache，然后把随机数赋值给cache成员变量;
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // Extract the IntegerCache through reflection
        //获取类
        Class<?> clazz = Class.forName("java.lang.Integer$IntegerCache");

        //获取cache成员变量
        Field field = clazz.getDeclaredField("cache");
        field.setAccessible(true);
        Integer[] cache = (Integer[]) field.get(clazz);
        System.out.println("cache = "+ Arrays.toString(cache));

        // Rewrite the Integer cache
        for (int i = 0; i < cache.length; i++) {
            cache[i] = new Integer(new Random().nextInt(cache.length));
        }

        // Prove randomness
        for (int i = 0; i < 10; i++) {
            System.out.println((Integer) i);
        }
    }
}
