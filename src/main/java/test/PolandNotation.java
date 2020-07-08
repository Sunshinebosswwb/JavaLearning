package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation
{
    public static void main(String[] args)
    {
        //先定义逆波兰表达式  （3+4）*5-6 ==== 34+5*6-
        String suffixExpression = "3 4 + 5 * 6 -";

        /*
        将表达式存放到ArrayList中
        将ArrayList传递给一个方法，遍历ArrayList配合栈完成计算
         */
        List<String> rpnlist = getListString(suffixExpression);
        //System.out.println(rpnlist);
        int ans = cal(rpnlist);
        System.out.println(ans);

    }
    public static List<String> getListString(String suffixExpression)
    {
        String[] split = suffixExpression.split(" ");//分割表达式
        List<String> list = new ArrayList<String>();
        for (String ele:split)
        {
            list.add(ele);
        }
        return list;
    }

    //完成计算
    public static int cal(List<String> list)
    {
        Stack<String> stack = new Stack<String>();
        for(String item : list)
        {
            //使用正则表达式取出数
            if (item.matches("\\d+"))
            {
                stack.push(item);
            }else
            {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;

                if(item.equals("+"))
                {
                    res = num2+num1;
                }else if (item.equals("-"))
                {
                    res = num2-num1;
                }else if (item.equals("/"))
                {
                    res = num2/num1;
                }else if (item.equals("*"))
                {
                    res = num2*num1;
                }else
                {
                    throw  new RuntimeException("符号不对");
                }

                stack.push(res+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
