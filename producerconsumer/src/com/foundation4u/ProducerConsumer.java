package com.foundation4u;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
	private Producer producer;
	private Consumer consumer;
	
	
	public static void main(String[] args) {
		try{
			new ProducerConsumer().process();
		}catch(Exception e){
			System.out.println("error occurred in processing the queue: "+e);
		}
		
	}


	private void process() {
		
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(20);
		
		producer = new Producer(queue);
		consumer = new Consumer(queue);
		
		Thread producerThread = new Thread(producer,"producerThread");
		Thread consumerThread = new Thread(consumer,"ConsumerThread");
		producerThread.start();
		consumerThread.start();
	}
}
