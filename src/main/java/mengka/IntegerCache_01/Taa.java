package mengka.IntegerCache_01;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Random;

/**
 * >>Integer����һ��˽��Ƕ���ࣺ
 * IntegerCache������intֵ�� -127 �� 128 ��Integer����
 *
 * >>������Ҫ��һ��int�������ͷ�װ��Integer���󣬲���intֵ�ڷ�Χ -127~128 ��ʱ��
 * Java����ʱ����ʹ�û�����������´���һ��Integer����;
 *
 * >>
 *
 * @author mengka
 * @date 2017/05/31.
 */
public class Taa {

    /**
     *  ͨ�������ȡ��IntegerCache��Ȼ����������ֵ��cache��Ա����;
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // Extract the IntegerCache through reflection
        //��ȡ��
        Class<?> clazz = Class.forName("java.lang.Integer$IntegerCache");

        //��ȡcache��Ա����
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
