package StackAndQueue;


import Array.Array;

/**
 * @author wangqianlong
 * @create 2019-04-08 17:57
 */

public class ArrayStack<E> implements Stack {
    Array<E> array;

    public ArrayStack(int capacity) {
        array = (Array<E>) new Array<>(capacity);
    }

    public ArrayStack() {
        array = (Array<E>) new Array<>();
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
    public void push(Object o) {
        array.addLast((E) o);
    }

    @Override
    public Object pop() {
        return array.removeLast();
    }

    @Override
    public Object peek() {
        return array.getLast();
    }

    /**
     * @return 查看栈的容积
     */
    public int getCapacity() {
        return array.getCapacity();

    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("stack: ");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1)
                res.append(" ,");
        }
        res.append("] top");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack =new ArrayStack<>();
        for (int i = 0; i <5 ; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }

        arrayStack.pop();
        System.out.println(arrayStack);
    }
}
