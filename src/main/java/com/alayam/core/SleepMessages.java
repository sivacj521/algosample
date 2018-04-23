package com.alayam.core;

public class SleepMessages implements Runnable {
	static String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
        };
	
	void foo(){
		for (int i = 0;
	             i < importantInfo.length;
	             i++) {
	            //Pause for 4 seconds
	            try {
					Thread.sleep(1000);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            //Print a message
	            System.out.println("Thread: "+Thread.currentThread().getName()+":"+importantInfo[i]);
	        }
	}
	
    public static void main(String args[])
        throws InterruptedException {
    	SleepMessages s = new SleepMessages();
        s.foo();
        
        Thread t1 = new Thread(new SleepMessages(), "jaya");
        t1.start();
        
        Thread t2 = new Thread(new SleepMessages(), "jaya1");
        t2.start();
        

//        for (int i = 0;
//             i < importantInfo.length;
//             i++) {
//            //Pause for 4 seconds
//            Thread.sleep(4000);
//            //Print a message
//            System.out.println(importantInfo[i]);
//        }
        
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		foo();
		//t2.join
		
	}
}