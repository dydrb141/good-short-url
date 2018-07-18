package com.example.multithreadstudy.ex01;

/**
 * @author YongKyu, Han
 */
public class MyThread extends Thread {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.print("Nice");
		}
	}

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.run();

		for (int i = 0; i < 1000 ; i++) {
			System.out.print("Good!");
		}
	}
}
