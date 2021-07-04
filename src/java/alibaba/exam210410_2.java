package java.alibaba;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @ClassName exam210410_2
 * @Description
 * // 评测题目2：抢红包
 * // 抢红包算法，给定一个红包总金额(元)和分红包的人数，输出每个人随机抢到的红包金额。
 * // 无法按照要求分配的场景输出 error
 * // 要求：
 * // 1. 每个人都要抢到红包，并且金额随机
 * // 2. 每个人抢到的红包金额不小于1.00元
 * // 3. 每个人抢到的红包金额不超过红包总金额的30%
 * // 4. 每个人抢到的红包金额总和等于红包总金额
 * // 5. (额外加分) 每个人抢到的红包金额的期望相同，和顺序无关
 * // 6. (额外加分) 随机函数调用的次数尽可能少
 * // 样例1输入：100 10
 * // 样例1输出：19.72 19.54 14.98 1.04 24.98 14.46 1.95 1.28 1.00 1.05
 * // 样例2输入：10 3
 * // 样例2输出：error
 * @Author yangxiaobo
 * @Date 2021/4/10 19:04
 * @Version 1.0
 */
public class exam210410_2 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int sum = in.nextInt()*100;
            int people = in.nextInt();
            if(people<4||sum<people*100){
                System.out.println("error");
                continue;
            }
            //一人分一块需要写一下
            if(sum==people*100){
                for (int i = 0; i < people; i++) {
                    if(i==0){
                        System.out.print(1.00);
                    }else{
                        System.out.print(" "+1.00);
                    }
                }
                System.out.println();
                continue;
            }
            List<Integer> amountList = new LinkedList<>();
            int restA = sum-people*100;
            int restP = people;
            for (int i = 0; i < people-1; i++) {
                int amount;
                //保证分到[0.01,restA/restP*2)
                amount = random.nextInt(restA/restP*2-1)+1;
                //while(amount>Double.min(restA,sum*0.3)){
                while(amount+100>Double.min(restA+100,sum*0.3)
                    &&(restA-amount+100*(restP-1))/(restP-1)>0.3*sum){//加上最后的剩余判断，如果后面的不够了，也不可以
                    amount = random.nextInt(restA/restP*2-1)+1;
                }

                restA-=amount;
                restP--;
                amountList.add(amount+100);
            }
            amountList.add(restA+100);
            for (int i = 0; i < amountList.size(); i++) {
                if(i==0){
                    System.out.print(new BigDecimal(amountList.get(i)).divide(new BigDecimal(100)));
                }else{
                    System.out.print(" "+new BigDecimal(amountList.get(i)).divide(new BigDecimal(100)));
                }
            }
            System.out.println();
        }
    }
}
