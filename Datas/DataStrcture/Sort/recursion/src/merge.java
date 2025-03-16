import java.util.Arrays;

public class merge {
    private  static Comparable[] assist;
    public static void sort(Comparable[] a)
    {
        //初始化辅助数组assist
        assist = new Comparable[a.length];
        //定义变量lo与hi，来记录数组中的最大索引与最小索引
        int lo = 0, hi = a.length - 1;
        //调用sort重载方法完成数组a中，从索引lo到索引hi的排序
         sort(a, lo, hi);

    }
    public static void sort(Comparable[] a,int lo,int hi)
    {
       //安全性校验
        if(lo>=hi)
        {
            return;
        }
        //对lo到hi之间的元素进行分为两组
        int mid = lo + (hi - lo) / 2;
        //分别对每一组数据进行排序
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        //将两个组进行归并
        merge(a,lo,mid,hi);
    }
    private static void merge(Comparable[] a,int lo,int mid,int hi)
    {
        //定义三个指针，让指针进行遍历，并进行比较
        int i = lo;
        int p1=lo;
        int  p2 = mid+1;
        //遍历，移动指针，找到较小的放到辅助数组指定位置
        while (p1<=mid && p2<=hi)
        {
            //比较对应位置的值
            if(less(a[p1],a[p2]))
            {
               assist[i++]=a[p1++];
            }
            else {
                assist[i++]=a[p2++];
            }
        }
        //当p1的指针未走完，那么顺序移动p1指针，将对应元素放到指定的位置
        while (p1<=mid)
        {
            assist[i++]=a[p1++];
        }
        //当p2未走完，同样的道理
        while (p2<=hi)
        {
            assist[i++]=a[p2++];
        }
        //将辅助数组的元素拷贝到原来的数组
       for (int index = lo; index <= hi; index++)
       {
           a[index] = assist[index];
       }


    }
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
}


//public class MergeSort {
//    private static Comparable[] assist; // 辅助数组
//
//    public static void sort(Comparable[] a) {
//        // 初始化辅助数组，只创建一次，避免递归中重复分配内存
//        assist = new Comparable[a.length];
//        // 归并排序
//        sort(a, 0, a.length - 1);
//    }
//
//    private static void sort(Comparable[] a, int lo, int hi) {
//        // 递归终止条件：子数组长度为1
//        if (lo >= hi) {
//            return;
//        }
//        // 计算中点
//        int mid = lo + (hi - lo) / 2;
//        // 递归排序左半部分
//        sort(a, lo, mid);
//        // 递归排序右半部分
//        sort(a, mid + 1, hi);
//        // 合并两个有序子数组
//        merge(a, lo, mid, hi);
//    }
//
//    private static void merge(Comparable[] a, int lo, int mid, int hi) {
//        // 复制原数组到辅助数组
//        for (int k = lo; k <= hi; k++) {
//            assist[k] = a[k];
//        }
//
//        // 初始化指针
//        int p1 = lo, p2 = mid + 1;
//
//        // 遍历合并
//        for (int k = lo; k <= hi; k++) {
//            if (p1 > mid) { // 左半部分耗尽
//                a[k] = assist[p2++];
//            } else if (p2 > hi) { // 右半部分耗尽
//                a[k] = assist[p1++];
//            } else if (less(assist[p1], assist[p2])) { // 选择较小值
//                a[k] = assist[p1++];
//            } else {
//                a[k] = assist[p2++];
//            }
//        }
//    }
//
//    private static boolean less(Comparable v, Comparable w) {
//        return v.compareTo(w) < 0;
//    }
//
//    public static void main(String[] args) {
//        Integer[] arr = {4, 2, 6, 3, 1, 5};
//        MergeSort.sort(arr);
//        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5, 6]
//    }
//}
