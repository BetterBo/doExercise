package java.xiehceng;

import java.util.Scanner;

/**
 * @ClassName exam210415
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2021/4/15 19:10
 * @Version 1.0
 */
public class exam210415 {
    public static class node{
        char val;
        node l;
        node r;
    }
    public static void tree(node root,int depth){
        if(depth==13){
            return;
        }
        node l = new node();
        l.val = 'G';
        node r = new node();
        r.val = 'R';
        root.l = l;
        root.r = r;
        tree(root.l,depth+1);
        tree(root.r,depth+1);
    }

    public static void mid(node root,int depth){
        if(depth==0){
            return;
        }
        mid(root.l,depth-1);
        System.out.print(root.val);
        mid(root.r,depth-1);
    }

    static String buildingHouse(String n) {
        try {
            int i = Integer.parseInt(n);
            if(i<1||i>12){
                System.out.println("O");
                return "O";
            }
            mid(root,i);
            System.out.println();
        } catch (NumberFormatException e) {
            System.out.println("N");
            return "N";
        }
        return "";
    }
    /******************************结束写代码******************************/

    static node root = null;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        root = new node();
        root.val = 'R';
        tree(root,1);
        String _n;
        try {
            _n = in.nextLine();
        } catch (Exception e) {
            _n = null;
        }
        buildingHouse(_n);
    }
}
