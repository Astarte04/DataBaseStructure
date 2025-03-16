import java.util.Arrays;

public class mergeTest {
    public mergeTest() {
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{8, 4, 5, 7, 1, 3, 6, 2};
        merge.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
