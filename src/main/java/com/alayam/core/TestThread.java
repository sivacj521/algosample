package com.alayam.core;

public class TestThread implements Runnable {

	static {
		TestThread t1=new TestThread();
		Thread t=new Thread(t1);
		t.start();
	}



	@ Override	
	public void run()
	{
		System.out.println("In run");
	}


	//TestThread t1=new TestThread();
	public static void main(String args[]){
		/*TestThread t1=new TestThread();
	Thread TestGene=new Thread(t1);
	TestGene.start();*/


		//TestGene.start();
		
		TestThread t1 = new TestThread();
		
	}


}

