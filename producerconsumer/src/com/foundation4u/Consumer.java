package com.foundation4u;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

	protected BlockingQueue<String> queue = null; 
	public Consumer(BlockingQueue<String> queue){
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try {
			
			System.out.println("data 1 read by--"+Thread.currentThread().getName()+": "+queue.take());
			
			System.out.println("data 2 read by--"+Thread.currentThread().getName()+": "+queue.take());

			System.out.println("data 3 read by--"+Thread.currentThread().getName()+": "+queue.take());
			
			System.out.println("data 4 read by--"+Thread.currentThread().getName()+": "+queue.take());
			
			System.out.println("data 5 read by--"+Thread.currentThread().getName()+": "+queue.take());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
