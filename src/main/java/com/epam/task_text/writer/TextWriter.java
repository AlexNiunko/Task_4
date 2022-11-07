package com.epam.task_text.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TextWriter {
    public void writerToFile(String current){
        try (BufferedWriter writer=new BufferedWriter(new FileWriter("data\\info.txt"))) {
            writer.write(current);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
