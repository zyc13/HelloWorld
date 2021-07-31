package test;

import java.util.Arrays;

/**
 * 随机排序1-100。用的是简单的洗牌算法
 */
public class RandomSort {

    public static void main(String[] args) {
        int n = 100;
        int[] temp = new int[n];
        for(int i = 0; i < n; i++) {
            temp[i] = i + 1;
        }

        for (int i = temp.length - 1; i >= 0; i--) {
            int h = (int) (Math.random() * (i + 1));  // 如果后面乘的是 i，则永远都取不到最后一位，比如最后一位永远不可能是 100，这样就不算随机
            int tmpInt = temp[h];
            temp[h] = temp[i];
            temp[i] = tmpInt;
        }

        System.out.println(Arrays.toString(temp));
    }
}
