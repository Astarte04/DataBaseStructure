import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    private Node head = null; // 队列的头节点
    private Node last = null; // 队列的尾节点
    private int size = 0; // 队列的大小

    // 构造函数
    public Queue() {
    }

    // 检查队列是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 获取队列的大小
    public int size() {
        return size;
    }

    // 入队操作
    public void inQueue(T t) {
        Node newNode = new Node(t, null);
        if (isEmpty()) {
            head = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    // 出队操作
    public T outQueue(T t) {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = head.item;
        head = head.next;
        if (head == null) {  // 如果队列为空，尾节点也应该为空
            last = null;
        }
        size--;
        return item;
    }

    // 打印队列
    public void printQueue() {
        for (Node curr = head; curr != null; curr = curr.next) {
            System.out.print(curr.item + " ");
        }
        System.out.println();
    }

    // 实现 Iterable 接口
    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
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

    // 队列迭代器
    private class QueueIterator implements Iterator<T> {
        private Node current;

        public QueueIterator() {
            this.current = head; // 从队列头开始
        }

        @Override
        public boolean hasNext() {
            return current != null; // 当前节点不为 null，表示还有元素
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new IllegalStateException("No more elements");
            }
            T item = current.item;
            current = current.next; // 移动到下一个节点
            return item;
        }
    }
}