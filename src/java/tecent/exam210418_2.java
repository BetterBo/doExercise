package java.tecent;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @ClassName exam210418_2
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2021/4/18 20:00
 * @Version 1.0
 */
public class exam210418_2 {
    static class node{
        int ind;
        int time;
        node(int ind,int time){
            this.ind = ind;
            this.time = time;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        PriorityQueue<node> nodeList = new PriorityQueue<node>(k,(l1,l2)->{
            if(l1.time==l2.time){
                return l1.ind-l2.ind;
            }
            return l1.time-l2.time;
        });
        for(int j=1;j<=n;j++){
            int t = in.nextInt();
            for(int i=1;i<=k;i++){
                node tem = new node(j,t*i);
                nodeList.add(tem);
            }
        }
        for(int j=0;j<k;j++){
            System.out.println(nodeList.remove().ind);
        }
    }
}
