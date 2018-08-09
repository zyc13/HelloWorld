import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.function.IntConsumer;

public class Main {
    Runnable r1 = () -> System.out.println(this);
    Runnable r2 = () -> System.out.println(toString());

    @Override
    public String toString() {
        return "Hello, World";
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new FileInputStream(""), "UTF-8")) {
            while (in.hasNext())
                System.out.println(in.next());
        }
    }
}
