import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.function.IntConsumer;

public class Main {
    Runnable r1 = () -> System.out.println(this);
    Runnable r2 = () -> System.out.println(toString());

    @Override
    public String toString() {
        return "Hello, World";
    }

    public static void main(String[] args) {
        new Main().r1.run();
        new Main().r2.run();
    }
}
