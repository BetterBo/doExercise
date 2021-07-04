package java.beike;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName exam210412_1
 * @Description 大数吃小数，吃了吸收它的体积，直到吃完为止，放在一个桶里面，可以跳着随便吃
 * 输入：
 * 4
 * 6 6 2 3
 * 输出：
 * 2
 * 输入：
 * 7
 * 3 5 7 1 3 7 1
 * 输出：【3 3 5 7 7】
 * 5
 * @Author yangxiaobo
 * @Date 2021/4/12 20:50
 * @Version 1.0
 */
public class exam210412_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] size = new long[n];
        for(int i = 0;i<n;i++){
            size[i] = in.nextLong();
        }
        Arrays.sort(size);
        long count = 0;
        long cc = 0;
        for(int i = 0;i<n;i++){
            int r = i+1;
            cc+=size[i];
            long bulk = cc;
            while(r<n&&bulk>=size[r]){
                bulk+=size[r++];
            }
            if(r>=n){
                count = n-i;
                break;
            }
        }
        System.out.println(count);
    }

}
