package com.pautib;


import static java.lang.System.out;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        InvertedIndex invertedIndex = new InvertedIndex();
        String docExample1 = "En un país multi-color había una abeja bajo el sol";
        String docExample2 = "la llamamos maya, una abeja maya, la la la";

        invertedIndex.insertDoc(docExample1);
        invertedIndex.insertDoc(docExample2);

        out.println(invertedIndex.search("un"));
        out.println(invertedIndex.orSearch("un", "una"));
        out.println(invertedIndex.andSearch("una", "el"));

        invertedIndex.delete(docExample1);
        out.println(invertedIndex.orSearch("un", "una"));


    }
}