package java.alibaba;

import java.util.Scanner;

/**
 * @ClassName exam210409_2
 * @Description
 * 输入n，表示【1,2，....，n】
 * 输入k，表示k次翻转
 * 每次翻转的起点和终点是非递减的
 * 输入：
 * 5 3
 * 1 3
 * 2 4
 * 2 5
 * 输出：
 * 3 5 2 1 4
 * @Author yangxiaobo
 * @Date 2021/4/9 18:43
 * @Version 1.0
 */
public class exam210409_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i+1;
        }
        int tem=0;
        int l,r;
        for(int i=0;i<k;i++){
            l = in.nextInt()-1;
            r = in.nextInt()-1;
            while(l<r){
                tem = a[r];
                a[r] = a[l];
                a[l] = tem;
                l++;
                r--;
            }
        }
        if(k>1){
            System.out.print(a[0]);
        }
        for(int i=1;i<k;i++){
            System.out.print(" "+a[i]);
        }

    }
}
