package java.xiehceng;

import java.util.*;

/**
 * @ClassName exam210415_2
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2021/4/15 19:50
 * @Version 1.0
 */
public class exam210415_2 {
    public static class node{
        int val;
        node next;
        node last;
        boolean status = true;
        public node(int val){
            this.val = val;
        }
    }
    public static void influence(int key ,int val){
        if(map.get(val).status){
            map.get(val).status = false;
            if(putIn.contains(val)){
                set.add(val);
            }
            node node = map.get(val).next;
            while(node!=null&&map.get(node.val).status){
                if(putIn.contains(node.val)){
                    set.add(node.val);
                }
                influence(key ,node.val);
            }
        }
    }
    static HashMap<Integer,node> map = new HashMap<>();
    static HashSet<Integer> set = new HashSet<>();
    static HashSet<Integer> putIn = new HashSet<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String s;
        while(!((s = in.nextLine()).equals(""))){
            String[] arr = s.split(",");
            int key = Integer.parseInt(arr[0]);
            putIn.add(key);
            if(map.get(key)==null){
                node tem = new node(key);
                map.put(key,tem);
                map.get(key).last = tem;
            }
            for(int i=1;i<arr.length;i++){
                int val = Integer.parseInt(arr[i]);
                if(map.get(val)==null){
                    node tem = new node(val);
                    map.put(val,tem);
                    map.get(val).last = tem;
                }
                map.get(val).last.next = new node(key);
                map.get(val).last =  map.get(val).last.next;
            }
        }
        int count = 0;
        for(node t = map.get(n).next;t!=null;t = t.next){
            influence( n , t.val);
        }
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            count += iterator.next();
        }
        System.out.println(count);
    }
}
