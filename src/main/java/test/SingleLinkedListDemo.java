package test;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Stack;

/*
使用单链表完成一个英雄管理系统
 */
public class SingleLinkedListDemo
{
    public static void main(String[] args)
    {
        //新建英雄对象
        HeroNode hero1 = new HeroNode(1,"a","aa");
        HeroNode hero2 = new HeroNode(2,"b","bb");
        HeroNode hero_new = new HeroNode(2,"c","cc");

        //新建管理英雄对象
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //添加节点
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);

        //按顺序添加英雄
        singleLinkedList.addByOder(hero_new);

        //删除指定位置的节点
        //singleLinkedList.delele(1);

        //打印英雄榜
        singleLinkedList.list();

        //获取链表中有效节点个数
        System.out.println(getLength(singleLinkedList.getHead()));

        //获取倒数第k个节点
        HeroNode lastK = getLastKNode(singleLinkedList.getHead(),2);
        System.out.println(lastK);

        System.out.println("-------P22腾讯面试题输出分界线-------------");
        System.out.println("原始链表如下：");
        singleLinkedList.list();
        System.out.println("反转后的链表：");
        reverseLinkedList(singleLinkedList.getHead());
        singleLinkedList.list();

        System.out.println();
        System.out.println("再逆序打印如下：");
        reversePrint(singleLinkedList.getHead());


    }

    //从尾到头打印单链表
    /*
    1、先反转再遍历 问题是会破坏原来的单链表的结构
    2、利用栈这个数据结构，将各个节点压入栈中，先进后出，就实现了逆序打印
     */
    public static void reversePrint(HeroNode head)
    {
        if (head.next == null)
            return;
        //创建一个栈 压入数据
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while(cur != null)
        {
            stack.add(cur);//push也行
            cur = cur.next;
        }
        while(stack.size() > 0)
        {
            System.out.println(stack.pop());
        }
    }

    //获取单链表的节点的个数（不统计头节点）
    /*
     * @param  head 链表头节点
     * @return      有效节点的个鼠标
     */
    public static int getLength(HeroNode head)
    {
        if (head.next == null)
            return 0;
        int length = 0;
        HeroNode cur = head.next;
        while(cur != null)
        {
            length++;
            cur=cur.next;
        }
        return length;
    }

    //查找单链表的倒数第k个节点
    /*
    1、写一个方法接收head节点，同时接收一个index
    2、index就是倒数第k
    3、将链表从头到尾遍历，得到链表的总长度size   -- geLength（）
    4、得到size之后，遍历size-index个 得到结果
     */

    public static HeroNode getLastKNode(HeroNode head,int index)
    {
        if (head.next == null)
            return null;
        int size = getLength(head);
        if (index>size || index<=0)
            return null;

        HeroNode temp = head.next;
        for (int i=0;i<size-index;i++)
        {
            temp = temp.next;
        }
        return temp;
    }

    //单链表的反转
    public static void reverseLinkedList(HeroNode head)
    {
        if(head.next == null || head.next.next == null)
            return;

        //辅助变量帮助遍历原来的链表
        HeroNode cur = head.next;
        //指向当前节点[cur]的下一个节点，防止链表断开
        HeroNode next = null;
        //反向链表的头节点
        HeroNode reverseHead = new HeroNode(0,"","");
        while(cur != null)
        {
            //先暂时保存当前节点的下一个节点，提供后边使用
            next = cur.next;
            //将cur的下一个节点指向新的链表的最前端
            cur.next = reverseHead.next;
            //将cur连接到新的链表上
            reverseHead.next = cur;
            cur = next;
        }
        //将head.next指向reverseHead.next
        head.next = reverseHead.next;
    }
}

//管理英雄
class SingleLinkedList
{
    //先初始化一个头节点,不添加信息
    private HeroNode head = new HeroNode(0,"","");
    /*
    添加新的节点到单向链表
    1、找到当前链表的最后节点
    2、将这个节点的next指向新的节点
     */

    //返回头节点
    public  HeroNode getHead()
        {
            return head;
        }

    public void add(HeroNode heroNode)  //新加的节点heroNode对象
    {
        //head节点不能动 需要辅助temp遍历
        HeroNode temp = head; //head头节点对象中的元素和方法也传给temp
        //遍历链表，找到最后
        while(true)
        {
            if (temp.next == null)
                break;
            temp = temp.next;
        }
        temp.next = heroNode;//将添加的节点对象赋给最后的空结点next
    }

    //根据排名将英雄插入到指定位置
    //找到新添加的节点的位置（通过辅助变量遍历），新的节点.next=temp.next，temp.next=新节点
    public void addByOder(HeroNode heroNode)
    {
        HeroNode temp = head;
        boolean flag = false;//标识添加的编号是否存在

        while(true)
        {
            if(temp.next == null)
                break;
            if(temp.next.no > heroNode.no)
                break;
            else if(temp.next.no == heroNode.no)
            {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag)
        {
            System.out.println("英雄已存在");
        }
        else
        {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点的信息，根据no进行判断，同时不要修改no
    public void update(HeroNode newHeroNode)
    {
        if (head.next == null)
        {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;//设置标志，标识是否找到该节点
        while(true)
        {
            if (temp == null)
                break;
            if (temp.no == newHeroNode.no)
            {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag)
        {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }
        else
        {
           System.out.println("没有找到");
        }
    }

    /*
    删除节点
    1、找到要删除的节点的前一个节点temp
    2、temp.next=temp.next.next
    3、被删除的节点会被垃圾回收机制回收
     */
    //直接指定要删除的节点的编号
    public void delele(int no)
    {
        HeroNode temp = head;
        boolean flag = false;
        while(true)
        {
            if (temp.next == null)
                break;
            if (temp.next.no == no)
            {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag)
        {
            temp.next = temp.next.next;
        }
        else
        {
            System.out.println("没有找到要删除的节点");
        }
    }
    //显示链表 遍历链表
    public void list()
    {
        if(head.next == null)
        {
            System.out.println("链表为空");
            return;
        }
        //头节点不能动，借助于辅助变量来遍历
        HeroNode temp = head.next;
        while(true)
        {
            if (temp == null)
            {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

//定义HeroNode，每个此对象就是一个节点
class HeroNode
{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点 是一个空对象


    //构造方法
    public HeroNode(int no,String name,String nickname)
    {
        this.no = no; //函数的输入传给对象变量
        this.name = name;
        this.nickname = nickname;
    }

    //重新toString方法
    public String toString()
    {
        return "Heronode [no="+no+",name="+name+",nickname="+nickname+"]";
    }
}