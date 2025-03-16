public class SymbolTable<Key, Value> {
    private Node head;
    private int N;

    public SymbolTable() {
        head = new Node(null, null, null); // 初始化头节点
        N = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void put(Key key, Value value) {
        Node n = head.next; // 从头节点的下一个节点开始遍历

        while (n != null) {
            if (n.key.equals(key)) {
                n.value = value;
                return; // key 已存在，直接返回
            }
            n = n.next;
        }

        // 插入新节点
        Node newNode = new Node(key, value, head.next);
        head.next = newNode;
        N++; // 更新大小
    }

    public void delete(Key key) {
        Node pre = head;
        while (pre.next != null) {
            if (pre.next.key.equals(key)) {
                pre.next = pre.next.next;
                N--;
                return;
            }
            pre = pre.next;
        }
    }

    public void print() {
        Node n = head.next; // 跳过头节点
        while (n != null) {
            System.out.println(n.value);
            n = n.next;
        }
    }

    public Value get(Key key) {
        Node n = head.next; // 从第一个实际节点开始遍历
        while (n != null) {
            if (n.key.equals(key)) {
                return n.value;
            }
            n = n.next;
        }
        return null;
    }

    private class Node {
        public Key key;
        public Value value;
        public Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}