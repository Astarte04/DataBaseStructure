


public class testComparable {

    public static void main(String[] args) {
student s1=new student(20,"leo");
student s2=new student(18,"le");
 Comparable compare=compare(s1,s2);
        System.out.println(compare);
    }

    public static Comparable compare(Comparable a, Comparable b) {
        int res = a.compareTo(b);
        if (res < 0) {
            return b;
        } else {
            return a;
        }
    }


}

