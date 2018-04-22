package com.alayam.algo;

import java.util.LinkedList;

public class BlockingQueue1 {
    LinkedList<Object> list = new LinkedList();
    int size;

    BlockingQueue1(int size){
        this.size = size;
    }

    public static void main(String[] args) {
        BlockingQueue1 queue1 = new BlockingQueue1(5);

    }


    public void produce(Object o) throws InterruptedException {
        synchronized (list){
            while(list.size() == size){
                wait();
            }
            if(list.size() == 0) notifyAll();

            list.add(o);
        }
    }

    public void consume() throws InterruptedException {
        synchronized (list){
            while(list.size() == 0){
                wait();
            }
            if(list.size() == size) notifyAll();
            list.remove();
        }
    }
}

