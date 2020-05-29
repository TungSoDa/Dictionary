package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MyDictionary 
{
    public static class Word
    {
         String word_target;
         String word_explain;
         
        public Word(String word_target, String word_explain) 
        {
            this.word_target = word_target;
            this.word_explain = word_explain;
        }
        public Word() {}
        public String getWord_target() {return word_target;}
        public void setWord_target(String word_target) {this.word_target = word_target;}
        public String getWord_explain() {return word_explain;}
        public void setWord_explain(String word_explain) {this.word_explain = word_explain;}
    }

    DictionaryManagement dictionaryManagement = new DictionaryManagement();
    public void file()
    {
        dictionaryManagement.insertFromFile();
    }

    public class DictionaryCommandLine
    {
        DictionaryManagement dm = new DictionaryManagement();
        public DictionaryCommandLine(DictionaryManagement dm) 
        {
            this.dm = dm;
        }
    }
}
