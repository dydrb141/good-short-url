package com.example.multithreadstudy.ex01.deadlock;

/**
 * @author YongKyu, Han
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("Testing EaterThread, hit C to exit.");
		Tool spoon = new Tool("Spoon");
		Tool fork =  new Tool("Fork");

		new EaterThread("Alice", spoon, fork).start();
		new EaterThread("Bobby", fork, spoon).start();


	}
}
