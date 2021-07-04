package java;

import sun.misc.Unsafe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName StringTest
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2020/12/4 14:50
 * @Version 1.0
 */
public class StringTest {

    public static void main(String[] args) {
//        String str = "ffffggghhh";
//        String storagePath = "/fdfsfg";
//        String volumePath = "/tetst/tsttttttt";
//        System.out.println(str.lastIndexOf("/"));
//        System.out.println(storagePath.lastIndexOf("/"));
//        System.out.println(volumePath.lastIndexOf("/"));
//        System.out.println(volumePath.substring(0,volumePath.lastIndexOf("/")));
//        ClassLoader.getSystemClassLoader();
//        Integer in1 = 1;
//        Integer in2 = 2;
//        Integer in3 = 1;
//        System.out.println(in1.equals(in2));
//        System.out.println(in1==in3);
//        System.out.println(in1.equals(in3));
        Double capacity = 94.987;
        Double result = capacity*Math.pow(1024,3-1);
//        System.out.println(result);
        capacity = 100.1;
        Double result2 = capacity*Math.pow(1024,3-1);
        //查看类库内容
        StringBuffer t;
        HashMap<Integer,String> map;
        ConcurrentHashMap<Integer,String> concurrentHashMap;
        Iterator i;
        //Integer.MAX_VALUE;
        ListIterator ii;
        ArrayList<String> strList1;
        Collections collections;
        Thread thread;
        Runnable runnable;
        //ThreadLocal<T> sThreadLocal;
        AbstractQueuedSynchronizer aqs;
        LinkedBlockingQueue linkedBlockingQueue;
        Unsafe unsafe;
        List<Father> fathers = new ArrayList<>();
        ReentrantLock reentrantLock;
        AtomicInteger firstJobDone = new AtomicInteger(0);
        firstJobDone.incrementAndGet();
        fathers.add(new Father());
        fathers.add(new son());
        List<String> strList = Arrays.asList(new String[] { "a", "c", "b" });
        strList.stream().sorted((s1, s2) -> s1.compareToIgnoreCase(s2)).forEach(s -> System.out.println(s));

//        System.out.println(result2);
//        System.out.println(result2>10000000L);
        String DEFAULT_PREFIX_POOL_PATH_IN_LUN = "/dev/disk/by-id";

        String DEFAULT_PREFIX_LUN_PATH = DEFAULT_PREFIX_POOL_PATH_IN_LUN+"/dm-name-";

        String dd = "/dev/disk/by-id/dm-name-fdfsfsdfsff";

//        System.out.println(dd.substring(DEFAULT_PREFIX_LUN_PATH.length()));
//
//        System.out.println(""+dd.substring(0,1));

        String ip = "100.100.10.140";
        String ip2 = "100.100.10.0";
        String addr1Rev=convert2CompleteIpV4(ip);
        String addr2Rev=convert2CompleteIpV4(ip2);
        int perfix = 25;
        System.out.println(addr1Rev.substring(0, perfix).equals(addr2Rev.substring(0, perfix)));
    }

    /**
     * 转换成完全的ipv4地址
     * @param addr
     * @return java.lang.String
     * @author wx
     * @date 2020/11/3 18:22
     **/
    private static String convert2CompleteIpV4(String addr){
        String[] split = addr.split("\\.");
        String temp= String.valueOf((Long.parseLong(split[0])<<24|Long.parseLong(split[1])<<16
                |Long.parseLong(split[2])<<8|Long.parseLong(split[3])));

        String binary = Long.toBinaryString(Long.parseLong(temp));
        StringBuffer sBuffer = new StringBuffer(binary);
        for(int i=sBuffer.length();i<32;i++){
            sBuffer.insert(0,'0');
        }
        return sBuffer.toString();
    }
}
