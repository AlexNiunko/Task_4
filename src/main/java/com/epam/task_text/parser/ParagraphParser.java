package com.epam.task_text.parser;

import com.epam.task_text.composite.ElementName;
import com.epam.task_text.composite.TextComposite;
import com.epam.task_text.composite.TextElement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser {
    static final String SENTENCE_REGEX="\\w.+?[\\.\\?\\!]";
    private AbstractParser nextSuccessor=new SentenceParser();

    @Override
    public TextComposite parse(String input) {
        TextComposite sentences=new TextComposite(ElementName.PARAGRAPH);
        List<String>rezult=new ArrayList<>();
        Pattern pattern=Pattern.compile(SENTENCE_REGEX);
        Matcher matcher=pattern.matcher(input);
        while (matcher.find()){
            rezult.add(matcher.group());
        }
        for (String currentString:rezult) {
            TextElement element=new TextElement(currentString,ElementName.SENTENCE);
            sentences.add(element);
            sentences.add(nextSuccessor.parse(currentString));
        }
        return sentences;
    }
}
