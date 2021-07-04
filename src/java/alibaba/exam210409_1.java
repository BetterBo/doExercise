package java.alibaba;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @ClassName exam210409_1
 * @Description n个学生，排队取餐，第i个学生在L[i]到，同一时间到的编号小的排前面
 * 每个时刻不为空就会取餐，如果第i个学生R[i]拿不到就会离开，输出每个学生取餐的时间，拿不到为0
 * 输入
 * 2
 * 2
 * 1 3
 * 1 4
 * 3
 * 1 5
 * 1 1
 * 2 3
 * 输出
 * 1 2
 * 1 0 2
 * @Author yangxiaobo
 * @Date 2021/4/9 18:43
 * @Version 1.0
 */
public class exam210409_1 {
    public static class lunch{
        int idx;
        int arrive;
        int expect;
        lunch(int idx,int arrive,int expect){
            this.idx = idx;
            this.arrive = arrive;
            this.expect = expect;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while((t--)>0){
            int n = in.nextInt();
            PriorityQueue<lunch> waitQueue = new PriorityQueue<lunch>(n,(l1,l2)->{
                // l1-l2表示升序
                // l2-l1表示降序
                if(l1.arrive==l2.arrive){
                    return l1.idx-l2.idx;
                }
                return l1.arrive-l2.arrive;
            });
            for(int i=0;i<n;i++){
                int L = in.nextInt();
                int R = in.nextInt();
                waitQueue.offer(new lunch(i,L,R));
            }
            int time = -1;
            while(!waitQueue.isEmpty()){
                lunch lun = waitQueue.poll();
                if(time<=lun.arrive){
                    time = lun.arrive;
                }
                if(lun.expect>=time){
                    System.out.print(time+" ");
                    time++;
                }else {
                    System.out.print(0+" ");
                }
            }
            System.out.println();

        }
    }
}
