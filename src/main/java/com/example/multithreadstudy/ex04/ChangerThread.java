package com.example.multithreadstudy.ex04;

import java.io.IOException;
import java.util.Random;

/**
 * 데이터의 내용을 변경 저장하는 클래스
 */
public class ChangerThread extends Thread {
    private final Data data;
    private final Random random = new Random();

    public ChangerThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    public void run() {
        try {
            for (int i = 0; true ; i++) {
                data.change("No." + i);
                Thread.sleep(random.nextInt(1000));
                data.save();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
