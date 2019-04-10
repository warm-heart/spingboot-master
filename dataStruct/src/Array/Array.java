package Array;


/**
 * @author wangqianlong
 */

public class Array<E> {


    private E[] data;
    //size为下标索引
    private int size;

    /**
     * @param capacity 构造函数 capacity 传入数组的容量capacity构造Array
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造函数，默认数组容量capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * @return 获取数组中元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * @return 获取数组容量
     */

    public int getCapacity() {
        return data.length;
    }

    /**
     * @return 判断数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param e 向数组尾部增加元素
     */
    public void addLast(E e) {
        /*if (size == data.length)
            throw new IllegalArgumentException("AddLast failed.Array is full");
        data[size] = e;
        size++;*/
        //可以调用下面方法
        add(size, e);
    }

    /**
     * @param e 在头位置添加元素
     */

    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * @param index 下标
     * @param e     元素
     *              在第index位置处插入新元素e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Array is full");
        if (size == data.length)
            resize(2 * data.length);
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * @param index 下标
     * @return 查询的元素
     */
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("index < 0 or index > size");
        return data[index];
    }

    /**
     * @return 获取最后一个元素
     */

    public E getLast() {
        return get(size - 1);
    }

    /**
     * @return 获取数组第一个元素
     */

    public E getFrist() {
        return get(0);
    }

    /**
     * @param index 下标
     * @param e     修改的元素
     *              修改元素
     */
    void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("index < 0 or index > size");
        data[index] = e;
    }

    /**
     * @param e 元素
     * @return 判断数组中是否包含一个元素
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    /**
     * @param e 要查找的元素
     * @return 查找元素所在的索引 如果不存在元素e 则返回-1 表示不存在元素
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    /**
     * @param index 下标
     * @return 删除元素并返回这个元素
     */
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("index < 0 or index > size");
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if (size == data.length / 2)
            resize(data.length / 2);
        return ret;
    }

    /**
     * @return 删除第一个元素
     */
    public E removeFrist() {
        return remove(0);
    }

    /**
     * @return 删除最后一个元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * @param e 删除元素e
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * @param newCapacity 数组扩容
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }

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
