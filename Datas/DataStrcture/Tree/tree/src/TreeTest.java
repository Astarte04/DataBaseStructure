
    public class TreeTest {
        public TreeTest() {
        }

        public static void main(String[] args) {
            tree<String, String> m2 = new tree();
            m2.insert("E", "5");
            m2.insert("B", "2");
            m2.insert("G", "7");
            m2.insert("A", "1");
            m2.insert("D", "4");
            m2.insert("F", "6");
            m2.insert("H", "8");
            m2.insert("C", "3");

            for(String key : m2.preErgodic()) {
                String s = (String)m2.get(key);
                System.out.print(key + " ");
            }

            System.out.println();
            System.out.println("------------------------------------");

            for(String key : m2.midErgodic()) {
                String s1 = (String)m2.get(key);
                System.out.print(key + " ");
            }

            System.out.println();
            System.out.println("------------------------------------");

            for(String key : m2.afterErgodic()) {
                String s1 = (String)m2.get(key);
                System.out.print(key + " ");
            }

            System.out.println();
            System.out.println("------------------------------------");

            for(String key : m2.layerErgodic()) {
                String s1 = (String)m2.get(key);
                System.out.print(key + " ");
            }

            System.out.println();
            int max = m2.maxDepth();
            System.out.println("最大深度：" + max);
        }
    }


