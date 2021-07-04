package java.CMB;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName exam210429_2
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2021/4/29 21:17
 * @Version 1.0
 */
public class exam210429_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] peo = new int[n];
        for(int i=0;i<n;i++){
            peo[i] = in.nextInt();
        }
        Arrays.sort(peo);
        int max1 = 1;
        int max2 = 1;
        int index=1;
        while(index<n){
            int count = 1;
            while(index<n&&peo[index]-peo[index-1]<=k){
                count++;
                index++;
            }
            if(count==1){
                index++;
                continue;
            }
            if(count==n){
                System.out.println(n);
                return;
            }
            if(count>max1){
                max2=max1;
                max1=count;
            }else if(count>max2){
                max2=count;
            }
        }
        System.out.println(max1+max2);
    }
}
