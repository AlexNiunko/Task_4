package com.epam.task_text.parser;

import com.epam.task_text.composite.TextComposite;
import com.epam.task_text.composite.TextElement;

public abstract class AbstractParser {
    public abstract TextComposite parse(String str);
}
