package java.ABC;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName exam210604_01
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2021/6/4 15:10
 * @Version 1.0
 */
public class exam210604_01 {

    public static class node{
        String str;
        Double val;

    }

    static Comparator<node> cmp = new Comparator<node>() {
        @Override
        public int compare(node e1, node e2) {
            if(Double.doubleToLongBits(e1.val)!=Double.doubleToLongBits(e2.val)){
                return (Double.doubleToLongBits(e1.val) < Double.doubleToLongBits(e2.val)) ? 1 :
                        ((Double.doubleToLongBits(e1.val) == Double.doubleToLongBits(e2.val)) ? 0 : -1);
            }
            return -e1.str.compareTo(e2.str);

        }
    };

    public static String[] calc(String[] inp){
        if(inp.length==0){
            return new String[]{};
        }
        String[] result = new String[inp.length];

        PriorityQueue<node> que = new PriorityQueue(cmp);

        for(int i=0;i<inp.length;i++){
            node no = new node();
            no.str = inp[i];
            int letterSum = 0;
            int numSum = 0;
            for(int j=0;j<inp[i].length();j++){
                if(no.str.charAt(j)<'0'||no.str.charAt(j)>'9'){
                    letterSum++;
                }else{
                    numSum++;
                }
            }
            no.val = letterSum*1.0/numSum;
            que.add(no);
        }
        for(int i=0;i<result.length;i++){
            result[i] = que.poll().str;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] inp = new String[]{"abc123","abc+1234","ababab--i"};
        String[] calc = calc(inp);
        for(int i=0;i<calc.length;i++){
            System.out.println(calc[i]);
        }
    }


}
