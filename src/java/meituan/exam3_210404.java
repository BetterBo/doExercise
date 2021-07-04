package java.meituan;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName exam3_210404
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2021/4/4 9:48
 * @Version 1.0
 */
public class exam3_210404 {
    static class side{
        public int i;
        public int j;

        public side(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static HashMap<Integer, List<side>> map = new HashMap<>();


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int k = in.nextInt();
        for(int i=1;i<k+1;i++){
            map.put(i,new LinkedList<>());
        }
        int tem;
        for(int i=0;i<r;i++){
            for(int j=0;j<r;j++){
                tem = in.nextInt();
                map.get(tem).add(new side(i,j));
            }
        }
        if(k<=1){
            List<side> indexSide = map.get(k);
            if(indexSide.size()==0){
                System.out.print(-1);
                return;
            }else {
                System.out.print(0);
                return;
            }
        }
        int disAll = 0;
        for(int i=0;i<k-1;i++){
            List<side> indexSide = map.get(k-i);
            if(indexSide.size()==0){
                System.out.print(-1);
                return;
            }
            List<side> preSide = map.get(k-i-1);
            if(preSide.size()==0){
                System.out.print(-1);
                return;
            }
            int thisResult = Integer.MAX_VALUE;
            for(int j=0;j<indexSide.size();j++){
                int dis = 0;
                for(int l=0;l<preSide.size();l++){
                    dis = Math.abs(indexSide.get(j).i - preSide.get(l).i) + Math.abs(indexSide.get(j).j - preSide.get(l).j);
                    if(dis<thisResult){
                        thisResult = dis;
                    }
                }
            }
            if(thisResult!=Integer.MAX_VALUE){
                disAll += thisResult;
            }else{
                System.out.print(-1);
                return;
            }
        }
        System.out.print(disAll);
    }
}
