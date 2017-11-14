package com.company;
import java.io.*;
import java.util.*;
import static java.lang.System.*;


public class Main {

    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner in = new Scanner(new FileReader("D:\\Java Projects\\IO-NotAssesed-Java\\data.txt"));
        //Scanner in2 = new Scanner(new FileReader("D:\\Java Projects\\IO-NotAssesed-Java\\data.txt"));
        PrintWriter outFile = new PrintWriter("D:\\Java Projects\\IO-NotAssesed-Java\\dictionary.txt");

        String inputText = "";
        ArrayList<String> finalWords = new ArrayList<String>();

        //print whole contents of a file to an input string
        while (in.hasNextLine())
        {
            inputText += in.nextLine();
        }

        //use regex to split inputString into words (for now only 'whole words')
        String [] words = inputText.split("\\W+");

        //take out actual words, add them to the arrayList "finalWords"
        for (String word: words)
        {
            //check if each string doesn't contain a digit or a special character
            if (!word.matches(".*\\d.*") && !word.matches("[^A-za-z]"))
            {
                finalWords.add(word.toLowerCase());
            }
        }

        //sorting finalWords alphabetically
        Collections.sort(finalWords);

        int counter = 1;
        //print out the final words and their count
        for (int i = 0; i < finalWords.size(); i++)
        {
            //since it's sorted can check for duplicates and only print unique words
            if ((i+1) < finalWords.size() && !finalWords.get(i).equals(finalWords.get(i+1)))
            {
                outFile.println(finalWords.get(i) + Gaps(finalWords.get(i)) + counter);
                //some method that decides amount of gaps to print instead of single  " ";
                counter = 1;
            }
            else
            {
                //increment counter if a word is a duplicate of previous one
                counter += 1;
            }
        }
        outFile.close();
    }

    //method that will calculate amount of gaps to print between word and counter
    public static String Gaps(String word)
    {
        final int MAX_SIZE = 20;
        String spaces= "";
        int difference = word.length() - MAX_SIZE;
        while(difference < MAX_SIZE)
        {
            spaces += " ";
            difference += 1;
        }
        return spaces;
    }
}
