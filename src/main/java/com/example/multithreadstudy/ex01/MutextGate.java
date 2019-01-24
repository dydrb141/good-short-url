package com.example.multithreadstudy.ex01;

public class MutextGate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";
    /*private final Mutex mutex = new Mutex();

    public void pass(String name, String address) {
        mutex.lock();

        try {
            this.counter++;
            this.name = name;
            this.address = address;
            check();
        } finally {
            mutex.unlock();
        }
    }

    public String toString() {
        String s = null;
        mutex.lock();

        try {
            s = "NO." + counter + ": " + name + ", " + address;
        } finally {
            mutex.unlock();
        }

        return s;
    }*/

    private void check() {
        if (name.codePointAt(0) != address.charAt(0)) {
            System.out.printf("***Brockn ***" + toString());
        }
    }
}
