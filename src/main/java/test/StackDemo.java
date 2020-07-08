package test;

import java.util.Stack;
//栈 Stack  先进后出 后进先出
public class StackDemo
{
    public static void main(String[] args)
    {
        Stack<String>  stack = new Stack<String>();
        //入栈
        stack.add("小王");
        stack.add("小李");
        stack.add("小刘");
        //出栈
        while(stack.size()>0)
        {
            System.out.println(stack.pop());//将栈顶的元素取出
        }
    }
}

