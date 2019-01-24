package com.example.multithreadstudy.ex02;

public class CallTestMain {
	private static final long CALL_COUNT = 1000000000l;

	public static void main(String[] args) {
		trial("NotSynch", CALL_COUNT, new NotSynch());
		trial("Synch", CALL_COUNT, new Synch());
	}

	private static void trial(String msg, long count, Object obj) {
		System.out.println(msg + ": BEGIN");

		long start_time = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			obj.toString();
		}

		System.out.println(msg + ": END");
		System.out.println("Elpased time = " + (System.currentTimeMillis() - start_time) + "ms");
	}
	static class NotSynch {
		private final String name = "NotSynch";

		public  String toString() {
			return "[" + name + "]";
		}
	}

	static class Synch {
		private final String name = "Synch";

		public synchronized String toString() {
			return "[" + name + "]";
		}
	}
}
