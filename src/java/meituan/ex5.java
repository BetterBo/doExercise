package java.meituan;

import java.util.Scanner;

/**
 * @ClassName ex5
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2021/4/4 11:56
 * @Version 1.0
 */
public class ex5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[] a1 = new int[m];
        int[] a2 = new int[n];
        for(int i=0;i<m;i++){
            a1[i] = in.nextInt();
        }
        for(int j=0;j<n;j++){
            a2[j] = in.nextInt();
        }

        int sum = 0;
        int max = 0;

        for(int i=0;i<m;i++){
            sum += sum+a1[i];
            if(sum>max){
                max = sum;
            }
        }
        int sun1 = 0;
        int max2 = 0;
        for(int i=0;i<n;i++){
            sum += sum+a1[i];
            if(sum>max){
                max = sum;
            }
        }
    }
}
