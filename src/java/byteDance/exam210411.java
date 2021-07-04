package java.byteDance;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName exam210411
 * @Description
 * 两个字符串s，m
 * i代表s的前i个字符的子串
 * j代表m的前j个字符的子串
 * 查询两个子串组合之后有多少种不同的字符
 * 输入：
 * ab
 * ac
 * 3
 * 1 1
 * 1 2
 * 2 2
 * 输出
 * 1
 * 2
 * 3
 * @Author yangxiaobo
 * @Date 2021/4/11 19:16
 * @Version 1.0
 */
public class exam210411 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String m = in.nextLine();
        int t = in.nextInt();
        int[] asscii = new int[128];
        int[] assciiS = new int[128];
        int count = 0;
        int countS = 0;
        int[][] pd = new int[s.length()+1][m.length()+1];
        for(int i=0;i<s.length()+1;i++){
            if(i!=0&&assciiS[s.charAt(i-1)]==0){
                assciiS[s.charAt(i-1)] = 1;
                countS++;
            }
            for(int k=0;k<128;k++){
                asscii[k] = assciiS[k];
            }
            count = countS;
            for(int j=0;j<m.length()+1;j++){
                if(j!=0&&asscii[m.charAt(j-1)]==0){
                    asscii[m.charAt(j-1)] = 1;
                    count++;
                }
                pd[i][j] = count;
            }
        }
        while(t-->0){
            int x = in.nextInt();
            int y = in.nextInt();
            System.out.println(pd[x][y]);
        }
    }
}
