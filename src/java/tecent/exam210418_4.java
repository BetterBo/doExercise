package java.tecent;

import java.util.Scanner;

/**
 * @ClassName exam210418_4
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2021/4/18 20:00
 * @Version 1.0
 */
public class exam210418_4 {
    static String s1;
    static String s2;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        while(t-->0){
            s1 = in.nextLine();
            s2 = in.nextLine();
            if(calc(0,s1.length()-1,0,s1.length()-1)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
    public static boolean calc(int l,int r,int l2,int r2){
        if((l+r)%2==0){
            for(int i=l,j=l2;i<=r;i++,j++){
                if(s1.charAt(i)!=s2.charAt(j)){
                    return false;
                }
            }
            return true;
        }else{
            if(l==r-1){
                if(s1.charAt(l)==s2.charAt(r2)&&s1.charAt(r)==s2.charAt(l2)||s1.charAt(l)==s2.charAt(l2)&&s1.charAt(r)==s2.charAt(r2)){
                    return true;
                }else{
                    return false;
                }
            }
            int mid = (l+r)/2;
            if(calc(l,mid,l,mid)&&calc(mid+1,r,mid+1,r)||calc(l,mid,mid+1,r)&&calc(mid+1,r,l,mid)){
                return true;
            }else{
                return false;
            }
        }
    }
}
