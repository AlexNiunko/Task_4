package com.epam.task_text.parser;

import com.epam.task_text.composite.ElementName;
import com.epam.task_text.composite.TextComposite;
import com.epam.task_text.composite.TextElement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser {
    static final String LEXEMA_REGEX = "\\w+.";
    private AbstractParser nextSuccessor = new LexemaParser();
    private TextComposite lexemas;

    public SentenceParser(String input) {
        TextComposite lexemas = new TextComposite(ElementName.PARAGRAPH);
        List<String> rezult = new ArrayList<>();
        Pattern pattern = Pattern.compile(LEXEMA_REGEX);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            rezult.add(matcher.group());
        }
        for (String current : rezult) {
            TextElement element = new TextElement(current, ElementName.LEXEMA);
            lexemas.add(element);
        }
        this.lexemas = lexemas;
    }

    public SentenceParser() {

    }

    public TextComposite getLexemas() {
        return lexemas;
    }

    @Override
    public TextComposite parse(String input) {
        TextComposite lexema = new TextComposite(ElementName.SENTENCE);
        Pattern pattern = Pattern.compile(LEXEMA_REGEX);
        Matcher matcher = pattern.matcher(input);
        List<String> result = new ArrayList<>();
        while (matcher.find()) {
            result.add(matcher.group());
        }
        for (String current : result) {
            lexema.add(nextSuccessor.parse(current));
        }
        return lexema;
    }

}
