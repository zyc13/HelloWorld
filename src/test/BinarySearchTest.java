package test;

/**
 * 20181211手写二分查找算法
 */
public class BinarySearchTest {

    /**
     * 笔试的时候写的，调试。感觉写复杂了
     * @param arr 有序数组
     * @param hkey 查找元素
     * @return 查找元素所在的下标
     */
    public static String myBinarySearch(int[] arr, int hkey) {
        int mid = arr.length / 2;
        int midIndex = mid;

        while (mid > 0) {
            if (hkey < arr[midIndex]) {
                mid = mid / 2;
                midIndex -= mid;
            } else if (hkey > arr[midIndex]) {
                mid = mid / 2;
                midIndex += mid;
            } else {
                return "下标===" + midIndex;
            }
        }
        return "不存在这个数";
    }

    /**
     * 二分查找递归实现
     * @param arr 有序数组
     * @param start 数组低地址下标
     * @param end 数组高地址下标
     * @param hkey 查找元素
     * @return 查找元素所在的下标，不存在返回-1
     */
    public static int binarySearch2(int[] arr, int start, int end, int hkey) {
        if (start > end)
            return -1;
        int mid = start + (end - start) / 2;
        if (arr[mid] > hkey)
            return binarySearch2(arr, start, mid - 1, hkey);
        if (arr[mid] < hkey)
            return binarySearch2(arr, mid + 1, end, hkey);
        return mid;
    }

    /**
     * 二分查找普通实现
     * @param arr 有序数组
     * @param key 查找元素
     * @return 不存在返回-1
     */
    public static int binarySearch3(int[] arr, int key) {
        int mid;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] temp = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int x = 7;
        String result = BinarySearchTest.myBinarySearch(temp, x);
        System.out.println(result);
    }
}
