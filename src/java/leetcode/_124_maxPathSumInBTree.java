package java.leetcode;

/**
 * @ClassName _124_maxPathSumInBTree
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2021/6/2 16:00
 * @Version 1.0
 */
public class _124_maxPathSumInBTree {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        //添加字段，表示当前节点如果能被上层节点使用时，最大的值
        int nodeAbleSum;
        //添加字段，表示当前节点不考虑上层节点使用时，最大的值
        int sum;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
        public int maxPathSum(TreeNode root) {
            if(root==null){
                return 0;
            }
            maxPathSum(root.left);
            maxPathSum(root.right);
            int result = root.val;
            root.nodeAbleSum = root.val;
            //分情况
            //左可用+root->可设置root可用字段nodeAbleSum
            //右可用+root->可设置root可用字段nodeAbleSum
            //左可用+右可用+root->不可设置root可用字段nodeAbleSum
            //左不可用->不可设置root可用字段nodeAbleSum
            //右不可用->不可设置root可用字段nodeAbleSum
            if(root.left!=null){
                //当前节点可被上层使用字段先验证，以免被左子节点扰乱
                if(root.val+root.left.nodeAbleSum>=result){
                    result = root.val+root.left.nodeAbleSum;
                    root.nodeAbleSum = root.val+root.left.nodeAbleSum;
                }
            }
            if(root.right!=null){
                if(root.val+root.right.nodeAbleSum>=result){
                    result = root.val+root.right.nodeAbleSum;
                    root.nodeAbleSum = root.val+root.right.nodeAbleSum;
                }
            }

            if(root.left!=null&&root.right!=null){
                if(root.val+root.right.nodeAbleSum+root.left.nodeAbleSum>=result){
                    result = root.val+root.right.nodeAbleSum+root.left.nodeAbleSum;
                }
            }
            if(root.left!=null){
                if(root.left.sum>result){
                    result = root.left.sum;
                }
            }
            if(root.right!=null){
                if(root.right.sum>result){
                    result = root.right.sum;
                }
            }
            root.sum = result;
            return result;
        }


    }
}
