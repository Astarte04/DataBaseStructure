public class ShellSort {
    // 判断 a 是否比 b 大
    public static boolean greater(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }
    // 交换数组中索引 i 和 j 的元素
    public static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    // 希尔排序
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        // 使用 Knuth 递增序列 h = 3*h + 1
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        // 进行希尔排序
        while (h >= 1) {
            // 对每个间隔为 h 的子数组进行插入排序
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && greater(a[j - h], a[j]); j -= h) {
                    exchange(a, j - h, j);
                }
            }
            // 缩小间隔
            h = h / 3;
        }
    }}