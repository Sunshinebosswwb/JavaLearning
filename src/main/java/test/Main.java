package test;
import java.util.*;
/**
 * @auther alex
 * @description
 * @data 2020/6/22
 **/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        m.sys1();
    }
    private void sys1(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[2*n];
            int i,j;
            for(i=1;i<2*n;i++){
                int index = i;
                for(j=0;j<k;j++){
                    if(index <= n){
                        index = 2*index - 1;
                    }else{
                        index = (index - n)*2;
                    }
                }
                arr[index - 1] = sc.nextInt();
            }
            for(i=0;i<2*n-1;i++){
                System.out.println(arr[i] + "");
            }
            System.out.println(arr[i]);
        }
    }
}
/*
class Solution {
    public int numSteps(String s) {
        int res =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1'){
                res += sqr(2,s.length()-i-1);
            }
        }
        if(res % 2 == 0){
            return res / 2;
        }else{
            return res + 1;
        }

    }

    private int sqr(int n,int i){
        //求n的i次方
        if(i == 0){
            return 1;
        }
        int res = n;
        while(--i > 0){
            res = res*n;
        }
        return res;
    }
}
*/