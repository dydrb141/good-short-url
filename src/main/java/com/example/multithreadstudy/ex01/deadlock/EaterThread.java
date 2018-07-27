package com.example.multithreadstudy.ex01.deadlock;

/**
 * @author YongKyu, Han
 */
public class EaterThread extends Thread {
	private String name;
	private final Tool leafhand;
	private final Tool righthand;

	public EaterThread(String name, Tool leafhand, Tool righthand) {
		this.name = name;
		this.leafhand = leafhand;
		this.righthand = righthand;
	}

	public void run() {
		while (true) {
			eat();
		}
	}

	public void eat() {
		int lefthandHash = System.identityHashCode(leafhand);
		int rihgtHash = System.identityHashCode(righthand);

		if (lefthandHash < rihgtHash) {
			synchronized (leafhand) {
				System.out.println(name + "takes up" + leafhand + " (left).");

				synchronized (righthand) {
					System.out.println(name + "takes up" + righthand + "(rihgt).");
					System.out.println(name + " is eating now, yum yum");
					System.out.println(name + "puts down" + righthand + "rirhgt");
				}

				System.out.println(name + " puts down" + leafhand + "(left)");
			}
		} else if (lefthandHash > rihgtHash) {
			synchronized (righthand) {
				System.out.println(name + "takes up" + righthand + " (right).");

				synchronized (leafhand) {
					System.out.println(name + "takes up" + leafhand + "(left).");
					System.out.println(name + " is eating now, yum yum");
					System.out.println(name + "puts down" + leafhand + "left");
				}

				System.out.println(name + " puts down" + righthand + "(right)");
			}
		}


	}
}
