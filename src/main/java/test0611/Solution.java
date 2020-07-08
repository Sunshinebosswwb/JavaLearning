package test0611;

import java.util.Stack;

/**
 * @auther alex
 * @description test leetcood
 * @data 2020/6/18
 **/
public class Solution {
    public static void main(String[] args){
        String s = "()";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        //利用栈，遇到左括号就入栈，碰到右括号则入栈
        //出栈入栈不一致 则false
        if(s.length()%2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '{'|| ch == '[' || ch == '('){
                stack.push(ch);
            }
            else if(stack.empty()){//无左括号进栈
                return false;
            }
            else if((stack.peek()=='}' && ch == '{')||
                    (stack.peek()==']' && ch == '[') ||
                    (stack.peek()==')' && ch == '(')){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.empty();
    }
}
