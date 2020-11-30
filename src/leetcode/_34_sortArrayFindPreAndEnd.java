package leetcode;

/**
 * @ClassName _34_sortArrayFindPreAndEnd
 * @Description 记得挪位置，33行和56行
 * @Author yangxiaobo
 * @Date 2020/11/25 22:51
 * @Version 1.0
 */
public class _34_sortArrayFindPreAndEnd {
    public static int[] searchRange(int[] nums, int target) {
        int result[] = new int[2];
        if(nums.length==0){
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        int p=0;
        int q=nums.length;
        int pmid = q/2;
        while(q!=p){
            if(nums[pmid]==target){
                if(pmid==0){
                    break;
                }else if(nums[pmid-1]!=target){
                    break;
                }
            }
            if(nums[pmid]>=target){
                q = pmid;
            }else{
                //TODO 务必记得加一挪一位，免得卡在p==q-1&&nums[pmid]<target不动
                p = pmid+1;
            }
            pmid = (p+q)/2;
        }
        if(pmid==nums.length||nums[pmid]!=target){
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        int qmid = q/2;
        p=0;
        q=nums.length;
        while(q!=p){
            if(nums[qmid]==target){
                if(qmid==nums.length-1){
                    break;
                }else if(nums[qmid+1]!=target){
                    break;
                }
            }
            if(nums[qmid]<=target){
                //TODO 务必记得加一挪一位，免得卡在p==q-1&&nums[qmid]<=target不动
                p = qmid+1;
            }else{
                q = qmid;
            }
            qmid = (p+q)/2;
        }
        result[0] = pmid;
        if(nums[qmid]==target){
            result[1] = qmid;
        }else{
            result[1] = qmid-1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] putin = {5,7,7,8,8,10};
        int[] result = searchRange(putin,6);
        System.out.println(result[0]+"---"+result[1]);
    }
}
