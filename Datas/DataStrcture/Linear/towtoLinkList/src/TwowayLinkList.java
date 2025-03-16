import org.w3c.dom.Node;

import java.util.Iterator;

public class TwowayLinkList <T> implements Iterable<T>{
//首节点
    private Node head;
    //最后一个节点
    private Node last;
    //链表的长度
    private int size;


    //节点类
    private class Node{
        public Node(T item,Node pre,Node next)
        {
            this.item=item;
            this.pre=pre;
            this.next=next;
        }
        //存储数据
        public T item;
        //指向上一个节点
        public Node pre;
        //指向下一个节点
        public Node next;
    }
    public TwowayLinkList(){
        //初始化头节点和尾节点
        this.head=new Node(null,null,null);
        this.last=this.head;
        // 初始化元素个数
        this.size=0;
    }
    //清空链表
    public void clear(){
        this.head.pre=null;
        this.head.next=null;
        this.last=null;
        this.size=0;
    }
    //获取链表长度
    public int size(){
        return this.size;
    }
    //判断链表是否为空
    public boolean isEmpty(){
        return this.size()==0;
    }
    //获取第一个元素
    public T getFirst()
    {
        if(this.isEmpty())
        {
            return null;
        }

        return this.head.item;
    }
    // 获取最后一个元素
    public  T getLast()
    {
        if(this.isEmpty())
        {
            return null;
        }
        return this.last.item;
    }
    //插入元素T
    public void insert(T item)
    {
         if(isEmpty())
         {
             Node newNode=new Node(item,head,null);
             last=newNode;
             head.next=last;
         }
         else{
             //链表不为空
                 Node oldlast=last;
                 Node newNode=new Node(item,oldlast,null);
                 oldlast.next=newNode;
                 this.last=newNode;
             }
         size++;
    }
    //在指定位置i插入元素T
    public  void insert(int index,T item)
    {
        Node pre=head;
        for (int i=0;i<index;i++)
        {
            pre=pre.next;
        }
        Node curr=pre.next;
        Node newNode=new Node(item,pre,curr);
        pre.next=newNode;
        curr.pre=newNode;
        size++;
    }
    //获取指定位置i处的元素
    public T get(int index)
    {
        Node node=head.next;
        for (int i=0;i<index;i++)
        {
            node=node.next;
        }
        return node.item;
    }
 //找到元素t在链表中第一次出现的位置
    public int indexOf(T item)
    {
        Node node=head;
        for (int i=0;node.next!=null;i++)
        {
            if (node.next.equals(item))
            {
                return i;
            }
        }
        return -1;
    }
//删除位置i处的元素
    public T remove(int index)
    {
        Node pre=head;
        for (int i=0;i<index;i++){
            pre=pre.next;
        }
      Node curr=pre.next;
        Node curr1=curr.next;
        pre.next=curr1.next;
        curr1.next=pre;
        size--;
        return curr.item;
    }
    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }
    private class TIterator implements Iterator{
    private TwowayLinkList.Node n;
    public TIterator(){
        this.n=head;
    }
        @Override
        public boolean hasNext() {
         return n.next!=null;
        }

        @Override
        public Object next() {
           n=n.next;
           return n.item;
        }
    }


}
