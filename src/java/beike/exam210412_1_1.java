package java.beike;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName exam210412_1_1
 * @Description 大数吃小数，吃了吸收它的体积，直到吃完为止，放在一个数组里面，只能挨着吃
 * 弄一个DP数组，放当前i下标的数字能不能吃完所有
 * 输入：
 * 4
 * 6 6 2 3
 * 输出：
 * 2
 * 输入：
 * 7
 * 3 5 7 1 3 7 1
 * 输出：【5 7 7】
 * 3
 * @Author yangxiaobo
 * @Date 2021/4/12 22:15
 * @Version 1.0
 */
public class exam210412_1_1 {
        public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] size = new long[n];
        long max = -1;
        int idx = -1;
        int count = 0;
        for(int i = 0;i<n;i++){
            size[i] = in.nextLong();
            if(size[i]>max){
                max = size[i];
                idx = i;
            }
        }
        int[] dp = new int[n];
        dp[idx] = 1;
        for(int i = 0;i<n;i++){
            int l = i-1;
            int r = i+1;
            long bulk = size[i];
            boolean flag = false;
            boolean lflag = true;
            boolean rflag = true;
            while(!flag&&(lflag||rflag)){
                while(l>=0&&bulk>=size[l]){
                    if(dp[l]==1){
                        flag = true;
                        count++;
                        dp[i] = 1;
                        break;
                    }
                    bulk+=size[l--];
                }
                while(!flag&&r<n&&bulk>=size[r]){
                    if(dp[r]==1){
                        flag = true;
                        count++;
                        dp[i] = 1;
                        break;
                    }
                    bulk+=size[r++];
                }
                lflag = false;
                rflag = false;
                if(l>=0&&bulk>=size[l]){
                    lflag = true;
                }
                if(r<n&&bulk>=size[r]){
                    rflag = true;
                }
                if(l<0&&r>=n){
                    count++;
                    dp[i] = 1;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
