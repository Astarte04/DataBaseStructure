public class selectionSort {
    private static boolean greater(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }
    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i <= N-2; i++) {
            //定义一个变量，记录最小元素所在的位置，默认为参加选择排序的第一个元素所在的位置
            int minindex=i;
            for (int j = i+1; j < N; j++) {
                if (greater(a[minindex], a[j])) {
                  minindex = j;
                }
            }
            //交换最小元素所在的索引minindex处的值和索引i处的值
            exchange(a, i, minindex);
        }
    }
}
