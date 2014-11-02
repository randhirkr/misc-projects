package com.foundation4u;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolService {

		private void process() {
			ExecutorService executorService = Executors.newFixedThreadPool(5);
			// starting 10 threads for executing task - it runs asynchronously
			for(int i=0; i<10; i++){
				executorService.execute(new Task());
			}
			
			executorService.shutdown();
			//System.out.println("tasks completed-----");
		}
		
		public static void main(String[] args) {
			try{
				new ThreadPoolService().process();
			}catch(Exception e){
				System.out.println("error in processing: "+e);
			}
		}
}
