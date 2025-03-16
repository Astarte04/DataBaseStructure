import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;


    public class tree<Key extends Comparable<Key>, Value> {
        private tree<Key, Value>.Node root;
        private int size;

        public tree() {
        }

        public int size() {
            return this.size;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public void insert(Key key, Value value) {
            this.root = this.insert(this.root, key, value);
        }

        public tree<Key, Value>.Node insert(tree<Key, Value>.Node x, Key key, Value value) {
            if (x == null) {
                ++this.size;
                return new Node(key, value, (Node)null, (Node)null);
            } else {
                int cmp = key.compareTo(x.key);
                if (cmp < 0) {
                    x.left = this.insert(x.left, key, value);
                } else if (cmp > 0) {
                    x.right = this.insert(x.right, key, value);
                } else {
                    x.value = value;
                }

                return x;
            }
        }

        public Value get(Key key) {
            return (Value)this.get(this.root, key);
        }

        public Value get(tree<Key, Value>.Node x, Key key) {
            if (x == null) {
                return null;
            } else if (key.compareTo(x.key) < 0) {
                return (Value)this.get(x.left, key);
            } else {
                return (Value)(key.compareTo(x.key) > 0 ? this.get(x.right, key) : x.value);
            }
        }

        public void delete(Key key) {
            this.delete(this.root, key);
        }

        public tree<Key, Value>.Node delete(tree<Key, Value>.Node x, Key key) {
            if (x == null) {
                return null;
            } else {
                int cmp = key.compareTo(x.key);
                if (cmp < 0) {
                    x.left = this.delete(x.left, key);
                } else if (cmp > 0) {
                    x.right = this.delete(x.right, key);
                } else {
                    if (x.left == null) {
                        return x.right;
                    }

                    if (x.right == null) {
                        return x.left;
                    }

                    tree<Key, Value>.Node minNode = this.getMin(x.right);
                    minNode.right = this.deleteMin(x.right);
                    minNode.left = x.left;
                    x = minNode;
                }

                return x;
            }
        }

        private tree<Key, Value>.Node getMin(tree<Key, Value>.Node x) {
            while(x.left != null) {
                x = x.left;
            }

            return x;
        }

        public Key min() {
            return this.min(this.root).key;
        }

        public tree<Key, Value>.Node min(tree<Key, Value>.Node x) {
            return x.left != null ? this.min(x.left) : x;
        }

        public Key max() {
            return this.max(this.root).key;
        }

        public tree<Key, Value>.Node max(tree<Key, Value>.Node x) {
            return x.right != null ? this.max(x.right) : x;
        }

        private tree<Key, Value>.Node deleteMin(tree<Key, Value>.Node x) {
            if (x.left == null) {
                return x.right;
            } else {
                x.left = this.deleteMin(x.left);
                return x;
            }
        }

        public void print() {
            this.print(this.root);
        }

        private void print(tree<Key, Value>.Node x) {
            if (x != null) {
                this.print(x.left);
                PrintStream var10000 = System.out;
                String var10001 = String.valueOf(x.key);
                var10000.println("Key: " + var10001 + ", Value: " + String.valueOf(x.value));
                this.print(x.right);
            }
        }

        public Queue<Key> preErgodic() {
            Queue<Key> keys = new LinkedList();
            this.preErgodic(this.root, keys);
            return keys;
        }

        public void preErgodic(tree<Key, Value>.Node x, Queue<Key> keys) {
            if (x != null) {
                keys.add(x.key);
                if (x.left != null) {
                    this.preErgodic(x.left, keys);
                }

                if (x.right != null) {
                    this.preErgodic(x.right, keys);
                }

            }
        }

        public Queue<Key> midErgodic() {
            Queue<Key> keys = new LinkedList();
            this.midErgodic(this.root, keys);
            return keys;
        }

        public void midErgodic(tree<Key, Value>.Node x, Queue<Key> keys) {
            if (x != null) {
                if (x.left != null) {
                    this.midErgodic(x.left, keys);
                }

                keys.add(x.key);
                if (x.right != null) {
                    this.midErgodic(x.right, keys);
                }

            }
        }

        public Queue<Key> afterErgodic() {
            Queue<Key> keys = new LinkedList();
            this.afterErgodic(this.root, keys);
            return keys;
        }

        public void afterErgodic(tree<Key, Value>.Node x, Queue<Key> keys) {
            if (x != null) {
                if (x.left != null) {
                    this.afterErgodic(x.left, keys);
                }

                if (x.right != null) {
                    this.afterErgodic(x.right, keys);
                }

                keys.add(x.key);
            }
        }

        public Queue<Key> layerErgodic() {
            Queue<Key> keys = new LinkedList();
            Queue<tree<Key, Value>.Node> nodes = new LinkedList();
            nodes.add(this.root);

            while(!nodes.isEmpty()) {
                tree<Key, Value>.Node node = (Node)nodes.remove();
                keys.add(node.key);
                if (node.left != null) {
                    nodes.add(node.left);
                }

                if (node.right != null) {
                    nodes.add(node.right);
                }
            }

            return keys;
        }

        public int maxDepth() {
            return this.maxDepth(this.root);
        }

        private int maxDepth(tree<Key, Value>.Node x) {
            if (x == null) {
                return 0;
            } else {
                int max = 0;
                int maxl = 0;
                int maxr = 0;
                if (x.left != null) {
                    maxl = this.maxDepth(x.left);
                }

                if (x.right != null) {
                    maxr = this.maxDepth(x.right);
                }

                max = maxl > maxr ? maxl + 1 : maxr + 1;
                return max;
            }
        }

        private class Node {
            public Key key;
            public Value value;
            public tree<Key, Value>.Node left;
            public tree<Key, Value>.Node right;

            public Node(Key key, Value value, tree<Key, Value>.Node left, tree<Key, Value>.Node right) {
                this.key = key;
                this.value = value;
                this.left = left;
                this.right = right;
            }
        }
    }

