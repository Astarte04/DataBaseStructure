public class quiCKSort {
    private static boolean less(Comparable v,Comparable w)
    {
        return v.compareTo(w) < 0;
    }
    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //对数组内的元素进行排序
    public static void sort(Comparable[] a) {
        int lo=0;
        int hi=a.length-1;
        sort(a,lo,hi);

    }
    //对数组中从索引lo到hi之间的元素进行排序
    public static void sort(Comparable[] a, int lo, int hi) {
        //安全性校验
        if (hi <= lo) return;
        //需要对数组中从索引lo到索引hi的元素进行分组（左子组，右子组）
     int partition= partition(a,lo,hi);//返回的是分组值所在的索引，分界值位置变换后的索引
        //让左边有序
       sort(a,lo,partition-1);
        //让右边有序
        sort(a,partition+1,hi);

    }
    // 对数组中，从索引lo到hi之间的元素进行分组，并返回分组界限对应的索引
    public static int partition(Comparable[] a, int lo, int hi) {
     //确定分解值
     Comparable key = a[lo];
     int left = lo;
     int right = hi+1;
     //切分
     while (true) {
         //先从右往左边扫描，移动right指针，找到一个比分解值小的元素，停止
         while (less(key,a[--right])) {
             if (right == lo) break;
         }
         //再从左边往右边扫描，移动left指针，找到一个比分解值大的元素，停止
       while (less(a[++left],key)) {
           if (left == hi) break;
       }
         //判断left>=right,如果是，则停止扫描
       if (left >= right) break;
       else exch(a,left,right);
     }
     //交换分界值
     exch(a,lo,right);
       return right;
    }
}
//public class QuickSort {
//    private static boolean less(Comparable v, Comparable w) {
//        return v.compareTo(w) < 0;
//    }
//
//    private static void exch(Comparable[] a, int i, int j) {
//        Comparable temp = a[i];
//        a[i] = a[j];
//        a[j] = temp;
//    }
//
//    // 对数组进行排序
//    public static void sort(Comparable[] a) {
//        int lo = 0;
//        int hi = a.length - 1;
//        sort(a, lo, hi);
//    }
//
//    // 递归排序
//    public static void sort(Comparable[] a, int lo, int hi) {
//        if (hi <= lo) return;
//        int partition = partition(a, lo, hi);
//        sort(a, lo, partition - 1);
//        sort(a, partition + 1, hi);
//    }
//
//    // 分区方法
//    public static int partition(Comparable[] a, int lo, int hi) {
//        Comparable key = a[lo];
//        int left = lo;
//        int right = hi + 1;
//
//        while (true) {
//            // 从右往左扫描，找到比 key 小的元素
//            while (less(key, a[--right])) {
//                if (right == lo) break;
//            }
//            // 从左往右扫描，找到比 key 大的元素
//            while (less(a[++left], key)) {
//                if (left == hi) break;
//            }
//            // 如果左右指针相遇，退出循环
//            if (left >= right) break;
//            exch(a, left, right);
//        }
//        // 交换 key 和 right 位置的值
//        exch(a, lo, right);
//        return right;
//    }
//}
