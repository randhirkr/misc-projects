package com.foundation4u;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
	protected BlockingQueue<String> queue = null;
	
	public Producer(BlockingQueue<String> queue){
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			System.out.println("data 1 inserted by-"+Thread.currentThread().getName());
			queue.put("1");
			
			System.out.println("data 2 inserted by--"+Thread.currentThread().getName());
			queue.put("2");
			
			System.out.println("data 3 inserted by--"+Thread.currentThread().getName());
			queue.put("3");
			
			System.out.println("data 4 inserted by--"+Thread.currentThread().getName());
			queue.put("4");
			
			System.out.println("data 5 inserted by--"+Thread.currentThread().getName());
			queue.put("5");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
