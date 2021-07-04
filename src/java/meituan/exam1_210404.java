package java.meituan;

import java.util.Scanner;

/**
 * @ClassName exam1_210404
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2021/4/4 9:48
 * @Version 1.0
 */
public class exam1_210404 {
    public static Long calc(String str){
        int lenth = str.length();
        if(lenth<=1){
            return (long)lenth+1;
        }
        Long result = (long)lenth+1;
        for(int i=1;i<lenth;i++){
            for(int j=0;i<lenth;i++){

            }
        }

        return 0L;

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        Long retult = calc(str);

    }
}
