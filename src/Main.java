import java.util.HashMap;
import java.util.Map;

public class Main {
    private final static Object lock = new Object();

    static class Print implements Runnable {

        private int max_print;
        private int count = 0;
        private String str = "A";

        public Print(int max_print) {
            this.max_print = max_print;
        }

        @Override
        public void run() {
            synchronized (lock) {
                String name = Thread.currentThread().getName();
                while (count < max_print) {
                    if (str.equals(name)) {
                        System.out.print(name);
                        if (str.equals("A")) {
                            str = "B";
                        } else if (str.equals("B")) {
                            str = "C";
                        } else {
                            count++;
                            str = "A";
                        }
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        /*Print print = new Print(15);
        new Thread(print, "A").start();
        new Thread(print, "B").start();
        new Thread(print, "C").start();*/
        String[] zhuanye = {"英语教育", "语文教育", "会计", "学前教育", "市场营销", "旅游管理", "电子商务", "护理", "会计", "商务英语", "新闻采编与制作", "旅游管理", "电子商务", "助产", "护理", "药品经营与管理", "针灸推拿", "会计", "工商企业管理", "法律事务", "经济信息管理", "行政管理", "人力资源管理", "会计", "信息统计与分析", "商务日语", "商务英语", "市场营销", "文秘", "酒店管理", "会计", "历史教育", "思想政治教育", "英语教育", "语文教育", "保险", "学前教育", "物业管理", "电子商务", "英语教育", "语文教育", "酒店管理", "护理", "历史教育", "学前教育", "小学教育", "市场营销", "电子商务", "英语教育", "语文教育", "保险", "工商企业管理", "应用韩语", "建筑经济管理", "物流类(中外合", "语言类(中外合", "学前教育", "学前教育(藏彝", "法律事务", "英语教育", "语文教育", "酒店管理", "食品药品监督管", "会计", "旅游管理", "法律事务", "老年服务与管理", "会计", "国际经济与贸易", "工程造价", "会计", "市场营销", "建筑装饰工程技", "旅游管理", "旅游英语", "物业管理", "电子商务", "计算机应用技术", "软件技术", "酒店管理", "助产", "医学影像技术", "医学生物技术", "医学营养", "卫生信息管理", "口腔医学技术(", "康复治疗技术", "护理", "护理类(中外合", "眼视光技术", "药学", "会计", "旅游管理", "学前教育", "少数民族预科", "旅游管理", "社区管理与服务", "英语教育", "语文教育", "学前教育", "法律事务", "语文教育"};
        Map<String, Integer> map = new HashMap<>(zhuanye.length);
        for (String s : zhuanye) {
            map.merge(s, 1, Integer::sum);
        }
        System.out.println(map);
    }
}
