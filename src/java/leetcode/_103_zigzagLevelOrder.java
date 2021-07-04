package java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName _103_zigzagLevelOrder
 * @Description 二叉树Z字遍历
 * @Author yangxiaobo
 * @Date 2021/4/25 15:02
 * @Version 1.0
 */
public class _103_zigzagLevelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root==null){
            return result;
        }
        List<TreeNode> rootNode = new ArrayList<>();
        List<Integer> rootN = new ArrayList<>();
        rootNode.add(root);
        rootN.add(root.val);
        result.add(rootN);
        boolean flag = false;
        while(rootNode.size()!=0){
            List<TreeNode> nextNode = new ArrayList<>();
            List<Integer> next = new ArrayList<>();
            if(flag){
                for(int i=rootNode.size()-1;i>=0;i--){
                    if(rootNode.get(i).left!=null){
                        nextNode.add(rootNode.get(i).left);
                        next.add(rootNode.get(i).left.val);
                    }
                    if(rootNode.get(i).right!=null){
                        nextNode.add(rootNode.get(i).right);
                        next.add(rootNode.get(i).right.val);
                    }
                }
                flag = false;
            }else{
                for(int i=rootNode.size()-1;i>=0;i--){
                    if(rootNode.get(i).right!=null){
                        nextNode.add(rootNode.get(i).right);
                        next.add(rootNode.get(i).right.val);
                    }
                    if(rootNode.get(i).left!=null){
                        nextNode.add(rootNode.get(i).left);
                        next.add(rootNode.get(i).left.val);
                    }
                }
                flag = true;
            }
            if(next.size()!=0){
                result.add(next);
            }
            rootNode = nextNode;
        }
        return result;
    }
}
