import java.util.Arrays;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Test {
    public static void main(String[] args) {
        Integer[] a={1,8,9,5,10,8,89};
        ShellSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}