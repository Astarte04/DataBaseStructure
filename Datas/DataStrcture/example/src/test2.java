public class test2 {

    public static long fun1(int n)
    {
        if(n==1)
            return 1;
        else
            return n*fun1(n-1);
    }
    public static long fun2(int n)
    {
        int res=1;
        for (int i = 1; i <=n; i++) {
          res *= i;
        }
        return res;
    }



    public static void main(String[] args) {
        long sum1= fun1(10);
        System.out.println(sum1);
        long sum2= fun2(10);
        System.out.println(sum2);
    }
}
