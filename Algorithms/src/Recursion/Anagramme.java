/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author M.Aljazwiee
 */
public class Anagramme {
    private static int size;
    private static int count;
    private static char[]angramChars;
    private static void doAnagramme(int newSize)
    {
        if(newSize==1)
            return;
        for(int j=0;j<newSize;j++)
        {
            doAnagramme(newSize-1);
        //    if(newSize==2)
                displayWoords();
            rotate(newSize);
        }
    }
    private static void rotate(int newSize)
    {
        int j=0;
        int posation=size-newSize;
        char temp=angramChars[posation];
        for(j=posation+1;j<size;j++)
            angramChars[j-1]=angramChars[j];
        angramChars[j-1]=temp;
    }
    private static void displayWoords()
    {
        System.out.print(++count+" ");
        for(int i=0;i<size;i++)
            System.out.print(angramChars[i]);
        System.out.print("  ");
    }
    public static void main(String[] args) throws IOException {
        String anagrammeWord=getString();
        size=anagrammeWord.length();
        count=0;
        angramChars=new char[size];
        for(int i=0;i<anagrammeWord.length();i++)
            angramChars[i]=anagrammeWord.charAt(i);
        doAnagramme(size);
    }
    private static String getString() throws IOException
    {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader reader=new BufferedReader(isr);
        System.out.println("Please Enter Your Word That You Want To Get It's Angramme ");
        return reader.readLine();
    }
}
