package java.tecent;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName exam210418_1
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2021/4/18 20:00
 * @Version 1.0
 */
public class exam210418_1 {
    public class ListNode {
    int val;
    ListNode next = null;
  }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param S ListNode类 val表示权值，next指向下一个元素
     * @return ListNode类
     */
    public ListNode solve (ListNode S) {
        // write code here
        List<ListNode> minList = new LinkedList<>();
        List<Integer> minIndex = new LinkedList<>();
        if(S==null){
            return S;
        }
        int minValue = Integer.MAX_VALUE;
        int length = 0;
        for(ListNode i = S;i!=null;i=i.next){
            if(minValue>i.val){
                minValue = i.val;
            }
            length++;
        }
        int indexTem = 0;
        ListNode last = S;
        for(ListNode i = S;i!=null;i=i.next,indexTem++){
            if(minValue==i.val){
                minList.add(i);
                minIndex.add(indexTem);
            }
            if(last.next!=null){
                last = last.next;
            }
        }
        int count = 1;
        while(count<length){
            if(minList.size()==1){
                break;
            }
            minValue = Integer.MAX_VALUE;
            for(int i=0;i<minList.size();i++){
                if(minList.get(i).next==null){
                    minList.set(i,S);
                }else{
                    minList.set(i,minList.get(i).next);
                }
                if(minValue>minList.get(i).val){
                    minValue = minList.get(i).val;
                }
            }
            for(int i=0;i<minList.size();){
                if(minValue<minList.get(i).val){
                    minList.remove(i);
                    minIndex.remove(i);
                }else{
                    i++;
                }
            }
        }
        ListNode tem = S;
        for(int i=0;i<minIndex.get(0);i++){
            ListNode tt = tem.next;
            tem.next = null;
            last.next = tem;
            last = tem;
            tem = tt;
            S = tt;
        }
        return S;
    }

}

