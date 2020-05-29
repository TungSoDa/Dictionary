package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement
{
    Scanner in = new Scanner(System.in);
    ArrayList<MyDictionary.Word> wordFromFile = new ArrayList<MyDictionary.Word>();
    public void insertFromFile()
    {
        try
        {
            String str;
            File fileWord = new File("E_V.txt");
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(fileWord), "UTF8"));
            while((str = input.readLine()) != null )
            {
                String[] splitedWord  = str.split("<html>");
                MyDictionary.Word newWord = new MyDictionary.Word(splitedWord[0], splitedWord[1]);
                wordFromFile.add(newWord);
            }
        } catch (UnsupportedEncodingException e) {System.out.println(e.getMessage());}
        catch (IOException e) {System.out.println(e.getMessage());}
        catch (Exception e) {System.out.println(e.getMessage());}
    }

    public String dictionaryLookup(String str)
    {
        for(int i=0 ; i<wordFromFile.size() ; i++)
        {
            if(wordFromFile.get(i).word_target.equalsIgnoreCase(str))
            {
                //System.out.println(wordFromFile.get(i).getWord_explain());
                return wordFromFile.get(i).word_explain;
            }
        }
        return null;
    }

    public ArrayList<String> dictionarySearcher(String str)
    {
        ArrayList<String> word_ = new ArrayList<>();
        for(int i=0 ; i<wordFromFile.size() ; i++)
        {
            if(wordFromFile.get(i).getWord_target().startsWith(str))
            {
                //System.out.println(wordFromFile.get(i).getWord_target());
                word_.add(wordFromFile.get(i).getWord_target());
            }
        }
        return word_;
    }

    public void  dictionaryExportToFile(ArrayList<MyDictionary.Word> wordFromFile)
    {
        try
        {
            BufferedWriter output = new BufferedWriter(new FileWriter("dictionary.txt"));
            for(MyDictionary.Word str:wordFromFile)
            {
                output.write(str.word_explain);
                output.newLine();
            }
        }
        catch (Exception e)
        {
            e.getStackTrace();
        }
    }

    public String addWord(String Eng, String Vie)
    {
        try
        {
            File fileWord = new File("E_V.txt");
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileWord,true), "UTF8"));
            for(int i=0 ; i<wordFromFile.size() ; i++)
            {
                if(wordFromFile.get(i).word_target.equalsIgnoreCase(Eng))
                {
                    Eng = null;
                }
            }
            output.write(Eng+"<html>"+Vie);
            output.close();
        } catch (UnsupportedEncodingException e) {System.out.println(e.getMessage());}
          catch (IOException e) {System.out.println(e.getMessage());}

         return Eng;
    }

    public String deleteWord(String EnglishWord)
    {
        for(int i=0 ; i<wordFromFile.size() ; i++)
        {
            if(wordFromFile.get(i).word_target.equalsIgnoreCase(EnglishWord))
            {
                wordFromFile.remove(wordFromFile.get(i).word_explain);
                dictionaryExportToFile(wordFromFile);
            }
        }
        return EnglishWord;
    }

    public void fixWord(String EnglishWord, String newMeaing)
    {
        try
        {
            File fileWord = new File("dictionary.txt");
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileWord), "UTF8"));
            for(int i=0 ; i<wordFromFile.size() ; i++)
            {
                if(wordFromFile.get(i).word_target.equalsIgnoreCase(EnglishWord))
                {
                    break;
                }
            }
            output.close();
        } catch (UnsupportedEncodingException e) {System.out.println(e.getMessage());}
        catch (IOException e) {System.out.println(e.getMessage());}
    }
}
