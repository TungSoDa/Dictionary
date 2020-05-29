package tudien;

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
    
    
    public static class DictionaryManagement
    {
        Scanner in = new Scanner(System.in);
        ArrayList<Word> wordFromFile = new ArrayList<Word>();
        public void insertFromFile()
        {
            try 
            {
                String str;
                File fileWord = new File("dictionary.txt");
                BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(fileWord), "UTF8"));
                while((str = input.readLine()) != null )
                {
                    String[] splitedWord  = str.split("\t");
                    Word newWord = new Word(splitedWord[0], splitedWord[1]);
                    wordFromFile.add(newWord);
                }
            } catch (UnsupportedEncodingException e) {System.out.println(e.getMessage());} 
              catch (IOException e) {System.out.println(e.getMessage());}
              catch (Exception e) {System.out.println(e.getMessage());} 
        }
        public void dictionaryLookup()
        {
            System.out.print("Translate: ");
            String EnglishWord = in.nextLine();
            for(int i=0 ; i<wordFromFile.size() ; i++)
            {
                if(wordFromFile.get(i).word_target.equalsIgnoreCase(EnglishWord))
                {
                    System.out.println(wordFromFile.get(i).getWord_explain());
                }
            }
        }
        public void dictionarySearcher()
        {
            System.out.print("Search: ");
            String str = in.nextLine();
            for(int i=0 ; i<wordFromFile.size() ; i++)
            {
                if(wordFromFile.get(i).getWord_target().startsWith(str))
                {
                    System.out.println(wordFromFile.get(i).getWord_target());
                }
            }
        }
        public void  dictionaryExportToFile(ArrayList<Word> wordFromFile)
        {
            try 
            {
                BufferedWriter output = new BufferedWriter(new FileWriter("dictionary.txt"));
                for(Word str:wordFromFile)
                {
                    output.write(str.word_target);
                    output.newLine();
                }
                output.close();
            } 
            catch (Exception e) 
            {
                e.getStackTrace();
            }
        }
        public void addWord()
        {
            try 
            {
                String Eng = null, Vie = null;
                File fileWord = new File("dictionary.txt");
                BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileWord,true), "UTF8"));
                System.out.print("Enter English word: ");
                Eng = in.nextLine();
                for(int i=0 ; i<wordFromFile.size() ; i++)
                {
                    if(wordFromFile.get(i).word_target.equalsIgnoreCase(Eng))
                    {
                        System.out.println("word you search for was available in the dictionary data!!!");
                        Eng = null;
                    }
                }
                if(Eng != null)
                {
                    System.out.print("Enter Vietnamese meaning: ");
                    Vie = in.nextLine();
                }
                output.newLine();
                output.write(Eng+"\t"+Vie);
                output.close();
            } catch (UnsupportedEncodingException e) {System.out.println(e.getMessage());} 
              catch (IOException e) {System.out.println(e.getMessage());} 
            
        }
        public void deleteWord()
        {
            System.out.print("Word you need to delete: ");
            String EnglishWord = in.nextLine();
            for(int i=0 ; i<wordFromFile.size() ; i++)
            {
                if(wordFromFile.get(i).word_target.equalsIgnoreCase(EnglishWord))
                {
                    wordFromFile.remove(i);
                    dictionaryExportToFile(wordFromFile);
                }                
            }
        }
        
        public void fixWord()
        {
            try 
            {
                File fileWord = new File("dictionary.txt");
                BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileWord), "UTF8"));
                System.out.print("Word you need to fix: ");
                String EnglishWord = in.nextLine();
                for(int i=0 ; i<wordFromFile.size() ; i++)
                {
                    if(wordFromFile.get(i).word_target.equalsIgnoreCase(EnglishWord))
                    {
                        System.out.println("Old meaing: "+wordFromFile.get(i).getWord_explain()); 
                        System.out.println("New meaning: ");
                        String newMeaing = in.nextLine();
                        
                    }
                }
                output.close();
            } catch (UnsupportedEncodingException e) {System.out.println(e.getMessage());} 
              catch (IOException e) {System.out.println(e.getMessage());} 
        }
    }
    public static class DictionaryCommandLine
    {
        DictionaryManagement dm = new DictionaryManagement();
        public DictionaryCommandLine(DictionaryManagement dm) 
        {
            this.dm = dm;
        }
        Scanner in = new Scanner(System.in);
        public void dictionaryAdvanced()
        {
            System.out.println("***My Dictionary***");
            System.out.println("1.Search: ");
            System.out.println("2.Translate: ");
            System.out.println("3.Add new word to my dictionary: ");
            System.out.println("4.Delete word: ");
            System.out.println("5.Edit dictionary word: ");
            System.out.println("6.Exit.");
            while(true)
            {
                System.out.print("OPTION: ");
                int option = in.nextInt();
                switch(option)
                {
                    case 1: dm.dictionarySearcher();
                            break;
                    case 2: dm.dictionaryLookup();
                            break;
                    case 3: dm.addWord();
                            break;
                    case 4: dm.deleteWord();
                            break;
                    case 5: dm.fixWord();
                            break;
                    case 6: System.exit(0);
                            break;
                }
            }
        }
    }
    public static void main(String[] args) 
    {
        DictionaryManagement DM = new DictionaryManagement();
        DM.insertFromFile();
        DictionaryCommandLine DC = new DictionaryCommandLine(DM);
        DC.dictionaryAdvanced();
    }
}
