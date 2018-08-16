package util9.linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 该程序演示LinkedList上的操作。
 */
public class LinkedListTest {
    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        // 将b中的单词合并到a中

        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }

        System.out.println(a);

        // 删除b中的每第二个单词

        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next();  // 跳过一个元素
            if (bIter.hasNext()) {
                bIter.next();  // 跳过下一个元素
                bIter.remove();  // 删除该元素
            }
        }

        System.out.println(b);

        // 批量操作：从a中删除b中的所有单词

        a.removeAll(b);

        System.out.println(a);
    }
}
