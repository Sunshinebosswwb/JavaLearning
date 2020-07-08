package test;

import java.util.ArrayList;
import java.util.List;

public class MiddleToEnd
{
    public static void main(String[] args)
    {
        String expression = "（ 3 + 4 ） * 5 - 6";

    }

    public static List<String> toInfixExpressionList(String expression)
    {
        String[] split = expression.split(" ");//分割表达式
        List<String> list = new ArrayList<String>();
        for (String ele:split)
        {
            list.add(ele);
        }
        return list;
    }

}
/////不学了