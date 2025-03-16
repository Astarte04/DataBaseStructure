import java.util.Iterator;

public class StackTest<T> implements Iterable<T> {
    private Node head; // 头指针
    private int N; // 栈大小

    public StackTest() {
        head = new Node(null, null); // 初始化头节点
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(T item) {
        Node newHead = new Node(item, head.next);
        head.next = newHead;
        N++;
    }

    public T pop() {
        if (head.next == null) {
            return null;
        }
        Node oldHead = head.next;
        head.next = oldHead.next;
        N--;
        return oldHead.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new NodeIterator();
    }

    // 内部节点类
    private class Node {
        private T item;
        private Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    // 迭代器实现
    private class NodeIterator implements Iterator<T> {
        private Node current;

        public NodeIterator() {
            this.current = head.next; // 跳过头节点
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}