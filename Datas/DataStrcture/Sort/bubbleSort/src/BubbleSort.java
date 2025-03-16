public class BubbleSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        boolean swapped;  // 用于优化，当一轮遍历未发生交换时，提前结束排序
        for (int i = N - 1; i > 0; i--) {
            swapped = false;
            for (int j = 0; j < i; j++) {
                if (greater(a[j], a[j + 1])) {
                    exch(a, j, j + 1);
                    swapped = true;
                }
            }
            // 如果没有发生交换，说明已经有序，提前结束
            if (!swapped) break;
        }
    }
    private static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }



}
