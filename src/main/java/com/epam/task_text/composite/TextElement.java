package com.epam.task_text.composite;

public class TextElement implements TextComponent{
    private String element;
    private ElementName elementName;

    public TextElement(String element, ElementName elementName) {
        this.element = element;
        this.elementName = elementName;
    }

    public String getElement() {
        return element;
    }

    @Override
    public ElementName getName() {
        return elementName;
    }

    @Override
    public String value() {
        return this.element;
    }

    @Override
    public String toString() {
        return "TextElement{" +
                "element='" + element + '\'' +
                ", elementName=" + elementName +
                '}'+"\n";
    }
}
