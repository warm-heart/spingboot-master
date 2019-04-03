package Array;

/**
 * @author wangqianlong
 */

public class Array {

    private int[] data;
    //size为下标索引
    private int size;

    // 构造函数 capacity 传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    //无参构造函数，默认数组容量capacity=10
    public Array() {
        this(10);
    }

    //获取数组中元素个数
    public int getSize() {
        return size;
    }

    //获取数组容量
    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //向数组尾部增加元素
    public void addLast(int e) {
        /*if (size == data.length)
            throw new IllegalArgumentException("AddLast failed.Array is full");
        data[size] = e;
        size++;*/
        //可以调用下面方法
        add(size, e);
    }

    //在头位置添加元素
    public void addFirst(int e) {
        add(0, e);
    }

    //在第index位置处插入新元素e
    public void add(int index, int e) {
        if (size == data.length)
            throw new IllegalArgumentException("AddLast failed.Array is full");
        if (index < 0 || index > size)
            throw new IllegalArgumentException("AddLast failed.index < 0 or index > size");
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;

    }

    //查询元素


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d ,capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

}
