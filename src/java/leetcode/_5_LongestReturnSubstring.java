package java.leetcode;

/**
 * @ClassName _5_LongestReturnSubstring
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2021/4/4 17:09
 * @Version 1.0
 */
public class _5_LongestReturnSubstring {

    public String longestPalindrome(String s){

        int[][] status = new int[s.length()][s.length()];
        if(s.length()<=0){
            return "";
        }else if(s.length()==1){
            return s;
        }
        int maxIndex = 0;
        int maxResult = 1;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                if(j==0){
                    status[i][j] = 1;
                    continue;
                }
                if(i-1-status[i][j-1]<0){
                    status[i][j] = 1;
                }
                if(s.charAt(i-1-status[i-1][j])==s.charAt(i)){
                    status[i][j] = status[i-1][j]+2;
                }else if(s.charAt(i-1)==s.charAt(i)){
                    status[i][j] = 2;
                }else{
                    status[i][j] = 1;
                }
                if(status[i][j]>maxResult){
                    maxResult = status[i][j];
                    maxIndex = i;
                }
            }

        }

        return s.substring(maxIndex-maxResult+1,maxIndex+1);
    }
    public static void main(String[] args) {

    }
}
