package java.leetcode;

import java.util.Scanner;

/**
 * @ClassName _81_SearchRotateArray
 * @Description 搜索旋转排序数组
 * @Author yangxiaobo
 * @Date 2021/4/11 16:41
 * @Version 1.0
 */
public class _81_SearchRotateArray {
    public static boolean search(int[] nums, int target) {
        if(nums.length==0){
            return false;
        }
        int l = 0;
        int r = nums.length-1;
        if(nums[r]==target||nums[l]==target){
            return true;
        }
        while(l<r){
            int mid = (r+l)/2;
            if(nums[mid]==target||nums[r]==target||nums[l]==target){
                return true;
            }
            if(nums[mid]==nums[l]){
                l++;
                continue;
            }
            if(nums[mid]==nums[r]){
                r--;
                continue;
            }
            if(nums[mid]>nums[l]){
                if(target>nums[l]&&target<nums[mid]){
                    r = mid-1;
                }else if(target>nums[mid]||target<nums[r]){
                    l = mid+1;
                }else{
                    return false;
                }
            }else{
                if(nums[mid]<target&&nums[r]>target){
                    l = mid+1;
                }else if(nums[mid]>target||nums[l]<target){
                    r = mid -1;
                }else{
                    return false;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int target = in.nextInt();
        String[] s = str.split(",");
        int[] arr = new int[s.length];
        for(int i=0;i<s.length;i++){
            if(i==0){
                arr[i] = s[i].charAt(1)-'0';
            }else{
                arr[i] = s[i].charAt(0)-'0';
            }
        }
        System.out.print(search(arr,target));
    }
}
