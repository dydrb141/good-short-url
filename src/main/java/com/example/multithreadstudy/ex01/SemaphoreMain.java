package com.example.multithreadstudy.ex01;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @author YongKyu, Han
 */
public class SemaphoreMain {

	public static void main(String[] args) {
		BoundedResource resource = new BoundedResource(3);

		for (int i = 0; i < 10; i++) {
			new UserThread(resource).start();
		}
	}
}

class Log {
	public static void printlnl(String s) {
		System.out.println(Thread.currentThread().getName() + ": " + s);
	}
}

class BoundedResource {
	private final Semaphore semaphore;
	private final int permits;
	private final static Random random = new Random(314159);

	public BoundedResource(int permits) {
		this.semaphore = new Semaphore(permits);
		this.permits = permits;
	}

	public void use() throws InterruptedException {
		semaphore.acquire();

		try {
			doUse();
		} finally {
			semaphore.release();
		}
	}

	protected void doUse() throws InterruptedException {
		Log.printlnl("BEGIN : use = " + (permits - semaphore.availablePermits()));
		Thread.sleep(random.nextInt(500));
		Log.printlnl("END : used" + (permits - semaphore.availablePermits()));
	}
}

class UserThread extends Thread {
	private final static Random random = new Random(26535);
	private final BoundedResource resource;

	public UserThread(BoundedResource resource) {
		this.resource = resource;
	}

	public void run() {
		try {
			while (true) {
				resource.use();
				Thread.sleep(random.nextInt(3000));
			}
		} catch (InterruptedException e) {

		}
	}

}
