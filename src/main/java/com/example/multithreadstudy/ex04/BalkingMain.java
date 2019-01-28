package com.example.multithreadstudy.ex04;

public class BalkingMain {
    public static void main(String[] args) {
        Data data = new Data("data.txt", "(empty)");
        new ChangerThread("ChangeTGrehad", data).start();
        new SaverThread("SaverThread", data);
    }
}
