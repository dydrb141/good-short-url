package com.example.multithreadstudy.ex02;

public final class Person {
	private final String name;
	private final String address;

	public Person(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String toString() {
		return "psersonName: " + name + ", address:" + address;
	}

}
