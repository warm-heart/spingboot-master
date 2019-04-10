package StackAndQueue;

/**
 * @author wangqianlong
 * @create 2019-04-08 19:31
 * <p>
 * 基于动态数组实现的队列
 */

public interface Queue<E> {
    /**
     * @return 获取队列大小
     */
    int getSize();

    /**
     * @return 判断队列是否为空
     */
    boolean isEmpty();

    /**
     * @param e 入队操作
     */
    void enqueue(E e);

    /**
     * @return 出队操作
     */
    E dequeue();

    /**
     * @return 获取队首元素
     */
    E getFront();


}
