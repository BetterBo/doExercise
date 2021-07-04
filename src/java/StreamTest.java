package java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName StreamTest
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2020/12/24 16:45
 * @Version 1.0
 */
public class StreamTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("111");
        List<String> ipv4List = list.stream().filter(vswitch->!vswitch.equals(""))
                .map(vswitch->vswitch).distinct().collect(Collectors.toList());
        for (int i = 0; i < ipv4List.size(); i++) {
            System.out.println(ipv4List.get(i));
        }

    }
}
