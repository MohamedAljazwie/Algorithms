/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import LinkedList.LinkedList;
import Stack.Stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *
 * @author MohamedSayed
 */
public class Strings_And_Array {

    static class WordNode {

        String word;
        int numSteps;
        WordNode pre;

        public WordNode(String word, int numSteps, WordNode pre) {
            this.word = word;
            this.numSteps = numSteps;
            this.pre = pre;
        }
    }

    public static boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int starIndex = -1;
        int iIndex = -1;
        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                ++i;
                ++j;
            } else if (j < p.length() && p.charAt(j) == '*') {
                starIndex = j;
                iIndex = i;
                j++;
            } else if (starIndex != -1) {
                j = starIndex + 1;
                i = iIndex + 1;
                iIndex++;
            } else {
                return false;
            }
        }
        while (j < p.length() && p.charAt(j) == '*') {
            ++j;
        }
        return j == p.length();
    }

    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();

        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(start, 1, null));

        dict.add(end);

        int minStep = 0;

        HashSet<String> visited = new HashSet<String>();
        HashSet<String> unvisited = new HashSet<String>();
        unvisited.addAll(dict);

        int preNumSteps = 0;

        while (!queue.isEmpty()) {
            WordNode top = queue.remove().value;
            String word = top.word;
            int currNumSteps = top.numSteps;

            if (word.equals(end)) {
                if (minStep == 0) {
                    minStep = top.numSteps;
                }

                if (top.numSteps == minStep && minStep != 0) {
                    //nothing
                    ArrayList<String> t = new ArrayList<String>();
                    t.add(top.word);
                    while (top.pre != null) {
                        t.add(0, top.pre.word);
                        top = top.pre;
                    }
                    result.add(t);
                    continue;
                }

            }

            if (preNumSteps < currNumSteps) {
                unvisited.removeAll(visited);
            }

            preNumSteps = currNumSteps;

            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char temp = arr[i];
                    if (arr[i] != c) {
                        arr[i] = c;
                    }

                    String newWord = new String(arr);
                    if (unvisited.contains(newWord)) {
                        queue.add(new WordNode(newWord, top.numSteps + 1, top));
                        visited.add(newWord);
                    }

                    arr[i] = temp;
                }
            }

        }

        return result;
    }

    public static List wordLadder(String start, String target, List dictionary) {
        List<List<String>> totalChain = new ArrayList();
//        if (start == target) {
//            chain.add(start);
//            return chain;
//        }
//        if (isSingleCharacterChange(start, target)) {
//            chain.add(start);
//            chain.add(target);
//            return chain;
//        }
        String oldStart=start;
        int size = dictionary.size();
      
        while (size > 0) {
              boolean noFound=true;
            List<String> chain = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (isSingleCharacterChange(start, (String) dictionary.get(i))) {
                  
                    chain.add(start);
                    noFound=false;
                    if (isSingleCharacterChange((String) dictionary.get(i), target)) {
                        chain.add((String) dictionary.get(i));
                        chain.add(target);
                        start = (String) dictionary.get(i);
                        dictionary.remove(i);
                        size--;
                        i = -1;
                        start=oldStart;
                        totalChain.add(chain);
                        
                        break;
                    }
                    start = (String) dictionary.get(i);
                    dictionary.remove(i);
                    size--;
                    i = -1;
                }

            }
            if(noFound)
                break;
        }
        return totalChain;
    }

    private static boolean isSingleCharacterChange(String source, String dec) {
        if (source == null || dec == null || source.length() != dec.length()) {
            return false;
        }

        boolean isChange = false;

        for (int i = 0; i < source.length(); i++) {

            if (source.charAt(i) != dec.charAt(i)) {
                if (isChange) {
                    return false;
                }

                isChange = true;
            }
        }
        return true;
    }

    public static int reverse(int x) {
        //flag marks if x is negative
        boolean flag = false;
        if (x < 0) {
            x = 0 - x;
            flag = true;
        }

        int res = 0;
        int p = x;

        while (p > 0) {
            int mod = p % 10;
            p = p / 10;
            res = res * 10 + mod;
        }

        if (flag) {
            res = 0 - res;
        }

        return res;
    }

    public static Integer reverseInteger(Integer integer) {
        if (integer == null || integer == 0) {
            return integer;
        }
        String reverse = String.valueOf(integer);
        char[] cs = reverse.toCharArray();
        if (cs.length == 2) {
            if (cs[0] == '+' || cs[0] == '-') {
                return integer;
            }
        }
        int i = 0;
        int j = cs.length - 1;
        if (cs[0] == '+' || cs[0] == '-') {
            i = 1;
        }
        while (i < j) {
            char temp = cs[j];
            cs[j] = cs[i];
            cs[i] = temp;
            i++;
            j--;
        }
        return Integer.valueOf(String.valueOf(cs));

    }

    public static String reverseVowels(String word) {
        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        char[] cs = word.toCharArray();
        int i = 0;
        int j = cs.length - 1;
        while (i < j) {
            if (!vowels.contains(cs[i])) {
                i++;
                continue;
            }
            if (!vowels.contains(cs[j])) {
                j--;
                continue;
            }
            char temp = cs[j];
            cs[j] = cs[i];
            cs[i] = temp;
            if (vowels.contains(cs[i])) {
                i++;
            }
            if (vowels.contains(cs[j])) {
                j--;
            }
        }
        return new String(cs);
    }

    public static String reverseWords(String word) {
        if (word == null || word.isEmpty()) {
            return word;
        }

        String[] words = word.split(" ");
        Stack<String> stack = new Stack<>();
        for (String wo : words) {
            if (wo == "") {
                stack.push(" ");
            }
            stack.push(wo);
        }
        StringBuffer buffer = new StringBuffer();

        while (stack.size() != 0) {
            buffer.append(stack.pop()).append(" ");
        }

        return buffer.toString();
    }

    public static char[] reverseWords(char[] s) {
        int i = 0;
        for (int j = 0; j < s.length; j++) {
            if (s[j] == ' ') {
                reverse(s, i, j - 1);
                i = j + 1;
            }
        }

        reverse(s, i, s.length - 1);

        reverse(s, 0, s.length - 1);
        return s;
    }

    private static void reverse(char[] s, int i, int j) {
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
//        System.out.println("My Name Is Mohamed Sayed Aljazwiee");
//        System.out.println(reverseVowels("My Name Is Mohamed Sayed Aljazwiee"));
//        System.out.println(reverse(-123654));
//
        String[] DIC = {"POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN"};
        DIC = new String[]{"hot", "dot", "dog","lit", "lot", "log","hot", "dot", "dog","lit", "lot", "log"};
        Set dictionary = new CopyOnWriteArraySet(new CopyOnWriteArrayList(DIC));
//        System.out.println(findLadders("hit", "cog", dictionary));
        List dicList = new CopyOnWriteArrayList(DIC);
        System.out.println(wordLadder("hit", "cog", dicList));
//        
//System.out.println(isMatch("asds", "*ds"));

    }
}
