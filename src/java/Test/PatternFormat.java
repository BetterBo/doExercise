package java.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName PatternFormat
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2020/12/15 15:44
 * @Version 1.0
 */
public class PatternFormat {

    /**
     * 挂载点的正则表达式预编译
     * 字母开头，包含字母、数字、下划线，长度为1-128
     */
    public final static Pattern PATTERN_MOUNT_POINT = Pattern.compile("^[a-zA-Z]\\w{0,127}$");

    /**
     * OCFS2的名称的正则表达式预编译,数据库中长度为64，正文是最大长度为48
     */
    public final static Pattern PATTERN_NAME = Pattern.compile("^[a-zA-Z\\u4e00-\\u9fa5][a-zA-Z0-9_\\u4e00-\\u9fa5]{0,47}$");

    /**
     * 卷名的正则表达式预编译
     * 字母开头，包含字母、数字、下划线，长度为1-256
     */
    public final static Pattern PATTERN_VOLUME_NAME = Pattern.compile("^[a-zA-Z]\\w{0,255}$");

    public final static Pattern PATTERN_VOLUME_PATH = Pattern.compile("\\/([\\w\\.]+\\/)+[^.]+\\.[a-zA-Z]+");

    public final static Pattern PATTERN_POOL_PATH = Pattern.compile("^\\/(\\w+\\/?)+$");


    public final static Pattern PATTERN_VOLUME_PATH_TEST = Pattern.compile(".*(/bin/|/home/)(\\w+(?:\\.\\w+)+|(\\w+/))+");
    /**
     * 存储适配器正则表达式
     * iqn.开头，后跟年月日期yyyy-mm，后可包含[ 字母  数字  -  :  . ]，总长度为1-128
     *      iqn.2001-04.com.example:storage:diskarrays-sn-a8675309
     *      iqn.2001-04.com.example
     *      iqn.2001-04.com.example:storage.tape1.sys1.xyz
     *      iqn.2001-04.com.example:storage.disk2.sys1.xyz
     */
    public final static Pattern PATTERN_ISCSI_INITIAL_NAME = Pattern.compile("^iqn\\.\\d{4}\\-(?:0[1-9]|1[0-2])(\\.[A-Za-z0-9]+)+([\\-\\:\\.][0-9a-zA-z]+)*$");
    public final static Pattern PATTERN_ISCSI_INITIAL_NAME_LENGTH = Pattern.compile("^.{1,128}$");


    /**
     * 检查是否是正确的格式
     * @param inputStr
     * @return boolean
     * @author yangxiaobo
     * @date 2020/10/22 16:27
     */
    public static boolean isCorrectFormat(Pattern pattern,String inputStr) {
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.matches();
    }
    public static void main(String[] args) {
//        String s1 = "/home/.wwwrooT/a.txt";
//        String s2 = "/home/a.java";
//        String s3 = "/home/d-1";
//        String s4 = "/home/wwwrooT/a.";
//        System.out.println(isCorrectFormat(PATTERN_VOLUME_PATH_TEST,s1));
//        System.out.println(isCorrectFormat(PATTERN_VOLUME_PATH_TEST,s2));
//        System.out.println(isCorrectFormat(PATTERN_VOLUME_PATH_TEST,s3));
//        System.out.println(isCorrectFormat(PATTERN_VOLUME_PATH_TEST,s4));

        String s1 = "iqn.2001-04.com.example:storage:diskarrays-sn-a8675309";
        String s2 = "iqn.2001-04.com.example";
        String s3 = "iqn.2001-04.com.example:storage.tape1.sys1.xyz";
        String s4 = ".";
        System.out.println(isCorrectFormat(PATTERN_ISCSI_INITIAL_NAME,s1));
        System.out.println(isCorrectFormat(PATTERN_ISCSI_INITIAL_NAME,s2));
        System.out.println(isCorrectFormat(PATTERN_ISCSI_INITIAL_NAME,s3));
        System.out.println(isCorrectFormat(PATTERN_ISCSI_INITIAL_NAME,s4));
        System.out.println(isCorrectFormat(PATTERN_ISCSI_INITIAL_NAME_LENGTH,s1));
        System.out.println(isCorrectFormat(PATTERN_ISCSI_INITIAL_NAME_LENGTH,s2));
        System.out.println(isCorrectFormat(PATTERN_ISCSI_INITIAL_NAME_LENGTH,s3));
        System.out.println(isCorrectFormat(PATTERN_ISCSI_INITIAL_NAME_LENGTH,s4));


    }
}
