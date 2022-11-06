package com.epam.task_text.reader;

import org.apache.logging.log4j.Level;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextReader {
    public String readFromFile(String pathOrFile) {
        String text="";
        try(BufferedReader reader=new BufferedReader(new FileReader(pathOrFile))){
            String tmp;
            while((tmp=reader.readLine())!=null){
                text+=tmp+"\n";
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return text;
    }
}
