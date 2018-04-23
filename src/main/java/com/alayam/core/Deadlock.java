package com.alayam.core;

public class Deadlock 
{
     static class Friend 
    {
        private final String name;
        public Friend(String name) 
        {
            this.name = name;
        }
        
        public String getName() 
        {
            return this.name;
        }
        
        public synchronized void bow(Friend bower) 
        {
            System.out.format("%s: %s"
                + "  has bowed to me!%n", 
                this.name, bower.getName());
            bower.bowBack(this);
        }
        
        public synchronized void bowBack(Friend bower) 
        {
            System.out.format("%s: %s"
                + " has bowed back to me!%n",
                this.name, bower.getName());
        }
    }

     public void foo(Friend t){
    	 test(t);
     }
     
    public void test(Friend t1){
    	System.out.println("hello");
    }
    
    public static void main(String[] args) 
    {
        final Friend alphonse =
            new Friend("Alphonse");
        final Friend gaston =
            new Friend("Gaston");
        
        alphonse.getName();
        alphonse.bow(gaston);
        
        Deadlock d  = new Deadlock();
        d.test(gaston);
        
//        LinkList d1 = new LinkList();
//        Thread t = new Thread(d1);
//        t.start();
        
        Thread t1 = new Thread(
        		new Runnable() 
        {
            public void run() { alphonse.bow(gaston); }
        }
        		);
        t1.start();
        
        new Thread(new Runnable() {
            public void run() { gaston.bow(alphonse); }
        }).start();
        
    }
}