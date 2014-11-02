package com.foundation4u;


public class Task implements Runnable{

	@Override
	public void run() {
		printNumber();
		//System.out.println();
		//System.out.println(Thread.currentThread().getName());
	}

	private void printNumber(){
		System.out.println(Thread.currentThread().getName());
		System.out.println("-------------------------");
		for(int i=1; i<11; i++){
			System.out.print(i+" ");
		}
	}
}
