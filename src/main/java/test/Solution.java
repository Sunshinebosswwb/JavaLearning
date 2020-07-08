package test;
import java.util.*;
//import org.graalvm.compiler.nodes.spi.ArrayLengthProvider;

public class Solution {
    public static void main(String[] args) {

    }
        public Object[] siHashngleNumber(int[] nums) {
            Set<Integer> res = new HashSet<>();
            for(int i=0;i<nums.length;i++){
                res.add(nums[i]);
            }
            int flag = 0;
            while(flag < nums.length - 1){
                for(int i=flag+1;i<nums.length;i++){
                    if(nums[i] == nums[flag]) res.remove(nums[flag]);
                }
                flag++;
            }
            Object[] arr = res.toArray();
            return arr;
        }
}
