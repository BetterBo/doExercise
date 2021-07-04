package java.leetcode.weekGame._210413;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName _2
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2021/4/13 21:57
 * @Version 1.0
 */
public class _2 {
    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(i+1);
        }
        int index = k;
        while(arr.size()!=1){
            arr.remove(index-1);
            if(arr.size()!=1){
                if((index+k-1)==arr.size()){
                    index = (index+k-1);
                }else{
                    index = (index+k-1)%arr.size();
                }
            }
        }
        System.out.println(arr.get(0));
    }
}
