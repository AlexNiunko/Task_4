package com.epam.task_text.composite;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent{
    private List<TextComponent> elements=new ArrayList<>();
    private ElementName elementsName;

    public TextComposite(ElementName elementsName) {
        this.elementsName = elementsName;
    }

    public TextComposite() {

    }
    public List<TextComponent>getAllComponentsByType(ElementName element){
        List<TextComponent>result=new ArrayList<>();
        for (TextComponent component:elements) {
            if (component.getName().equals(element)){
                result.add(component);
            }
        }
        return result;
    }

    @Override
    public String value() {
        String res="";
        List<TextComponent>elements=getElements();
        for (TextComponent component:elements) {
            if (component.getName().equals(ElementName.PARAGRAPH)){
                res+="\n";
            }
            res+=component.value();
        }
        return res;
    }

    public List<TextComponent> getElements() {
        return elements;
    }

    @Override
    public ElementName getName() {
        return elementsName;
    }

    public boolean add(TextComponent textComponent) {
        return elements.add(textComponent);
    }

    @Override
    public String toString() {
     String str="";
        for (TextComponent element:this.elements) {
            str+=element.toString();
        }
        return  str;
    }
}
