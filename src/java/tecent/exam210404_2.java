package java.tecent;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName exam210404_2
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2021/4/4 19:51
 * @Version 1.0
 */
public class exam210404_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        in.nextLine();
        List<Short> list = new LinkedList<>();
        String str = in.nextLine();
        short i1;
        int lll = 0;
        for (int i = 0; i < str.length(); i++) {
            i1 = (short) (str.charAt(i) - '0');
            list.add(i1);
            lll++;
            if(lll-2>=0&&list.get(lll-2)+list.get(lll-1)==10){
                list.remove(lll-2);
                list.remove(lll-2);
                lll -=2;
            }
        }
        boolean flag = true;
        while(flag){
            int size = list.size();
            for (int i = 0; i < list.size()-1; ) {
                if(list.get(i)+list.get(i+1)==10){
                    list.remove(i);
                    list.remove(i);
                    while(i-1>=0&&i < list.size()&&list.get(i)+list.get(i-1)==10){
                        list.remove(i-1);
                        list.remove(i-1);
                        i = i-1;
                    }
                }else{
                    i++;
                }
            }
            if(size==list.size()){
                break;
            }
        }
        System.out.print(list.size());
    }
}
