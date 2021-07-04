package java;

public class num3 {
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int sleng = s.length();
        int[] shortestSameNum = new int[sleng];
        int i,j;
        for(i = 0;i<sleng;i++){
            shortestSameNum[i] = -1;
            for(j = i+1;j<sleng;j++){
                if(s.charAt(i)==s.charAt(j)){
                    shortestSameNum[i] = j;
                    break;
                }
            }
            if(shortestSameNum[i]==-1){
                shortestSameNum[i] = sleng;
            }
        }
        int result = 0;
        int leng = 0;
        for(i=0;i<sleng;i++){
            leng = shortestSameNum[i] - i;
            for(j=i+1;j<i+leng;j++){
                if(shortestSameNum[j]<i+leng){
                    leng = shortestSameNum[j]-i;
                }
            }
            if(leng>result){
                result = leng;
            }
        }
        return result;
    }
}