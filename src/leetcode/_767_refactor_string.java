package leetcode;

/**
 * @ClassName _767_refactor_string
 * @Description letterCount保存26字母的出现次数
 * S奇数，不能出现大于半数+1
 * S偶数，不能出现大于半数
 * 最后拼接字符串，每次选出除上次字符的其他字符中最多的字符进行拼接
 * @Author yangxiaobo
 * @Date 2020/11/30 21:43
 * @Version 1.0
 */
public class _767_refactor_string {
    static int[] letterCount = new int[26];
    public static String reorganizeString(String S) {
        if(S.equals("")){
            return "";
        }
        for(int i=0;i<S.length();i++){
            int temp = S.charAt(i)-'a';
            letterCount[temp]++;
            if((S.length()%2==1&&letterCount[temp]>(1+S.length()/2))
                    ||(S.length()%2==0&&letterCount[temp]>S.length()/2)){
                return "";
            }
        }
        char[] result = new char[S.length()];
        int maxCount = getMaxCountExceptA(-1);
        int pre = maxCount;
        letterCount[maxCount]--;
        result[0] = (char)(maxCount+'a');
        for(int i=1;i<S.length();i++){
            pre = getMaxCountExceptA(pre);
            result[i] = (char)(pre+'a');
            letterCount[pre]--;
        }
        return String.valueOf(result);
    }

    /**
     * 获取除A字符外最长的字母的index
     * @date 2020/11/30 21:54
    */
    static int getMaxCountExceptA(int A){
        int max = 0;
        int index = 0;
        for(int i=0;i<letterCount.length;i++){
            if(letterCount[i]>max&&(A!=i)){
                max = letterCount[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
    }
}
