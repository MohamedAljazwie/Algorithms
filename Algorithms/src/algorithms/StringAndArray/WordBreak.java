/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.StringAndArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *
 * @author MohamedSayed
 */

/*
 Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code". 
 */
public class WordBreak {
//  *************  wordBreak and wordBreak1 check the wordBreak oin dictonary    *****************************/
    public static boolean wordBreak(String word, Set<String> dictionary) {
        if (word.isEmpty()) {
            return false;
        }
        int length = 0;
        if (!word.isEmpty() && dictionary.isEmpty()) {
            return false;
        }
        StringBuffer buffer = new StringBuffer(word);
        for (String dic : dictionary) {
            if (word.equals(dic)) {
                return true;
            }
            if (buffer.toString().contains(dic)) {

                buffer.delete(buffer.indexOf(dic), buffer.indexOf(dic) + dic.length());
                if (buffer.length() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean wordBreak1(String s, Set<String> wordDict) {
        int[] pos = new int[s.length() + 1];
        Arrays.fill(pos, -1);
        pos[0] = 0;

        for (int i = 0; i < s.length(); i++) {
            if (pos[i] != -1) {
                for (int j = i + 1; j <= s.length(); j++) {
                    String sub = s.substring(i, j);
                    if (wordDict.contains(sub)) {
                        pos[j] = i;
                    }
                }
            }
        }

        return pos[s.length()] != -1;
    }
//  *************  wordBreak2 and wordBreak3 return all pathes of  the wordBreak oin dictonary    *****************************/
    public static List<String> wordBreak2(String word, Set<String> dictionary) {
        boolean emprBuffer = true;
        List<List<String>> wordBreaks = new ArrayList<>();
        while (emprBuffer) {
            emprBuffer = false;
            StringBuffer buffer = new StringBuffer(word);
            List<String> wordBreak = new ArrayList<>();
            for (String dic : dictionary) {
                if (buffer.toString().contains(dic)) {
                    dictionary.remove(dic);
                    buffer.delete(buffer.indexOf(dic), buffer.indexOf(dic) + dic.length());
                    wordBreak.add(dic);

                }
            }
            if (wordBreak.size() != 0) {
                wordBreaks.add(wordBreak);
            }
            if(buffer.length()!=word.length())
                emprBuffer=true;
            if (!emprBuffer) {
                break;
            }
        }
        List<String> allwordBreak=new ArrayList<>();
       for(List<String> wordBraek:wordBreaks)
       {
       for( Object wb: wordBraek.toArray())
           allwordBreak.add((String) wb);
       }
       
        return allwordBreak;
    }
public static List<String> wordBreak3(String s, Set<String> wordDict) {
    ArrayList<String> [] pos = new ArrayList[s.length()+1];
    pos[0]=new ArrayList<String>();
 
    for(int i=0; i<s.length(); i++){
        if(pos[i]!=null){
            for(int j=i+1; j<=s.length(); j++){
                String sub = s.substring(i,j);
                if(wordDict.contains(sub)){
                    if(pos[j]==null){
                        ArrayList<String> list = new ArrayList<String>();
                        list.add(sub);
                        pos[j]=list;
                    }else{
                        pos[j].add(sub);
                    }
 
                }
            }
        }
    }
 
    if(pos[s.length()]==null){
        return new ArrayList<String>();
    }else{
        ArrayList<String> result = new ArrayList<String>();
        dfs(pos, result, "", s.length());
        return result;
    }
}
 
public static void dfs(ArrayList<String> [] pos, ArrayList<String> result, String curr, int i){
    if(i==0){
        result.add(curr.trim());
        return;
    }
 
    for(String s: pos[i]){
        String combined = s + " "+ curr;
        dfs(pos, result, combined, i-s.length());
    }
}
    public static void main(String[] args) {
        String s = "catsanddog";
        String[] DIC = {"POON", "and", "PLEE", "cat", "SAME", "cats", "POIE", "sand", "PLEA", "PLIE", "dog", "POIN"};
        Set<String> dict = new CopyOnWriteArraySet<String>(new CopyOnWriteArrayList<String>(DIC));
        System.out.println(wordBreak2(s, dict));

    }
}
