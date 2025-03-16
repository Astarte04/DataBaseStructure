
    public class JosephTest {
        public JosephTest() {
        }

        public static void main(String[] args) {
            Node<Integer> first = null;
            Node<Integer> pre = null;

            for(int i = 1; i <= 41; ++i) {
                if (i == 1) {
                    first = new Node<Integer>(i, (Node)null);
                    pre = first;
                } else {
                    Node<Integer> newNode = new Node<Integer>(i, (Node)null);
                    pre.next = newNode;
                    pre = newNode;
                    if (i == 41) {
                        newNode.next = first;
                    }
                }
            }

            int count = 0;
            Node<Integer> n = first;
            Node<Integer> before = null;

            while(n != n.next) {
                ++count;
                if (count == 3) {
                    before.next = n.next;
                    System.out.print(String.valueOf(n.item) + ",");
                    count = 0;
                    n = n.next;
                } else {
                    before = n;
                    n = n.next;
                }
            }

            System.out.println(n.item);
        }

        private static class Node<T> {
            T item;
            Node next;

            public Node(T item, Node next) {
                this.item = item;
                this.next = next;
            }
        }
    }

