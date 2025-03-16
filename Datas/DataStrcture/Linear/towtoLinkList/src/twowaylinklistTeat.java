public class twowaylinklistTeat {
    public static void main(String[] args) {
       TwowayLinkList<String> s1 = new TwowayLinkList<>();

        //测试插入
        s1.insert("yaoming");
        s1.insert("maidi");
        s1.insert("kobe");
        s1.insert(1,"cxk");

        for (String s:s1)
        {
            System.out.println(s);
        }
        System.out.println("------------");
        //测试获取
        String getresult=s1.get(1);
        System.out.println(getresult);
        //测试删除
        String removeResult= s1.remove(0);
        System.out.println(removeResult);
        //测试清空
        s1.clear();
    }
}
