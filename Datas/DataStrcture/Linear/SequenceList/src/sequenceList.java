import java.util.Iterator;

public class sequenceList<T> implements Iterable<T> {  //连续的
    //存储元素的数组
    private T[] elses;
    //记录当前顺序表中的元素个数
    private int size;

    public sequenceList(int capacity) {
        //初始化数据
        this.elses = (T[]) new Object[capacity];
        //初始化长度
        this.size = 0;
    }
    //将一个线性表置为空表
    public void clear()
    {
        this.size = 0;
    }

    //判断当前线性表是否为空表
    public boolean IsEmpty()
    {
      return this.size == 0;
    }
    //获取线性表的长度
    public int length(){
       return this.size;
    }
    //获取指定位置的元素
    public T get(int index)
    {
        return this.elses[index];
    }

    //向线性表中添加元素
    public void insert(T item){
        if(elses.length == this.size)
            resize(elses.length * 2);
        elses[size++] = item;
    }
    //在i元素处插入t元素
    public void insert(int i, T item){
        if(elses.length == this.size)
            resize(elses.length * 2);

        //先将i元素及其后面的值向后移动
        for(int index=size; index>i; index--){
            elses[index] = elses[index-1];
        }
        //再将需要插入的元素放到i以前的位置
        elses[i] = item;
        //元素个数+1
        size++;
    }
    //删除指定位置i处的元素，并返回该元素

public void resize(int newSize){
        //定义一个临时数组，指向原数组
        T[] temp=elses;
        this.elses=(T[]) new Object[newSize];
    //遍历原数组，将原数组的元素复制到现在的数组中来
    for(int i=0; i<size; i++){
        elses[i]=temp[i];
    }
}
    public T remove (int i)
    {
        if(size< elses.length/4)
        {
            resize(elses.length/2);
        }
        //记录索引i处的值
        T current = elses[i];
        //索引i后面的元素依次向前移动一位
        for(int index=i; index<size-1; index++){
            elses[index] = elses[index+1];
        }
        //元素个数减一
        size--;
        return current;
    }
    //查找元素t第一次出现位置
    public int indexOf(T t)
    {
        for(int i=0;i<size;i++){
            if(t==elses[i]){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Siterator();
    }
    private class Siterator implements Iterator<T> {
        private int cusor;
     public Siterator() {
         this.cusor = 0;
     }
        @Override
        public boolean hasNext() {
          return cusor < size;
        }

        @Override
        public T next() {
            return elses[cusor++];
        }
    }
}

