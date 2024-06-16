package mengka.IntegerCache_02;

/**
 * @author mengka
 * @date 2017/05/31.
 */
public class MengkaInteger {

    private static class MengkaIntegerCache {
        static final int low = -128;
        static final int high;
        static final String cache[];

        static {
            // high value may be configured by property
            int h = 127;
            String integerCacheHighPropValue =
                    sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
            if (integerCacheHighPropValue != null) {
                try {
                    int i = Integer.parseInt(integerCacheHighPropValue);
                    i = Math.max(i, 127);
                    // Maximum array size is Integer.MAX_VALUE
                    h = Math.min(i, Integer.MAX_VALUE - (-low) - 1);
                } catch (NumberFormatException nfe) {
                    // If the property cannot be parsed into an int, ignore it.
                }
            }
            high = h;

            cache = new String[(high - low) + 1];
            int j = low;
            for (int k = 0; k < cache.length; k++)
                cache[k] = "mengka_"+String.valueOf(new Integer(j++));

            // range [-128, 127] must be interned (JLS7 5.1.7)
            assert MengkaIntegerCache.high >= 127;
        }

        private MengkaIntegerCache() {
        }
    }
}
