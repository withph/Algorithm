package sword;

import java.util.Stack;

/**
 * title :https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *  
 *
 * 限制：
 * 0 <= 节点个数 <= 1000
 *
 * Description :
 * Created by jiangjunchi on 2020/6/2 20:21
 **/
public class MirrorTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 时间复杂度 O(N)： 其中 N为二叉树的节点数量，建立二叉树镜像需要遍历树的所有节点，占用 O(N)时间。
     * 空间复杂度 O(N)： 最差情况下（当二叉树退化为链表），递归时系统需使用 O(N)大小的栈空间。
     */
    private static TreeNode mirrorTreeOfiRec(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode temp=root.left;
        root.left=mirrorTreeOfiRec(root.right);
        root.right=mirrorTreeOfiRec(temp);
        return root;
    }

    /**
     * 时间复杂度 O(N)： 其中 N为二叉树的节点数量，建立二叉树镜像需要遍历树的所有节点，占用 O(N)时间。
     * 空间复杂度 O(N)： 最差情况下（当为满二叉树时），栈 stackstack 最多同时存储 N/2个节点，占用 O(N)额外空间。
     */
    private static TreeNode mirrorTreeOfiStack(TreeNode root) {
        if(root==null){
            return null;
        }
        Stack<TreeNode> stack=new Stack<TreeNode>(){
            {
                add(root);
            }
        };
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left!=null){
                stack.add(node.left);
            }
            if(node.right!=null){
                stack.add(node.right);
            }
            TreeNode tmp=node.left;
            node.left=node.right;
            node.right=tmp;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(4);
        TreeNode two=new TreeNode(2);
        TreeNode three=new TreeNode(7);
        TreeNode four=new TreeNode(1);
        TreeNode five=new TreeNode(3);
        TreeNode six=new TreeNode(6);
        TreeNode seven=new TreeNode(9);
        root.left=two;
        root.right=three;
        two.left=four;
        two.right=five;
        three.left=six;
        three.right=seven;

        TreeNode treeNode = mirrorTreeOfiStack(root);
    }

}
