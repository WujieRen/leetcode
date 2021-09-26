package com.ltc.rwj.queue;

/**
 * @author rwj
 * @create_time 2021/7/31
 * @description 队列（queue） 和 栈（stack）一样，也是操作的数据结构。
 *                  队列：先进先出
 */
public class Test {
    public static void main(String[] args) {

        //TODO: 数组实现的队列测试
        /*ArrayQueue arrayQueue = new ArrayQueue(5);
        System.out.println(arrayQueue.enqueue("a"));
        System.out.println(arrayQueue.enqueue("b"));
        System.out.println(arrayQueue.enqueue("c"));
        System.out.println(arrayQueue.enqueue("d"));
        System.out.println(arrayQueue.enqueue("e"));
        System.out.println(arrayQueue.enqueue("f"));
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.enqueue("g"));
        System.out.println(arrayQueue.enqueue("h"));
        System.out.println(arrayQueue.enqueue("i"));
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());*/

        //TODO：双向链表实现的队列测试
        /*DoublyLinkedQueue listQueue = new DoublyLinkedQueue(5);
        System.out.println(listQueue.enqueue("A"));
        System.out.println(listQueue.enqueue("B"));
        System.out.println(listQueue.enqueue("C"));
        System.out.println(listQueue.enqueue("D"));
        System.out.println(listQueue.enqueue("E"));
        System.out.println(listQueue.enqueue("F"));
        listQueue.iterateStack();
        System.out.println(listQueue.dequeue());
        System.out.println(listQueue.dequeue());
        System.out.println(listQueue.dequeue());
        System.out.println(listQueue.enqueue("G"));
        System.out.println(listQueue.enqueue("H"));
        System.out.println(listQueue.enqueue("I"));
        listQueue.iterateStack();
        System.out.println(listQueue.dequeue());
        System.out.println(listQueue.dequeue());
        System.out.println(listQueue.dequeue());
        System.out.println(listQueue.dequeue());
        System.out.println(listQueue.dequeue());*/


        //TODO: 单向链表实现的队列测试
        /*LinkedQueue linkedQueue = new LinkedQueue(5);
        System.out.println(linkedQueue.enqueue("1"));
        System.out.println(linkedQueue.enqueue("2"));
        System.out.println(linkedQueue.enqueue("3"));
        System.out.println(linkedQueue.enqueue("4"));
        System.out.println(linkedQueue.enqueue("5"));
        System.out.println(linkedQueue.enqueue("6"));
        linkedQueue.iterator();
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.enqueue("7"));
        System.out.println(linkedQueue.enqueue("8"));
        System.out.println(linkedQueue.enqueue("9"));
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.dequeue());*/

        //TODO: 数组实现的循环队列测试
//        CircularQueue circularQueue = new CircularQueue(5);
        /*CircularQueue2 circularQueue = new CircularQueue2(5);
        System.out.println(circularQueue.enqueue("1"));
        System.out.println(circularQueue.enqueue("2"));
        System.out.println(circularQueue.enqueue("3"));*/
//        System.out.println(circularQueue.enqueue("4"));
//        System.out.println(circularQueue.enqueue("5"));
//        System.out.println(circularQueue.enqueue("6"));
        /*circularQueue.iterator();*/
       /* System.out.println(circularQueue.dequeue()+"---");
        System.out.println(circularQueue.dequeue()+"---");
        System.out.println(circularQueue.dequeue()+"---");
        System.out.println(circularQueue.enqueue("7"));
        System.out.println(circularQueue.enqueue("8"));
        System.out.println(circularQueue.dequeue()+"---");
        System.out.println(circularQueue.dequeue()+"---");
        System.out.println(circularQueue.dequeue()+"---");
        System.out.println(circularQueue.dequeue()+"---");
        System.out.println(circularQueue.dequeue()+"---");*/

       //TODO: 链表实现的循环队列测试
        CircularLinkedQueue circularLinkedQueue = new CircularLinkedQueue(5);
        System.out.println(circularLinkedQueue.enqueue("1"));
        System.out.println(circularLinkedQueue.enqueue("2"));
        System.out.println(circularLinkedQueue.enqueue("3"));
        System.out.println(circularLinkedQueue.enqueue("4"));
        System.out.println(circularLinkedQueue.enqueue("5"));
        System.out.println(circularLinkedQueue.enqueue("6"));
        System.out.println("-------------------------------------");
        circularLinkedQueue.iterator();
        System.out.println(circularLinkedQueue.dequeue());
        System.out.println(circularLinkedQueue.dequeue());
        System.out.println(circularLinkedQueue.dequeue());
        System.out.println("-------------------------------------");
        circularLinkedQueue.iterator();
        System.out.println(circularLinkedQueue.enqueue("7"));
        System.out.println(circularLinkedQueue.enqueue("8"));
        System.out.println(circularLinkedQueue.enqueue("9"));
        System.out.println(circularLinkedQueue.enqueue("10"));
        circularLinkedQueue.iterator();
        System.out.println("-------------------------------------");
        System.out.println(circularLinkedQueue.dequeue());
        System.out.println(circularLinkedQueue.dequeue());
        System.out.println(circularLinkedQueue.enqueue("a"));
        System.out.println(circularLinkedQueue.enqueue("b"));
        System.out.println(circularLinkedQueue.enqueue("c"));
        System.out.println(circularLinkedQueue.dequeue());
        System.out.println(circularLinkedQueue.dequeue());
        System.out.println(circularLinkedQueue.dequeue());
        System.out.println(circularLinkedQueue.dequeue());
        System.out.println(circularLinkedQueue.dequeue());
        System.out.println(circularLinkedQueue.dequeue());
        System.out.println(circularLinkedQueue.dequeue());

    }
}
