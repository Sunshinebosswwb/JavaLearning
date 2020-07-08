package test;
//左递归出现java.lang.StackOverflowError
//都出现问题  妈的 服了
public class Search {
    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,7} ;
        Search s = new Search();
        System.out.println(s.tow_search(a,6));
        s.sort(a,0,a.length - 1);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("下边是二分查找的结果");
        System.out.println(s.tow_search(a,7));
    }
    //二分, 有问题
    public int tow_search(int[] arr,int target){
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while(start <= end){
            mid = start + ( end - start )/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                end = mid - 1;
            }else{
                end = mid + 1;
            }
        }
        return -1;
    }
    //快排
    public  void sort(int[] arr,int low,int high)
    {
      int lo = low;
      int hi = high;
      int flag = arr[arr.length / 2];
      int temp= 0;
      while(lo < hi){
          while(arr[lo] < flag){
              lo += 1;
          }
          while(arr[hi] > flag){
              hi -= 1;
          }
          //循环结束条件
          if( lo >= hi){
              break;
          }
          //左右互换
          temp = arr[lo];
          arr[lo] = arr[hi];
          arr[hi] = temp;

          //交换完成后的判断 避免卡在flag上
          if(arr[lo] == flag){
              hi -=1;
          }
          if(arr[hi] == flag){
              lo += 1;
          }
          if(lo == hi){
              lo += 1;
              hi -=1;
          }

          //向左递归
          if(low < hi){
              sort(arr,low,hi);
          }
          //向右递归
          if(high > lo){
              sort(arr,lo,high);
          }

      }
    }
}
