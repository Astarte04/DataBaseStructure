public class OrderSymbolTable<Key extends Comparable<Key>, Value> {
    private Node head; // 头节点
    private int N; // 元素数量

    public OrderSymbolTable() {
        head = new Node(null, null, null); // 初始化头结点
        N = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void put(Key key, Value value) {
        Node pre = head;
        Node curr = head.next;

        // 找到正确的插入位置
        while (curr != null && curr.key.compareTo(key) < 0) {
            pre = curr;
            curr = curr.next;
        }

        // 如果 key 已存在，更新 value
        if (curr != null && curr.key.compareTo(key) == 0) {
            curr.value = value;
        } else {
            // 在 pre 和 curr 之间插入新节点
            Node newNode = new Node(key, value, curr);
            pre.next = newNode;
            N++; // 更新大小
        }
    }

    public void delete(Key key) {
        Node pre = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.key.equals(key)) {
                pre.next = curr.next;
                N--; // 更新大小
                return;
            }
            pre = curr;
            curr = curr.next;
        }
    }

    public void print() {
        Node n = head.next;
        while (n != null) {
            System.out.println(n.value);
            n = n.next;
        }
    }

    public Value get(Key key) {
        Node n = head.next;
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
