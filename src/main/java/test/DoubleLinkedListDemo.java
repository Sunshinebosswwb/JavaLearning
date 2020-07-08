package test;

public class DoubleLinkedListDemo
{
    public static void main(String[] args) {
        //双向链表测试:
        //新建英雄对象
        HeroNode2 hero1 = new HeroNode2(1, "a", "aa");
        HeroNode2 hero2 = new HeroNode2(2, "b", "bb");
        HeroNode2 hero3 = new HeroNode2(3, "c", "cc");
        HeroNode2 hero4 = new HeroNode2(4, "d", "dd");
        //新建英雄榜
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        //添加英雄
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        //遍历
        doubleLinkedList.list();
        //添加
        doubleLinkedList.add(new HeroNode2(5,"e","ee"));
        System.out.println("在尾部添加后");
        doubleLinkedList.list();
        //修改
        HeroNode2 newHeroNode2 = new HeroNode2(5,"eee","eeeee");
        doubleLinkedList.updata(newHeroNode2);
        System.out.println("修改节点后");
        doubleLinkedList.list();
        //删除
        doubleLinkedList.delete(5);
        System.out.println("删除节点后");
        doubleLinkedList.list();
    }
}
class DoubleLinkedList
{
    //初始化一个头节点，不存放具体数据
    private HeroNode2 head = new HeroNode2(0,"","");
    //将头节点返回
    public HeroNode2 getHead()
    {
        return head;
    }

    //遍历双向链表
    public void list()
    {
        if (head.next == null)
        {
            System.out.println("该链表为空");
            return;
        }
        //使用辅助变量遍历节点
        HeroNode2 temp = head.next;
        while(true)
        {
            if (temp == null)
                break;
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //添加节点到双向链表的最后
    public void add(HeroNode2 heroNode2)
    {
        HeroNode2 temp = head;
        while(true)
        {
            if (temp.next != null)
            {
                temp = temp.next;
            }
            else
                break;
        }

        //形成双向链表
        temp.next = heroNode2;
        heroNode2.pre = temp;
    }

    //修改数据
    public void updata(HeroNode2 newHeroNode2)
    {
        if (head.next == null)
        {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while(true)
        {
            if (temp == null)
                break;
            if (temp.no == newHeroNode2.no)
            {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag)
        {
            temp.name = newHeroNode2.name;
            temp.nickname = newHeroNode2.nickname;
        }
    }

    //删除指定节点  双向链表可以直接找到要删除的节点
    public void delete(int no)
    {
        if(head.next == null)
        {
            System.out.println("链表为空");
        }

        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true)
        {
            if (temp == null)
                break;
            if (temp.no == no)
            {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag)
        {
            temp.pre.next = temp.next;
            //注意最后一个节点没有next节点
            if (temp.next != null)
                temp.next.pre = temp.pre;
        }else
        {
            System.out.println("没找到该节点");
        }
    }
}

//定义HeroNode2，每个此对象就是一个节点
class HeroNode2
{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;//指向下一个节点 是一个空对象
    public HeroNode2 pre; //指向前一个节点 默认为空

    //构造方法
    public HeroNode2(int no,String name,String nickname)
    {
        this.no = no; //函数的输入传给对象变量
        this.name = name;
        this.nickname = nickname;
    }

    //重新toString方法
    public String toString()
    {
        return "Heronode2 [no="+no+",name="+name+",nickname="+nickname+"]";
    }
}