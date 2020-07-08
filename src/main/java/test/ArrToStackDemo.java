package test;

public class ArrToStackDemo
{
    public static void main(String[] args)
    {
        ArrToStack arrToStack = new ArrToStack(100);
        arrToStack.push(1);
        arrToStack.push(2);
        arrToStack.push(3);
        arrToStack.list();
        arrToStack.pop();
        arrToStack.list();
    }
}

class ArrToStack
{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    ArrToStack(int maxSize)
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
}

