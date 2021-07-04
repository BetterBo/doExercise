package java.leetcode;

/**
 * @ClassName _321_Concatenate_the_largest_number
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2020/12/2 21:56
 * @Version 1.0
 */
public class _321_Concatenate_the_largest_number {
    static int[] resultList;
    static int length;
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        resultList = new int[k];
        length = k;
        for(int i=0;i<k;i++){
            resultList[i] = -1;
        }
        int nums1Pre = 0;
        int nums2Pre = 0;
        if(k==0){
            return new int[0];
        }
        findResult(nums1, nums2, k, nums1Pre, nums2Pre);
        return resultList;
    }

    public static void findResult(int[] nums1, int[] nums2, int k,int nums1Pre,int nums2Pre){
        if(k==0){
            return;
        }
        int[][] presentMaxIndex = getPresentMaxIndex(nums1, nums2, k, nums1Pre, nums2Pre);
        int j = 0;
        //抛弃多余的分支
        if(presentMaxIndex[j][0]==1&&resultList[length-k]>nums1[presentMaxIndex[j][1]]){
            return;
        }else if(presentMaxIndex[j][0]==2&&resultList[length-k]>nums2[presentMaxIndex[j][1]]){
            return;
        }
        /**
         * 每次存在多个结果，如何判断使用哪一个？？？
        */
        while(j<presentMaxIndex.length&&presentMaxIndex[j][0]!=0){
            if(presentMaxIndex[j][0]==1){
                resultList[length-k] = nums1[presentMaxIndex[j][1]];
                findResult(nums1,nums2, k-1, presentMaxIndex[j][1]+1,nums2Pre);
            }else if(presentMaxIndex[j][0]==2){
                resultList[length-k] = nums2[presentMaxIndex[j][1]];
                findResult(nums1,nums2, k-1, nums1Pre,presentMaxIndex[j][1]+1);
            }
            j++;
        }
    }

    public static int[][] getPresentMaxIndex(int[] nums1, int[] nums2, int k,int nums1Pre,int nums2Pre){
        int max = -1;
        //nums1=1；nums2=2
        int[][] result = new int[nums1.length+nums2.length][2];
        int j = 0;
        int leng1 = nums1.length+nums2.length-nums2Pre;
        if(nums2Pre>nums2.length-1){
            leng1 = nums1.length;
        }
        for(int i=nums1.length-1;i>=nums1Pre;i--){
            if(nums1[i]>max&&(leng1-i)>=k){
                max = nums1[i];
            }
        }
        int leng2 = nums1.length+nums2.length-nums1Pre;
        if(nums1Pre>nums1.length-1){
            leng2 = nums2.length;
        }
        for(int i=nums2.length-1;i>=nums2Pre;i--){
            if(nums2[i]>max&&(leng2-i)>=k){
                max = nums2[i];
            }
        }
        for(int i=nums1.length-1;i>=nums1Pre;i--){
            if(nums1[i]==max&&(leng1-i)>=k){
                result[j][0] = 1;
                result[j][1] = i;
                j++;
            }
        }
        for(int i=nums2.length-1;i>=nums2Pre;i--){
            if(nums2[i]==max&&(leng2-i)>=k){
                result[j][0] = 2;
                result[j][1] = i;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums1 = {3,4,6,5};
//        int[] nums2 = {9,1,2,5,8,3};
//        int[] nums1 = {2,5,6,4,4,0};
//        int[] nums2 = {7,3,8,0,6,5,7,6,2};
//        int k =15;
        int[] nums1 = {6,7};
        int[] nums2 = {6,0,4};
        int k =5;
        int[] result = maxNumber(nums1,nums2,k );
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }


}
