package util6.anonymousInnerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * 该程序演示了匿名内部类。
 */
public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock();
        clock.start(1000, true);

        // 保持程序运行，直到用户选择“确定”
        JOptionPane.showMessageDialog(null, "退出程序？");
        System.exit(0);
    }
}

/**
 * 一个以固定间隔打印时间的时钟。
 */
class TalkingClock {
    /**
     * 开始计时。
     * @param interval 消息之间的间隔（以毫秒为单位）
     * @param beep 如果时钟应该发出哔声，则为true
     */
    public void start(int interval, boolean beep) {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("At the tone, 时间是" + new Date());
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer t = new Timer(interval, listener);
        t.start();
    }
}