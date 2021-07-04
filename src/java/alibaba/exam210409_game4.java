package java.alibaba;

import java.util.Scanner;

/**
 * @ClassName exam210409_game4
 * @Description 输入数字n
 * cOne,cFive,cTen,cTwe代表一块、五块、十块、二十五块的分别个数
 * 输入result表示能有多少种凑法
 * @Author yangxiaobo
 * @Date 2021/4/9 19:54
 * @Version 1.0
 */
public class exam210409_game4 {
    public static void main(String[] args) {
        int q,n;
        int cOne,cFive,cTen,cTwe;
        Scanner in = new Scanner(System.in);
        q = in.nextInt();
        while((q--)>=0){
            n = in.nextInt();
            cOne = in.nextInt();
            cFive = in.nextInt();
            cTen = in.nextInt();
            cTwe = in.nextInt();
            int temN = n;
            int retult = 0;
            int twe = Math.min(cTwe,temN/25);
            for(int i=0;i<=twe;i++){
                if(25*i==temN){
                    retult++;
                    continue;
                }
                temN -= 25*i;
                int ten = Math.min(cTen,temN/10);
                for(int j=0;j<=ten;j++){
                    if(10*j==temN){
                        retult++;
                        continue;
                    }
                    temN -= 10*j;
                    int five = Math.min(cFive,temN/5);
                    for(int k=0;k<=five;k++){
                        if(5*k==temN){
                            retult++;
                            continue;
                        }
                        temN -= 5*k;
                        if(temN<=cOne){
                            retult++;
                        }
                        temN += 5*k;
                    }
                    temN += 10*j;
                }
                temN += 25*i;
            }
            System.out.println(retult);
        }
    }
}
