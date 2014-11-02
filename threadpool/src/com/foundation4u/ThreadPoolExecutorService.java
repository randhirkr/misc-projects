package com.foundation4u;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorService {

	private void process() {
		int  corePoolSize  =    5;
		int  maximumPoolSize   =   10;
		long keepAliveTime = 5000;
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(50);
		
		ExecutorService executorService = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 
				keepAliveTime, TimeUnit.MILLISECONDS, workQueue);
		
		// starting 10 threads for executing task - it runs asynchronously
		for(int i=0; i<10; i++){
			executorService.execute(new Task());
		}
		
		executorService.shutdown();
	}

	public static void main(String[] args) {

		try {
			new ThreadPoolExecutorService().process();
		} catch (Exception e) {
			System.out.println("error in processing: " + e);
		}
	}
}
