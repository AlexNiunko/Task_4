package com.epam.task_text.parser;

import com.epam.task_text.composite.ElementName;
import com.epam.task_text.composite.TextComposite;
import com.epam.task_text.composite.TextElement;

public class LexemaParser extends AbstractParser {

    private TextComposite symbols;

    public LexemaParser(String str) {
        TextComposite chars = new TextComposite(ElementName.LEXEMA);
        char[] symbols = str.toCharArray();
        for (char current : symbols) {
            TextElement element = new TextElement(String.valueOf(current), ElementName.SYMBOL);
            chars.add(element);
        }
        this.symbols = chars;
    }

    public LexemaParser() {

    }

    public TextComposite getSymbols() {
        return symbols;
    }

    @Override
    public TextComposite parse(String str) {
        TextComposite chars = new TextComposite(ElementName.LEXEMA);
        char[] symbols = str.toCharArray();
        for (char current : symbols) {
            TextElement element = new TextElement(String.valueOf(current), ElementName.SYMBOL);
            chars.add(element);
        }
        return chars;
    }
}
