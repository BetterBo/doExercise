package java.Test;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DefineMyselfClass
 * @Description 测试类中存在自己类
 * @Author yangxiaobo
 * @Date 2020/11/9 22:04
 * @Version 1.0
 */
public class DefineMyselfClass {
    //private DefineMyselfClass defineMyselfClass = new DefineMyselfClass(5);

    public DefineMyselfClass(int index){
        System.out.println(index);
    }

    public static void main(String[] args) {
        //DefineMyselfClass defineMyselfClass = new DefineMyselfClass(1);
        //Map<Integer,String> map = new HashMap<>();
        //map.put(1,"ddd");
        System.out.println(getNetFileSizeDescription("155555555555555555555"));

    }
    public static String getNetFileSizeDescription(String input) {
        double size = Double.parseDouble(input);
        System.out.println(size);
        StringBuffer bytes = new StringBuffer();
        DecimalFormat format = new DecimalFormat("###.0");
        if (size < 1024) {
            if (size <= 0) {
                bytes.append("0B");
            }
            else {
                bytes.append((int) size).append("B");
            }
            return bytes.toString();
        }
        size = size/1024.0;
        if (size < 1024) {
            bytes.append(format.format(size)).append("KB");
            return bytes.toString();
        }
        size = size/1024.0;
        if (size < 1024) {
            bytes.append(format.format(size)).append("MB");
            return bytes.toString();
        }
        size = size/1024.0;
        if (size < 1024) {
            bytes.append(format.format(size)).append("GB");
            return bytes.toString();
        }
        size = size/1024.0;
        if (size < 1024) {
            bytes.append(format.format(size)).append("TB");
            return bytes.toString();
        }
        size = size/1024.0;
        bytes.append(format.format(size)).append("PB");
        return bytes.toString();
    }
}
