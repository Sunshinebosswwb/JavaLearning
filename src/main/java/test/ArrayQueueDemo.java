package test;
/*
数组模拟队列
 */

import java.util.Scanner;

public class ArrayQueueDemo
{
    public static void main(String[] args)
    {
        ArrayQuene arrayQuene = new ArrayQuene(9);
        char key = ' '; //接收用户输入
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
                    arrayQuene.showQuene();
                    break;
                case 'a':
                    System.out.println("输入一个数字");
                    int value = scanner.nextInt();
                    arrayQuene.addQuene(value);
                    break;
                case 'g':
                    try
                    {
                        int res = arrayQuene.getQuene();
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
                        int res = arrayQuene.getQuene();
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

class ArrayQuene
{
    private int maxSize; //数组最大容量
    private int front;   //队列头
    private int rear;    //队列尾
    private int[] arr;

    //创建队列的构造器
    public ArrayQuene(int arrMaxSize)
    {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头部（front指针在头部之前的位置）
        rear = -1; //指向队列尾部，指向队列尾部的数据，就是最后一个数据（包含）
    }

    //判断队列满否
    public boolean isFull()
    {
        return rear == maxSize-1;
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
        rear++;
        arr[rear] = n;
    }

    //获取队列的数据 出列
    public int getQuene()
    {
        if (isEmpty())
            //System.out.println("队列为空");
            throw new RuntimeException("队列空，不能取出数据");
        front++;
        return arr[front];
    }

    //显示队列所有数据
    public void showQuene()
    {
        if (isEmpty())
        {
            System.out.println("队列为空");
            return;
        }
        for(int i=0;i<arr.length;i++)
        {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
}
