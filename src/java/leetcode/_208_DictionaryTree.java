package java.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName _208_DictionaryTree
 * @Description 字典树
 * 设置Map<Character,_208_DictionaryTree>保存当前节点的26个字母数
 * int[] leaf保存当前是否有单词最后一个字母停在此处，若有则设置为1，默认为0
 * 敏感词查询：可通过建立敏感词字典树，然后匹配输入字符串是否存在敏感词
 * @Author yangxiaobo
 * @Date 2020/11/9 23:15
 * @Version 1.0
 */
public class _208_DictionaryTree {
    public Map<Character,_208_DictionaryTree> trie = new HashMap<>();
    private int[] leaf = new int[26];
    /** Initialize your data structure here. */
    public _208_DictionaryTree() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word==null||word.equals("")){
            return;
        }
        //若word不为空，且当前第一个字母对应的map的key为空，则new一个实体进入trie
        if(trie.get(word.charAt(0))==null){
            trie.put(word.charAt(0),new _208_DictionaryTree());
        }
        //若word不为空，且当前第一个字母对应的map的key不为空，则将后面的字符串插入子节点的trie中
        if(word.length()>1){
            trie.get(word.charAt(0)).insert(word.substring(1));
        }else{
            //如果是最后一个节点，则将leaf设置为1，表明存在字母停在此处
            leaf[word.charAt(0)-'a'] = 1;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word==null||word.equals("")){ return false;}
        //如果当前map有数据且word长为1且leaf为1，则找到word
        if(trie.get(word.charAt(0))!=null
                &&word.length()==1&&leaf[word.charAt(0)-'a']==1){
            return true;
        }else if(trie.get(word.charAt(0))!=null
                &&word.length()>1){
            //如果当前map有数据且word长大于1，则往下找word
            return trie.get(word.charAt(0)).search(word.substring(1));
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix==null||prefix.equals("")){ return false;}
        //如果当前map有数据且prefix长为1，则找到前缀
        if(prefix.length()==1&&trie.get(prefix.charAt(0))!=null){
            return true;
        }
        if(trie.get(prefix.charAt(0))!=null
                &&trie.get(prefix.charAt(0)).startsWith(prefix.substring(1))){
            //如果当前map有数据且prefix长大于1且子节点的前缀为true，则找到前缀
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        _208_DictionaryTree trie = new _208_DictionaryTree();
        trie.insert("apple");
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("apple"));
        trie.insert("app");
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
    }

}
