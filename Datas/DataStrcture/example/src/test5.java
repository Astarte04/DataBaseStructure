public class test5 {
    public static int[] reverse(int[] arr)
    {
        int n=arr.length;
        int temp;
        for (int left=0,right=n-1;left>=right;left++,right--)
        {
            temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
        }
        return arr;
    }

}
