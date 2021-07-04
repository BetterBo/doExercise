package java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName testStream
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2021/3/9 20:37
 * @Version 1.0
 */
public class testStream {
    public static void main(String[] args) {
        List<Integer> hostids = new ArrayList<>();
        hostids.add(20);
        hostids.add(5);
        hostids.stream().distinct().map(hostid->{
                    try{
                        Thread.sleep(hostid*10000);
                        System.out.println(hostid);
                        return "";
                    }catch (Exception be){
                        return be.getMessage();
                    }
                }
        ).collect(Collectors.toList());
    }


}
