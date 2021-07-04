package java.CMB;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName exam210429_1
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2021/4/29 20:17
 * @Version 1.0
 */
public class exam210429_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] peo = new long[n];
        long[] car = new long[n];
        for(int i=0;i<n;i++){
            peo[i] = in.nextLong();
        }
        for(int i=0;i<n;i++){
            car[i] = in.nextLong();
        }
        Arrays.sort(peo);
        Arrays.sort(car);
        int index=0;
        long result = 1;
        for(int i=0;i<n;i++){
            while(index<n&&car[i]>=peo[index]){
                index++;
            }
            if(index<=i){
                System.out.println(0);
                return;
            }
            result *= index-i;
        }
        System.out.println(result%100000007);
    }
}
