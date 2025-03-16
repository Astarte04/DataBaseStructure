import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class test1 {
    //调用不同的测试方法
    public static void main(String[] args) throws IOException {
     //创建ArrayList集合，保存读取的整数
        ArrayList<Integer> arr=new ArrayList<>();
        //创建缓存读取流BufferReader，读取数据，并存储到Arraylist中
        BufferedReader reader = new BufferedReader(new InputStreamReader(ShellSort.class.getClassLoader().getResourceAsStream("arr_test.txt")));
        //把ArrayList集合转换为数组
     String  line=null;
     while((line=reader.readLine())!=null)
     {
         Integer num=Integer.parseInt(line);
         arr.add(num);
     }
        reader.close();
        //调用代码
        Integer[] a=new Integer[arr.size()];
        arr.toArray(a);
        shellTest(a);
        insertTest(a);


    }


    //调试希尔排序
    public static void shellTest(Integer[] arr)
    {
        //获取当前时间
        long start = System.currentTimeMillis();
        //执行算法代码
       shellTest(arr);
       //获取完成代码的时间
        long end = System.currentTimeMillis();
        //得到时间差，并且输出
        System.out.println(end - start);
    }
    //测试插入排序
    public static void insertTest(Integer[] arr)
    {
        long start = System.currentTimeMillis();
       insertTest(arr);
       long end = System.currentTimeMillis();
       System.out.println(end - start);
    }


}
