package java.leetcode;

import java.util.Random;

/**
 * @ClassName _470_Random7_Random10
 * @Description 使用random7表示random10
 * @Author yangxiaobo
 * @Date 2021/6/2 16:03
 * @Version 1.0
 */
public class _470_Random7_Random10 {
    public static int rand7() {
        return new Random().nextInt(7)+1;
    }

    public static int rand10() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += rand7();
        }
        if(sum>60){
            System.out.print(" "+sum);
        }

        return sum/7;
    }

    public static void main(String[] args) {
        System.out.println(new Random().nextInt(7)+1);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 1; j++) {
                System.out.println(new Random().nextInt(7)+1);
                //rand10();
            }
            //System.out.println();
        }

    }
}
