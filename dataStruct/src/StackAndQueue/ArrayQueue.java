package StackAndQueue;


import Array.Array;

/**
 * @author wangqianlong
 * @create 2019-04-08 19:32
 */

public class ArrayQueue<E> implements Queue {
    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array(capacity);
    }

    public ArrayQueue() {
        array = new Array();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(Object o) {
        array.addLast((E) o);
    }

    @Override
    public Object dequeue() {
        return array.removeFrist();
    }

    @Override
    public Object getFront() {
        return array.getFrist();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2)
                queue.dequeue();
            System.out.println(queue);
        }
    }
}
