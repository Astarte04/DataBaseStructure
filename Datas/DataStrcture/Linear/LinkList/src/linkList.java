import java.util.Iterator;
public class linkList<T>  implements Iterable<T> {
    //记录头节点
    private Node head;
    //记录链表的长度
    private int size;



    //节点类
    private class Node {
        //储存节点
        T item;
        //获取下一个节点
        Node next;
        public Node(T item,Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public linkList() {
        //初始化头节点
        this.head = new Node(null,null);
        //初始化元素个数
           size = 0;
    }
    //清空链表
    public void clear()
    {
        head.next = null;
        this.size = 0;
    }
    //获取链表长度
    public int length()
    {
        return this.size;
    }

    //判断链表是否为空
    public boolean isEmpty()
    {
       return size==0;
    }

    //获取指定位置i处的元素
    public T get(int index)
    {
        Node node = head.next;
        for (int i = 0;i<index; i++)
        {
            node= node.next;
        }
        return node.item;
    }

    //向链表中添加元素
    public void insert(T t)
    {
        //找到当前最后一个节点
        Node node=head;
        while(node.next!=null)
        {
            node= node.next;
        }
        //创造新的节点
        Node NewNode = new Node(t, null);
        //让最后一个节点指向新创建的节点
        node.next=NewNode;
        //元素的个数加一
        size++;
    }

    //向链表指定位置i处，添加元素
    public void insert(int i, T t)
    {
        Node pre = head;
        for (int index = 0;index<i;index++)
        {
            pre= pre.next;
        }
        //位置i的节点
        Node curr= pre.next;
        //构建新的节点，让新节点指向位置i的节点
        Node newNode= new Node(t,curr);
        //让之前的节点指向新的节点
        pre.next=newNode;
        size++;
    }

    //删除指定位置i处的元素，并返回删除的元素
    public  T remove(int i)
    {
        Node pre = head;
        for (int index = 0;index<=i-1;index++)
        {
            pre=pre.next;
        }
        Node curr=pre.next;
        pre.next=curr.next;
        size--;
        return curr.item;
    }
    //查找元素在链表中第一次出现的位置
    public int indexOF(T t)
    {
        Node n = head;
        for (int i = 0;n!=null;i++)
        {
            if(n.item.equals(t))
            {
                return i;
            }
              n= n.next;
        }

        return -1;
    }
    @Override
    public Iterator iterator() {
       return new linkrator();
    }
    private class linkrator implements Iterator<T>
    {
        private Node node;
        public linkrator() {
            node = head.next;
        }

        @Override
        public boolean hasNext() {
         return node.next != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            T item = node.item;
            node = node.next;
            return item;
        }
        }
        public void reverse()
        {
           if (isEmpty())
           {
               return;
           }
           reverse(head.next);
        }

        public Node reverse(Node curr) {
           if(curr.next==null)
           {
               head.next=curr;
               return curr;
           }
           //递归的去反转下一个节点：返回值为链表反转后的上一个节点
            Node pre=reverse(curr.next);
            pre.next=curr;
            curr.next=null;
            return curr;
        }
    }

