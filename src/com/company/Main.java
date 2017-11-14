package com.company;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner inFile = new Scanner(new FileReader("D:\\Java Projects\\IO-NotAssesed-Java\\data.txt"));
        PrintWriter outFile = new PrintWriter("D:\\Java Projects\\IO-NotAssesed-Java\\result.txt");


        outFile.close();
    }
}
