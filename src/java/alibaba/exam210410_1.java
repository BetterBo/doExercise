package java.alibaba;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName exam210410_1
 * @Description
 * 评测题目1：判断括号是否正确闭合
 * // 判断括号是否正确闭合，包括 ()[]{} 三种类型共六种符号
 * // 给定一个字符串，判断括号是否正确闭合，字符串由数字、字母、括号三种元素组成
 * // 正确闭合的条件有两个， 一是所有左括号在前且必须对应有右括号，二是括号闭合的顺序要准确
 * // 比如 [(ASD)SD{SD}] 就是正确闭合，ASD33(}{) 就是不正确的闭合
 * // 样例输入：[(ASD)BB(SD{SD}])
 * // 样例输出：false
 * @Author yangxiaobo
 * @Date 2021/4/10 19:04
 * @Version 1.0
 */
public class exam210410_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.print(calc(str));
    }
    public static boolean calc(String str){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            if((str.charAt(i)=='('||str.charAt(i)=='['||str.charAt(i)=='{')){
                stack.push(str.charAt(i));

            }
            if((str.charAt(i)==')'||str.charAt(i)==']'||str.charAt(i)=='}')){
                if(stack.empty()){
                    return false;
                }
                Character peek = stack.peek();
                if(peek!='('&&str.charAt(i)==')'||peek!='['&&str.charAt(i)==']'||peek!='{'&&str.charAt(i)=='}'){
                    return false;
                }
                if(peek=='('&&str.charAt(i)==')'||peek=='['&&str.charAt(i)==']'||peek=='{'&&str.charAt(i)=='}'){
                    stack.pop();
                }
            }
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }
}
