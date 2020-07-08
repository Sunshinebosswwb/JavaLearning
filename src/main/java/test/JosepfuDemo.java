package test;

public class JosepfuDemo
{
    public static void main(String[] args)
    {
        //测试
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(10);
        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(1,3,10);
    }
}
//创建单向环形链表
class CircleSingleLinkedList
{
    //创建first节点，当前没有编号
    private Boy first = new Boy(-1);
    //添加节点，构成环形链表
    public void addBoy(int nums)
    {
        if (nums < 1)
        {
            System.out.println("错误的nums");
            return;
        }
        //辅助指针帮助构建环形链表
        Boy curBoy = null;
        //使用for循环创建环形链表
        for(int i = 1;i<=nums;i++)
        {
            Boy boy = new Boy(i);
            if (i == 1)
            {
                first = boy;
                first.setNext(first);//构成环
                curBoy = first;//让curBoy指向第一个小孩
            }
            else
            {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }
    //遍历当前环形链表
    public void showBoy()
    {
        if (first == null)
        {
            System.out.println("没有任何节点");
            return;
        }
        //借助辅助指针完成遍历
        Boy curBoy = first;
        while(true)
        {
            System.out.printf("小孩的编号%d \n",curBoy.getNo());
            if (curBoy.getNext() == first)
            {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }
    //根据用户输入，计算出圈顺序
    //开始数 数几下 最开始有几个小孩
    public void countBoy(int startNo,int countNum,int nums)
    {
        if (first == null || startNo < 1 || startNo>nums)
        {
            System.out.println("输入有误");
            return;
        }
        //创建辅助指针,指向最后一个节点
        Boy helper = first;
        while (true)
        {
            if (helper.getNext() == first)
                break;
            helper = helper.getNext();
        }
        //报数前移动k-1次
        while (true)
        {
            if (helper == first)
                break;
            for (int j=0;j<countNum-1;j++)
            {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("小孩%d出圈\n",first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩的编号%d \n",first.getNo());
    }
}

//新建一个Boy类==节点
class Boy
{
    private int no;
    private Boy next;

    public Boy(int no)
    {
        this.no = no;
    }

    public int getNo()
    {
        return no;
    }

    public void setNo(int no)
    {
        this.no = no;
    }

    public Boy getNext()
    {
        return next;
    }

    public void setNext(Boy next)
    {
        this.next = next;
    }
}