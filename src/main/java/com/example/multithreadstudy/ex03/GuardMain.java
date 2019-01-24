package com.example.multithreadstudy.ex03;

public class GuardMain {
	public static void main(String[] args) {
		 RequestQueue requestQueue = new RequestQueue();
		 new ClientThread(requestQueue, "Alice", 3142592l).start();
		 new ServerThread(requestQueue, "Bobby", 6535897l).start();

		new ClientThread(requestQueue, "Alice2", 3142592l).start();
		new ServerThread(requestQueue, "Bobby2", 6535897l).start();
	}
}
