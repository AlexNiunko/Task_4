package com.epam.task_text.main;

import com.epam.task_text.composite.ElementName;
import com.epam.task_text.composite.TextComposite;
import com.epam.task_text.parser.LexemaParser;
import com.epam.task_text.parser.ParagraphParser;
import com.epam.task_text.parser.SentenceParser;
import com.epam.task_text.parser.TextParser;
import com.epam.task_text.reader.TextReader;
import com.epam.task_text.writer.TextWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
     TextReader reader=new TextReader();
     String str=reader.readFromFile("data\\text.txt");
     TextParser parser=new TextParser(str);
     TextComposite composite= parser.parse(str);
     System.out.println(composite.value());

     TextWriter writer=new TextWriter();
     writer.writerToFile(composite.value());



    }
}

