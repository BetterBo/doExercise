package java.alibaba;

import java.util.Scanner;

/**
 * @ClassName exam210410_3
 * @Description
 * // 评测题目3：变体降序数组的二分查找
 * // 变体降序数组，指将初始降序的数组进行一次调整，随机选一个数组下标，将其之后的数字全部移动插入到数组头部
 * // 在变体降序数组中，找到指定的数字，找到的话返回下标的最小值(存在重复数字的情况下)
 * // 找不到时返回-1，数组元素均为整型
 * // 样例输入：2，2，1，7，6，5，4，3
 * // 样例输入(查找数字)：6
 * // 样例输出：4
 * @Author yangxiaobo
 * @Date 2021/4/10 19:04
 * @Version 1.0
 */
public class exam210410_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int target = in.nextInt();
        String[] split = str.split("，");
        int[] arr = new int[split.length];
        for(int i=0;i<arr.length;i++){
            arr[i] = split[i].charAt(0)-'0';
        }
        int result = calc(arr,target);
        if(result==-1){
            System.out.print(result);
            return;
        }
        while(result>=0&&arr[result]==target){
            result--;
        }
        System.out.print(result+1);
    }

    public static int calc(int[] arr,int target){
        int len = arr.length;
        int l = 0;
        int r = len -1;
        while(l<=r){
            int mid = (r+l)/2;
            //l相等则直接返回[可以优先返回最小的左边值]
            if(arr[l] == target){
                return l;
            }
            //mid相等则直接返回
            if(arr[mid] == target){
                return mid;
            }
            //r相等则直接返回
            if(arr[r] == target){
                return r;
            }
            //mid不等相等且arr[mid]==arr[l]，左指针右移
            if(arr[mid]==arr[l]){
                l++;
                continue;
            }
            //mid不等相等且arr[mid]==arr[r]，右指针左移
            if(arr[mid]==arr[r]){
                r--;
                continue;
            }
            //若中间值小于左边，target可分为三种情况
            if(arr[mid]<arr[l]){
                //序列如下
                //4 3 2 2 2 1 9 8 7 6
                //l      mid        r
                //target = 3
                if(target<=arr[l]&&target>arr[mid]){
                    r = mid-1;
                //序列如下
                //4 3 2 2 2 1 9 8 7 6
                //l      mid        r
                //target = 8 || target = 1
                }else if(target>arr[r]||target<arr[mid]){
                    l = mid+1;
                }else{
                    //4 3 2 2 2 1 9 8 7 6
                    //l      mid        r
                    //target = 5
                    return -1;
                }
            //若中间值大于左边，target可分为三种情况
            }else{
                //序列可能如下
                //4 3 1 10 9 9 8 7 6
                //l       mid      r
                //target = 8
                //序列也可能如下
                //4 3 2 2 2 1 1
                //l    mid    r
                //target = 1
                if(arr[mid]>target&&arr[r]<=target){
                    l = mid+1;
                //序列可能如下
                //4 3 1 10 9 9 8 7 6
                //l       mid      r
                //target = 10 || target = 1
                //序列也可能如下
                //4 3 2 2 2 1 1
                //l    mid    r
                //target = 3
                }else if(arr[mid]<target||arr[l]>target){
                    r = mid -1;
                }else{
                    //4 3 1 10 9 9 8 7 6
                    //l       mid      r
                    //target = 5
                    return -1;
                }
            }
        }
        return -1;
    }
}
