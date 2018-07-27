package com.example.multithreadstudy.ex01.deadlock;

/**
 * @author YongKyu, Han
 */
public class Tool {
	private final String name;

	public Tool(String name) {
		this.name = name;
	}

	public String toString() {
		return "[" +  name + "]";
	}
}
