public class insertsort {
  private static boolean greater(Comparable a, Comparable b) {
      return a.compareTo(b) > 0;
  }
  private static void exchange(Comparable[] arr,int i,int j) {
      Comparable tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
  }
  //对数组a中的元素进行排序
  public static void sort(Comparable[] arr) {
     for (int i = 1; i < arr.length; i++) {
         for (int j = i; j > 0; j--) {
             if (greater(arr[j], arr[j - 1])) {
                 exchange(arr, j, j-1 );
             }
             else
                 break;
         }
     }
  }
}
