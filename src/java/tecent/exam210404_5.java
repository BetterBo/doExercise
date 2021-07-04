package java.tecent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName exam210404_5
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2021/4/4 19:51
 * @Version 1.0
 */
public class exam210404_5 {

    public static Integer result = Integer.MAX_VALUE;

    public static void cal2(int[] arr,int ind,List<Integer> pa,int sum,int n){
        if(sum!=0&&sum%n==0){
            result = Math.min(result,pa.size());
        }

        for (int i = ind; i < arr.length; i++) {
            if(i<ind && arr[i]==arr[i-1]){
                continue;
            }
            pa.add(arr[i]);
            sum+=arr[i];
            cal2(arr,i+1,pa,sum,n);
            sum-=arr[i];
            pa.remove(pa.size()-1);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            result = Integer.MAX_VALUE;
            int x = in.nextInt();
            int y = in.nextInt();
            int[] arr = new int[x];
            for (int i1 = 0; i1 < x; i1++) {
                arr[i1] = in.nextInt();
            }
            List<Integer> pa = new ArrayList<>();
            Arrays.sort(arr);
            cal2(arr,0,pa,0,y);
            int re = result==Integer.MAX_VALUE?-1:result;
            System.out.println(re);
        }
    }
}
