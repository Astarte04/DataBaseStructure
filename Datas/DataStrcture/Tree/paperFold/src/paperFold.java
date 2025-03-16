import java.util.LinkedList;
import java.util.Queue;


public class paperFold {
    public paperFold() {
    }

    public static void main(String[] args) {
        Node tree = creatTree(2);
        printTree(tree);
    }

    public static Node creatTree(int N) {
        Node<String> root = null;

        for (int i = 0; i < N; ++i) {
            if (i == 0) {
                root = new Node<String>("down", (Node) null, (Node) null);
            } else {
                Queue<Node> queue = new LinkedList();
                queue.add(root);

                while (!queue.isEmpty()) {
                    Node<String> temp = (Node) queue.poll();
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }

                    if (temp.right != null) {
                        queue.add(temp.right);
                    }

                    if (temp.left == null && temp.right == null) {
                        temp.right = new Node("up", (Node) null, (Node) null);
                        temp.left = new Node("down", (Node) null, (Node) null);
                    }
                }
            }
        }

        return root;
    }

    public static void printTree(Node<String> root) {
        if (root != null) {
            if (root.left != null) {
                printTree(root.left);
            }

            System.out.print((String) root.itme + " ");
            if (root.right != null) {
                printTree(root.right);
            }

        }
    }

    public static class Node<T> {
        public T itme;
        public Node left;
        public Node right;

        public Node(T itme, Node left, Node right) {
            this.itme = itme;
            this.left = left;
            this.right = right;
        }
    }
}


