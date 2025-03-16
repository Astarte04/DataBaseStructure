public class sequenceList2 {
    public static void main(String[] args) {
        sequenceList<String> s1=new sequenceList<>(2);
        s1.insert(0,"a");
        s1.insert(1,"b");
        s1.insert(2,"c");
        for (String s : s1) {
            System.out.println(s);
        }
    }
}
