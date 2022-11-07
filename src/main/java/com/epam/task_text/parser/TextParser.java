package com.epam.task_text.parser;

import com.epam.task_text.composite.ElementName;
import com.epam.task_text.composite.TextComponent;
import com.epam.task_text.composite.TextComposite;
import com.epam.task_text.composite.TextElement;

import java.util.StringJoiner;

public class TextParser extends AbstractParser {
    private TextComposite paragrarhs;
    static final String PARAGRAPH_REGEX = "\\n";
    private AbstractParser nextSuccessor = new ParagraphParser();

    public TextParser(String input) {
        TextComposite text = new TextComposite(ElementName.TEXT);
        String[] result = input.split(PARAGRAPH_REGEX);
        for (String currentString : result) {
            TextElement element = new TextElement(currentString, ElementName.PARAGRAPH);
            text.add(element);
        }
        this.paragrarhs = text;
    }

    @Override
    public TextComposite parse(String input) {
        TextComposite text = new TextComposite(ElementName.TEXT);
        String[] result = input.split(PARAGRAPH_REGEX);
        for (String currentString : result) {
            text.add(nextSuccessor.parse(currentString));
        }
        return text;
    }

    public TextComposite getParagrarhs() {
        return paragrarhs;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TextParser.class.getSimpleName() + "[", "]")
                .add("paragrarhs=" + paragrarhs)
                .add("nextSuccessor=" + nextSuccessor)
                .toString();
    }
}
