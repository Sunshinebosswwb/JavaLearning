package test;
import  java.util.*;
public class LinkedListTest
{
    public static void main(String[] args)
    {
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("bob");
        b.add("Frances");
        b.add("Gloria");

        //把b的名字加到a中  发现是隔一个插一个
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while(bIter.hasNext())
        {
            if(aIter.hasNext())
                aIter.next();//往后挪一个
            aIter.add(bIter.next());//加一个之后b也往后挪一个
        }
        System.out.println(a);

        //隔着一个元素删除一个
        System.out.println(b);
        bIter = b.iterator();
        while(bIter.hasNext())
        {
            bIter.next();
            if(bIter.hasNext())
            {
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println(b);

        //将a中所有b的元素删除
        a.removeAll(b);
        System.out.println(a);
    }
}
