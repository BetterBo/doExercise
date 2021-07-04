package java.mogen;

/**
 * @ClassName exam1_210405
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2021/4/5 10:30
 * @Version 1.0
 */
public class exam1_210405 {

    public static int sort(int[] arr){
        if(arr.length==0){
            return 0;
        }
        int i=0;
        int j=arr.length-1;
        int count = 0;
        while(i<j){
            while(j>i&&arr[j]%2==1){
                j--;
            }
            while(j>i&&arr[i]%2==0){
                i++;
            }
            if(j>i){
                count++;
                j--;
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {6,3,4,5,4,4};
        System.out.print(sort(arr));
    }
}
