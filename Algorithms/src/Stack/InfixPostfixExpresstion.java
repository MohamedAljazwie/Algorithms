/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author M_Aljazwiee
 */
public class InfixPostfixExpresstion {

    private final Stack<Character> stack;
    private StringBuffer postFix;
    private Character popChar;

    public InfixPostfixExpresstion() {
        stack = new Stack<>();
        postFix = new StringBuffer();

    }

    public String convertToPostFix(String expressionValue) {
        char[] cs = expressionValue.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (!isSpace(c)) {
                if (isOperator(c)) {
                     postFix.append(" ");
                    if (stack.isEmpty()) {
                        if (c != ')') {
                            stack.push(c);
//                            postFix.append(" ");
                        }
                    } else if (c == ')') {
                        popChar = stack.pop();
                        while (popChar != '(') {
                            postFix.append(" ").append(popChar);
                            popChar = (char) stack.pop();
                        }
                       // postFix.append(" ");
                    } // check if c==) 
                    else {
                        popChar = stack.get();
                        if (popChar == '(') {
                            stack.push(c);
//                             postFix.append(" ");
                        } else {
                            if (getPrecedence(c) <= getPrecedence(popChar)) {
                                popChar = stack.pop();
                            }
                            while (getPrecedence(c) <= getPrecedence(popChar)) {
                                if (popChar == '(') {
                                    stack.push(popChar);
                                    break;
                                } else {
                                    postFix.append(" ").append(popChar).append(" ");
                                    if (stack.isEmpty()) {
                                        break;
                                    }

                                    popChar = stack.pop();
                                }
                            }  // end while getprecedence()
                             
                            stack.push(c);
                        }

                    } //ckeck if c!=) 

                } // end check operator
                else {
                    postFix.append(c);
                }
            } // ens check space
        } // end for loop
        
        while (!stack.isEmpty()) {
            postFix.append(" ").append(stack.pop());
        }
        return postFix.toString();
    }

    public String clacolatePostFix(String expressionValue) {
        Stack stack =new Stack();
        String postFix=convertToPostFix(expressionValue);
        
      
        char [] cs=postFix.toCharArray();
        for(int c =0 ;c<cs.length;c++)
        {
            if(isSpace(cs[c]))
                continue;
            if(isOperator(cs[c]))
            {
                Integer popValue1=(Integer) stack.pop();
                Integer popValue2=(Integer) stack.pop();
                class cal{
                     Integer cal(Integer val2 ,Integer val1,char operator)
                    {
                        Integer resulte=-1;
                        switch(operator)
                        {
                            case '+':
                                resulte=val1+val2;
                                break;
                                case '-':
                                resulte=val1-val2;
                                break;
                                case '*':
                                resulte=val1*val2;
                                break;
                                case '/':
                                resulte=val1/val2;
                                break;
                                
                        }
                        
                        return  resulte;
                    }
                }
                Integer resulte=new cal().cal(popValue1, popValue2, cs[c]);
                
                stack.push(resulte);
            }
            if(isOperand(cs[c]))
            {
                StringBuffer value=new StringBuffer();
                value.append(cs[c]);
                ++c;
               for(;c<cs.length;c++)
               {
                   if(isOperand(cs[c]))
                       value.append(cs[c]);
                   else 
                       break;
               }
               stack.push(Integer.valueOf(value.toString()));
               c--;
                    
            }
        }
        return  stack.toString();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' || c == ')';
    }
private boolean isOperand(char c)
{
    Pattern p=Pattern.compile("[0-9]");
    Matcher matcher=p.matcher(String.valueOf(c));
    return matcher.find();
}
    private boolean isSpace(char c) {
        return c == ' ';
    }

    private static int getPrecedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
            case '(':
            case ')':
                return 4;

        }
        return -1;
    }
    public static void main(String[] args) {
        String f="(13+20*13+20)*13+(20*13+20)*(5+3*4)-2+(5+3*4)-2*(5+3*4)-2+(5+3*4)-2";
        System.out.println((13+20*13+20)*13+(20*13+20)*(5+3*4)-2+(5+3*4)-2*(5+3*4)-2+(5+3*4)-2);
        System.out.print(new InfixPostfixExpresstion().clacolatePostFix(f));
    }
}
