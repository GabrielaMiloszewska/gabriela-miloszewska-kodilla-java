package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void beautify(String textToEmbellish, PoemDecorator poemDecorator){
        poemDecorator.decorate(textToEmbellish);
    }
    public static String addText(String textToEmbellish){
        return "ABC" + textToEmbellish + "ABC";
    }
}
