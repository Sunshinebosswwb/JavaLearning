package test0707;

/**
 * @auther alex
 * @description 重构二叉树
 * 给一个后续遍历出的数组，重构该二叉树
 * @data 2020/7/7
 **/
public class TreeTest {
    public static class Node{//节点
        public int value;
        public Node left;
        public Node right;

        public Node(int val){
            value = val;
        }
    }

    public static Node posArrayToBST1(int[] posArr){
        return process1(posArr,0,posArr.length-1);
    }

    //迭代法，复杂度n2,不是最优解
    public static Node process1(int[] posArr,int left,int right){
        if(left > right) return null;
        Node head = new Node(posArr[right]);
        if(left == right) return head;
        //找左树头节点，小于head的最后一个数组元素
        int mid = left -1;//考虑深远，应对没有左树的情况
        //遍历法查找，复杂度高，可以用二分法
        for(int i = left;i < right;i++){
            if(posArr[i] < posArr[right])  mid = i;
        }

        head.left = process1(posArr,left,mid);//左子树的头节点
        head.right = process1(posArr,mid+1,right-1);

        return head;
    }

    //优化方法 n * log2n
    public static Node process2(int[] posArr,int left,int right){
        if(left > right) return null;
        Node head = new Node(posArr[right]);
        if(left == right) return head;
        //找左树头节点，小于head的最后一个数组元素
        int mid = left -1;//考虑深远，应对没有左树的情况
        //二分法
        while(left <= right){
            int m = left + (right - left) >> 1;//  比/快
            if(posArr[m] < posArr[right]){
                mid = m;
                left = m + 1;
            }else{
                right = m - 1;
            }
        }
        head.left = process2(posArr,left,mid);//左子树的头节点
        head.right = process2(posArr,mid+1,right-1);

        return head;
    }
}
