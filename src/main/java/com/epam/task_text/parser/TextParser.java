package com.epam.task_text.parser;

import com.epam.task_text.composite.ElementName;
import com.epam.task_text.composite.TextComposite;
import com.epam.task_text.composite.TextElement;

public class TextParser extends AbstractParser {
    static final String PARAGRAPH_REGEX="\\n";
    private AbstractParser nextSuccessor=new ParagraphParser();

    @Override
    public TextComposite parse(String input) {
        TextComposite text=new TextComposite(ElementName.TEXT);
        String [] result=input.split(PARAGRAPH_REGEX);
        for (String currentString:result) {
            TextElement element=new TextElement(currentString,ElementName.PARAGRAPH);
            text.add(element);
            text.add(nextSuccessor.parse(currentString));
        }
        return text;
    }
}
