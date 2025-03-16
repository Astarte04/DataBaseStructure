public class SymbolTableTest {

        public SymbolTableTest() {
        }

        public static void main(String[] args) {
            SymbolTable<Integer, String> m1 = new SymbolTable();
            m1.put(1, "a");
            m1.put(2, "b");
            m1.put(3, "c");
            m1.put(4, "d");
            m1.put(5, "e");
            m1.print();
            System.out.println(m1.size());
            System.out.println("-------------------------------");
            m1.put(1, "f");
            m1.print();
            System.out.println(m1.size());
        }
    }

