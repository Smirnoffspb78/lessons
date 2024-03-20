package com.smirnov.project.lesson17.homework17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";


        //Task1
        Collection<String> wordsCollection = new ArrayList<>(Arrays.asList(text.split(" ")));
        System.out.println(HomeWork17.frequencyOfWord(wordsCollection));

        //Task2
        System.out.println(HomeWork17.frequencyOfWord(text, "it"));
        System.out.println(HomeWork17.frequencyOfWord(text, "will"));


        //Task3
        System.out.println(HomeWork17.numberOfLettersInWords(text));

        //Task4
        HomeWork17.topTenWord(text);
    }


}
