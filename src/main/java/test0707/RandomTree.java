package test0707;

/**
 * @auther alex
 * @description 生成随机搜索二叉树
 * @data 2020/7/7
 **/
public class RandomTree {
    public static TreeTest.Node generateRandomBST(int min,int max,int N){
        if(min > max) return null;
        return creatTree(min,max,1,N);
    }

    public static TreeTest.Node creatTree(int min,int max,int level,int N){
        if(min > max || level > N) return null;
        TreeTest.Node head = new TreeTest.Node(random(min,max));
        head.left = creatTree(min,head.value -1,level+1,N);
        head.right = creatTree(head.value + 1,max,level,N);
        return head;
    }

    public static int random(int min,int max){
        return min + (int)(Math.random() * (max - min + 1));
    }
}
