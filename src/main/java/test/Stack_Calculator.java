package test;

import org.graalvm.compiler.lir.phases.EconomyAllocationStage;

import java.util.Stack;
//用栈实现一个计算器 用数组模拟栈
/*
1、通过index值遍历输入表达式
2、发现是数字就入数栈 符号入符号栈
3、符号栈为空新符号直接入栈，不为空进入4步骤
4、比较操作符的优先级，小于符号栈的优先级时，数栈中pop两个数and符号栈pop一个符号进行运算，结果进入数栈，操作符再进栈
5、如果优先级大于栈中存在的操作符，则入栈
6、扫描完毕后，两个栈pop数据
7、最后数栈中的一个数据=表达式的结果
 */
public class Stack_Calculator {
    public static void main(String[] args)
    {
        String expression = "3+89";//只能计算个位的数运算
        ArrToStack_2 numStack = new ArrToStack_2(20);
        ArrToStack_2 operStack = new ArrToStack_2(20);

        //初始化相关变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//扫描得到的char保存到ch
        String keepNum = "";
        while(true)
        {
            //依次得到expression的每一个字符
            ch = expression.substring(index,index+1).charAt(0);
            //判断ch，进行处理
            if(operStack.isOper(ch))//是不是运算符
            {
                if(!operStack.isEmpty())//当前符号栈非空，进行比较
                {
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek()))
                    {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        numStack.push(res);//把数据压入数栈
                        operStack.push(ch);//把操作符压入符号栈
                    }else//优先级大于  直接入栈
                    {
                        operStack.push(ch);
                    }
                }else //栈空 直接入栈
                {
                    operStack.push(ch);
                }
            }else//是数字符
            /*
            1、原方法针对多位数字的运算不适用
            2、不能发现一个数字就入栈，应该观察index后一位是不是数字
            3、定义一个变量字符串用于拼接单个数字
             */
            {
                //numStack.push(ch - 48);
                keepNum += ch;

                if(index == expression.length() - 1)
                {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    if (operStack.isOper(expression.substring(index+1, index+2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            //让index+1 并判断是否扫描到末尾
            index++;
            if (index >= expression.length())
            {
                break;
            }
        }

        //扫描完毕 依次出栈
        while(true)
        {
            if (operStack.isEmpty())
            {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();

            res = numStack.cal(num1,num2,oper);
            numStack .push(res);
        }

        //输出结果
        System.out.println(res);
    }
}

class ArrToStack_2
{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    ArrToStack_2(int maxSize)
    {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull()
    {
        return top == maxSize - 1;
    }

    public boolean isEmpty()
    {
        return top == -1;
    }
    //进栈
    public void push(int value)
    {
        if (isFull())
            return;
        else
        {
            top++;
            stack[top] = value;
        }
    }

    public int pop()
    {
        if (isEmpty())
            throw new RuntimeException("栈空");
        else {
            int value = stack[top];
            top--;
            return value;
        }
    }

    public void list()
    {
        if (isEmpty())
            return;
            //从栈顶开始遍历数据
        else
        {
             for (int i=top;i>=0;i--)
            {
                System.out.println(stack[i]);
            }
        }
    }
    //返回运算符的优先级 优先级大小使用数字表示 (+ _ * /)
    public int priority(int oper)
    {
        if(oper == '*' || oper == '/')
        {
            return 0;
        }else
        {
            return -1;
        }
    }
    //判断是不是运算符
    public boolean isOper(char val)
    {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }
    //计算方法
    public int cal(int num1,int num2,int oper)
    {
        int res = 0;
        switch(oper)
        {
            case '+':
                res = num2+num1;
                break;
            case '-':
                res = num2-num1;
                break;
            case '/':
                res = num2/num1;
                break;
            case '*':
                res = num2*num1;
                break;
        }
        return res;
    }

    //返回栈顶的值
    public int peek()
    {
        return stack[top];
    }
}