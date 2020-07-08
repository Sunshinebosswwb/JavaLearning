package test;

import java.util.Scanner;

public class CircleQueneDemo
{
    public static void main(String[] args)
    {
        CircleArray circleArray = new CircleArray(3);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop)
        {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");

            key = scanner.next().charAt(0);//接收一个字符
            switch(key)
            {
                case 's':
                    circleArray.showQuene();
                    break;
                case 'a':
                    System.out.println("输入一个数字");
                    int value = scanner.nextInt();
                    circleArray.addQuene(value);
                    break;
                case 'g':
                    try
                    {
                        int res = circleArray.getQuene();
                        System.out.printf("取出的数据是%d\n",res);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try
                    {
                        int res = circleArray.getQuene();
                        System.out.printf("队列头的数据是%d\n",res);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class CircleArray
{
    private int maxSize; //数组最大容量
    private int front;   //队列头
    private int rear;    //队列尾
    private int[] arr;

    public CircleArray(int arrMaxSize)
    {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //判断队列满否
    public boolean isFull()
    {
        return (rear+1)%maxSize == maxSize;
    }

    //判断队列是否为空
    public boolean isEmpty()
    {
        return rear == front;
    }

    //添加数据到队列
    public void addQuene(int n)
    {
        if(isFull())
        {
            System.out.println("队列已满，无法添加");
            return;
        }
        arr[rear] = n;
        //将rear后移，必须考虑取模
        rear = (rear+1)%maxSize;
    }

    //获取队列的数据 出列
    public int getQuene()
    {
        if (isEmpty())
            //System.out.println("队列为空");
            throw new RuntimeException("队列空，不能取出数据");
        //front指向队列的第一个元素  先把front值保存到临时变量 front后移  返回临时变量
        int value = arr[front];
        front = (front+1)%maxSize;
        return value;
    }

    //显示队列所有数据
    public void showQuene()
    {
        if (isEmpty())
        {
            System.out.println("队列为空");
            return;
        }
        //从front开始遍历，遍历个 有效数据个 元素
        for(int i=0;i<size();i++)
        {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //获取有效数据个数
    public int size()
    {
        return (rear-front+maxSize)%maxSize;
    }
}