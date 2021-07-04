package java;

import com.sun.deploy.util.ArrayUtil;
import com.sun.deploy.util.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName test
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2020/11/2 9:55
 * @Version 1.0
 */
public class test {

    public static void deletetest(Integer index) throws Exception{
        if(index==5||index==8){
            throw new Exception(index+":error");
        }

    }

    public static void opa(StringBuffer x,StringBuffer y){
        x.append(y);
        y=x;
    }

    public static void main(String[] args) throws IOException {
//        String s = "滴滴滴sss";
//        System.out.print(s);
//        System.out.println();
//        System.out.print("------------------------");
//        System.out.println();
//        System.out.print(s.getBytes());
//        System.out.println();
//        System.out.print("------------------------");
//        System.out.println();
//        BASE64Encoder encoder = new BASE64Encoder();
//        System.out.print(new String(new BASE64Decoder().decodeBuffer(
//                encoder.encodeBuffer(s.getBytes()).replaceAll("\r|\n",""))));
//        System.out.println();
//        System.out.print("------------------------");


        //Integer.MIN_VALUE;
//        System.out.println(Double.valueOf("1"));
//
//        System.out.println(org.apache.commons.lang3.StringUtils.isNumeric("111111"));
//        System.out.println(org.apache.commons.lang3.StringUtils.isNumeric("dfsadfasf"));
//        System.out.println(org.apache.commons.lang3.StringUtils.isNumeric("4fdff4sf"));
//        System.out.println(Double.valueOf("adfdsf"));
//        StringBuffer a = new StringBuffer("A");
//        StringBuffer b = new StringBuffer("B");
//        opa(a,b);
//        System.out.println(a+","+b);
//        List<Character> existLuns = new ArrayList<>();
//        existLuns.add('A');
//        existLuns.add('B');
//        existLuns.add('C');
//        existLuns.add('D');
//        existLuns.add('D');
//        existLuns.add('A');
//        List<Integer> existFcIds = existLuns.stream()
//                .map(entity -> entity-'A').distinct().collect(Collectors.toList());
//        System.out.println();
//        Double useRate = 1.2222222;
//        BigDecimal decimal = new BigDecimal(useRate);
//        System.out.print(decimal.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
//        Thread.sleep(1000);
//        Thread.interrupted();
//        int a=0x123;
//        System.out.print(a/2);
//        int[] a =new int[5];

//        PrintStream err = System.err;
//        System.out.print(err.checkError());
        List<Integer> existHostId = Arrays.asList(5,8,6,6,7,2);
        System.out.println(existHostId);
        existHostId = existHostId.stream().filter(hostId->hostId==2).collect(Collectors.toList());
        System.out.println(existHostId);
//        List<String> result = existHostId.parallelStream().distinct().map(hostid->{
//                    try{
//                        Thread.sleep(2000*hostid);
//                        System.out.println(hostid+":执行");
//                        deletetest(hostid);
//                        return "";
//                    }catch (Exception be){
//                        return be.getMessage();
//                    }
//                }
//        ).collect(Collectors.toList());
//        List<Integer> distinctList = existHostId.parallelStream().distinct().collect(Collectors.toList());
//        //将结果转换为List<StorageGeneralResult>
//        for(int i=0;i<distinctList.size();i++){
//            if(result.get(i).equals("")){
//                System.out.println(0);
//            }else{
//                System.out.println(1);
//            }
//            System.out.println(result.get(i));
//        }
//        System.out.println(existHostId);
//        System.out.println(distinctList);
//        System.out.println(result);
    }
}
