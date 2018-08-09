package util6.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * 该程序演示了代理的使用。
 */
public class ProxyTest {
    public static void main(String[] args) {
        Object[] elements = new Object[1000];

        // 使用Integer 1 ... 1000的代理填充元素
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            InvocationHandler handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
            elements[i] = proxy;
        }

        // 构造一个随机整数
        Integer key = new Random().nextInt(elements.length) + 1;

        // 查找key
        int result = Arrays.binarySearch(elements, key);

        // 如果找到则打印匹配
        if (result > 0) System.out.println(elements[result]);
    }
}

/**
 * 一个调用处理程序，它打印出方法名称和参数，然后调用原始方法。
 */
class TraceHandler implements InvocationHandler {
    private Object target;

    /**
     * 构造一个TraceHandler
     * @param t 方法调用的隐式参数
     */
    public TraceHandler(Object t) {
        target = t;
    }

    @Override
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        // 打印隐式参数
        System.out.print(target);
        // 打印方法名称
        System.out.print("." + m.getName() + "(");
        // 打印显式参数
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) System.out.print(", ");
            }
        }
        System.out.println(")");

        // 调用实际方法
        return m.invoke(target, args);
    }
}
