package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @Program:https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 * 给定一个二叉树，返回它的中序 遍历
 * 输入: [1,null,2,3]
           1
            \
             2
            /
           3

 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @Description:
 * 如果采用非递归，可以用栈(Stack)的思路来处理问题。
 * 中序遍历的顺序为左-根-右，具体算法为：
 * - 从根节点开始，先将根节点压入栈
 * - 然后再将其所有左子结点压入栈，取出栈顶节点，保存节点值
 * - 再将当前指针移到其右子节点上，若存在右子节点，则在下次循环时又可将其所有左子结点压入栈中， 重复上步骤
 *
 *
 * @Author: jiangjunchi
 * @Date: 2020-05-11 22:28:02
 */
public class BinaryTreeInorderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        recursion(res,root);
        return res;
    }

    /**
     * 递归版
     * @param res
     * @param root
     */
    private static void recursion(List<Integer> res,TreeNode root){
        if(root!=null){
            if(root.left!=null){
                recursion(res,root.left);
            }
            res.add(root.val);
            if(root.right!=null){
                recursion(res,root.right);
            }
        }
    }




}
