package java.tecent;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName exam210404_1
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2021/4/4 19:51
 * @Version 1.0
 */
public class exam210404_1 {
    public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
  }
    public TreeNode solve (TreeNode root) {
        if(root==null){
            return null;
        }

        if(root.left==null||root.right==null){
            root.left = null;
            root.right = null;
            return root;
        }
        solve(root.left);
        solve(root.right);
        return root;
//        Queue<TreeNode> queue = new LinkedList<>();
//        Queue<TreeNode> queue2 = new LinkedList<>();
//        if (root==null){
//            return null;
//        }
//        queue.add(root);
//        int c = 0;
//        while (queue!=null){
//            c++;
//            while(queue!=null){
//                TreeNode poll = queue.poll();
//                if(poll.left==null&&poll.right==null){
//                    break;
//                }
//                queue2.add(poll.left);
//                queue2.add(poll.right);
//            }
//            if(queue.size()!=0){
//                break;
//            }
//            Queue<TreeNode> tem = queue;
//            queue = queue2;
//            queue2 = queue;
//        }
//        queue.clear();
//        queue.add(root);
//        for (int i=1;i<c;i++){
//            while(queue!=null){
//                TreeNode poll = queue.poll();
//                if(poll.left==null&&poll.right==null){
//                    break;
//                }
//                queue2.add(poll.left);
//                queue2.add(poll.right);
//            }
//            Queue<TreeNode> tem = queue;
//            queue = queue2;
//            queue2 = tem;
//        }
//        while(queue!=null){
//            TreeNode poll = queue.poll();
//            poll.left=null;
//            poll.right=null;
//        }
//
//        return root;


        // write code here
    }
}
