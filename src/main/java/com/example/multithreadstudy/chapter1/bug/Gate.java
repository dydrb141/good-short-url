package com.example.multithreadstudy.chapter1.bug;

/**
 * @author YongKyu, Han
 */
public class Gate {
	private int counter  = 0;
	 String name = "Nobody";
	private String address = "Nowhere";

	public synchronized void pass(String name, String address) {
		this.counter++;
		this.name = name;
		this.address = address;
		check();
	}

	private void check() {
		if (name.charAt(0) != address.charAt(0)) {
			System.out.println("****BROKEN****" + toString());
		}
	}

	@Override
	public synchronized String toString() {
		return "Gate{" +
			"counter=" + counter +
			", name='" + name + '\'' +
			", address='" + address + '\'' +
			'}';
	}

}
