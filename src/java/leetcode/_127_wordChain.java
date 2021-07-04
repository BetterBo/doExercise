package java.leetcode;

import java.util.*;

/**
 * @ClassName _127_wordChain
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2020/11/20 22:13
 * @Version 1.0
 */
public class _127_wordChain {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        List<Integer> flag = new ArrayList<Integer>();
        for(int i=0;i<wordList.size();i++){
            flag.add(0);
        }
        return find(beginWord,endWord,wordList,flag);
    }

    public static int find(String beginWord, String endWord, List<String> wordList,List<Integer> flag){
        if(endWord.equals(beginWord)){
            return 1;
        }
        int result = Integer.MAX_VALUE;
        boolean use = false;
        for(int i=0;i<wordList.size();i++){
            if(flag.get(i)==0&&cheakDistance(beginWord,wordList.get(i))==1){
                flag.set(i,1);
                int tem = 1+find(wordList.get(i), endWord, wordList,flag);
                if(tem>1){
                    use = true;
                    if(tem<result){
                        result = tem;
                    }
                }
                flag.set(i,0);
            }
        }
        if(!use){
            if(wordList.contains(beginWord)){
                flag.set(wordList.indexOf(beginWord),1);
            }
            result = 0;
        }
        return result;
    }

    public static int cheakDistance(String s1,String s2){
        int count = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String startWord = "qa";
        String endWord = "sq";
        List<String> wordList = Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb"
                ,"kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa"
                ,"yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh"
                ,"sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh"
                ,"co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an"
                ,"me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be"
                ,"fm","ta","tb","ni","mr","pa","he","lr","sq","ye") ;
//        String startWord = "hit";
//        String endWord = "cog";
//        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        int len = ladderLength(startWord,endWord,wordList);
        System.out.println(len);
    }
}
