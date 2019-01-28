package com.example.multithreadstudy.ex04;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 변경 저장이 가능한 데이터를 나타내는 클래스
 */
public class Data {
    private final String filename;
    private String content;
    private boolean changed;

    public Data(String s, String filename) {
        this.filename = filename;
        this.content = content;
        this.changed = true;
    }

    public synchronized void change(String newContent) {
        content = newContent;
        changed = true;
    }

    public synchronized void save() throws IOException {
        if (!changed) {
            return;
        }

        doSave();
        changed = false;
    }

    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + "class doSave contetn" + content);

        Writer witer = new FileWriter(filename);
        witer.write(content);
        witer.close();
    }


}
