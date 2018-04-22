package com.alayam.algo;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {

    public List<Object> queue = new LinkedList();
    private int  limit = 10;

    public BlockingQueue(int limit){
        this.limit = limit;
    }


    public synchronized void enqueue(Object item)
            throws InterruptedException  {
        while(this.queue.size() == this.limit) {
            wait();
        }
        if(this.queue.size() == 0) {
            notifyAll();
        }
        System.out.println("add:"+item);
        this.queue.add(item);
    }


    public synchronized Object dequeue()
            throws InterruptedException{
        while(this.queue.size() == 0){
            wait();
        }
        if(this.queue.size() == this.limit){
            notifyAll();
        }
        System.out.println("remove:"+queue.get(0));
        return this.queue.remove(0);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting");
        BlockingQueue blockingQueue = new BlockingQueue(5);

        Runnable producer = () ->{
           System.out.println(Thread.currentThread().getName());
           for(int i= 0; i<100; i++) {
               try {
                   blockingQueue.enqueue("Item " + i);
//                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       };

        Runnable cosumer = () ->{
            System.out.println(Thread.currentThread().getName());
            for(int i =0; i< 100; i++) {
                try {
                    blockingQueue.dequeue();
//                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };

        Thread t1 = new Thread(cosumer);
        Thread t2 = new Thread(producer);
        t1.start();
        t2.start();

        Thread t3 = new Thread(cosumer);
        Thread t4 = new Thread(producer);
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("End:"+ blockingQueue.queue.size());

    }
}