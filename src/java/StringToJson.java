package java;

import jdk.nashorn.internal.parser.JSONParser;

/**
 * @ClassName StringToJson
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2021/3/24 14:51
 * @Version 1.0
 */
public class StringToJson {
    public static void main(String[] args) {
        String quote = JSONParser.quote("{\"hostId\":null,\"cpuReservePercent\":15,\"memReservePercent\":23," +
                "\"cpuOverCommit\":100,\"memOverCommit\":100,\"cpuReservePercentMsg\":\"success\",\"memReservePercentMsg\":\"success\"," +
                "\"cpuOverCommitMsg\":\"success\",\"memOverCommitMsg\":\"success\"}");
        System.out.println(quote);
    }
}
