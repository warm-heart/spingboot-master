package StackAndQueue;

/**
 * @author wangqianlong
 * @create 2019-04-08 17:53
 * <p>
 * 基于静态数组实现的栈
 */

public interface Stack<E> {

    /**
     * @return 获取当前栈大小
     */
    int getSize();

    /**
     * @return 判断栈是否为空
     */
    boolean isEmpty();

    /**
     * @param e 入栈操作
     */
    void push(E e);

    /**
     * @return 出栈操作
     */
    E pop();

    /**
     * @return 查看栈顶元素
     */
    E peek();
}
