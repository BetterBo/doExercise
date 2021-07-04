package java.guanglianda;

import java.util.*;

/**
 * @ClassName exam210414_2
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2021/4/14 18:53
 * @Version 1.0
 */
public class exam210414_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int length = 1<<n;
        int m = in.nextInt();
        int[] arr = new int[length];
        for(int i=0;i<length;i++){
            arr[i] = i+1;
        }
        while (m-->0){
            int t = in.nextInt();
            int power = 1<<t;
            int tem;
            for(int i = 0;i<length;i+=power){
                int l = i;
                int r = i+power-1;
                while(l<r){
                    tem = arr[l];
                    arr[l] = arr[r];
                    arr[r] = tem;
                    l++;
                    r--;
                }
            }
            int result=0;
            for(int i=0;i<length;i++){
                for(int j=i+1;j<length;j++){
                    if(arr[i]>arr[j]) {
                        result++;
                    }
                }
            }
            if(m==0){
                System.out.print(result);
            }else{
                System.out.println(result);
            }
        }
    }
}
