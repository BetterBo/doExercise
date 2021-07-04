package java.meituan;

import java.util.Scanner;

/**
 * @ClassName exam2_210404
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2021/4/4 9:48
 * @Version 1.0
 */
public class exam2_210404 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int raw = in.nextInt();
        int t,x;
        int r=0;
        int l=0;
        int r1=0;
        int r2=0;
        int l1=0;
        int l2=0;
        while(raw>0){
            raw--;
            t = in.nextInt();
            x = in.nextInt();
            if(t==0){
                if(x<=90){
                    r1++;
                }else if(x>=270){
                    r2++;
                }else{
                    r++;
                }

            }else{
                if(x>=90&&x<=180){
                    l1++;
                }else if(x>=181&&x<=270){
                    l2++;
                }else{
                    l++;
                }
            }
        }

        System.out.print((1+r)*(1+l)+(1+r1)*(1+l)+(1+r2)*(1+l)+(1+r)*(1+l1)+(1+r)*(1+l2));
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int raw = in.nextInt();
//        int t,x;
//        int r=0;
//        int l=0;
//        while(raw>0){
//            raw--;
//            t = in.nextInt();
//            if(t==0){
//                r++;
//            }else{
//                l++;
//            }
//            x = in.nextInt();
//
//        }
//        System.out.print((1+r)*(1+l));
//
//    }
}
