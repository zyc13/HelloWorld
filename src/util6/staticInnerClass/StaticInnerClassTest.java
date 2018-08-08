package util6.staticInnerClass;

/**
 * 该程序演示了静态内部类的使用。
 */
public class StaticInnerClassTest {
    public static void main(String[] args) {
        double[] d = new double[20];
        for (int i = 0; i < d.length; i++)
            d[i] = 100 * Math.random();
        ArrayAlg.Pair p = ArrayAlg.minmax(d);
        System.out.println("min = " + p.getFirst());
        System.out.println("max = " + p.getSecond());
    }
}

class ArrayAlg {
    /**
     * 一对浮点数
     */
    public static class Pair {
        private double first;
        private double second;

        /**
         * Constructs a pair from two floating-point numbers
         * @param f 第一个数字
         * @param s 第二个数字
         */
        public Pair(double f, double s) {
            first = f;
            second = s;
        }

        /**
         * 返回一对的第一个数字
         * @return 第一个数字
         */
        public double getFirst() {
            return first;
        }

        /**
         * 返回一对的第二个数字
         * @return 第二个数字
         */
        public double getSecond() {
            return second;
        }
    }

    /**
     * 计算数组的最小值和最大值
     * @param values 一组浮点数
     * @return 一对，第一个元素是最小元素，第二个元素是最大元素
     */
    public static Pair minmax(double[] values) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (double v : values) {
            if (min > v) min = v;
            if (max < v) max = v;
        }
        return new Pair(min, max);
    }
}