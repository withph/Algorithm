package sword;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * title :https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）
 * 形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *   3
 * / \
 *9  20
 * /  \
 *15   7
 * 返回它的最大深度 3 。
 *
 * 提示：
 * 节点总数 <= 10000
 *
 * Description :
 *
 * 树的遍历方式总体分为两类：深度优先搜索（DFS）、广度优先搜索（BFS）
 *      常见的 DFS ： 先序遍历、中序遍历、后序遍历
 *      常见的 BFS ： 层序遍历（即按层遍历）
 *
 * 树的后序遍历 / 深度优先搜索往往利用 递归 或 栈 实现
 * 此树的深度 等于 左子树的深度 与 右子树的深度 中的 最大值 +1
 *
 * 树的层序遍历 / 广度优先搜索往往利用 队列 实现
 * 关键点： 每遍历一层，则计数器 +1，直到遍历完成，则可得到树的深度
 * Created by jiangjunchi on 2020/6/9 20:31
 **/
public class MaxDepth {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 后续遍历
     * 时间复杂度 O(N)： N为树的节点数量，计算树的深度需要遍历所有节点
     * 空间复杂度 O(N)： 最差情况下（当树退化为链表时），递归深度可达到 N
     */
    private static int maxDepthOfi1(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepthOfi1(root.left),maxDepthOfi1(root.right))+1;
    }

    /**
     * 层序遍历
     * 时间复杂度 O(N)： N为树的节点数量，计算树的深度需要遍历所有节点
     * 空间复杂度 O(N)： 最差情况下（当树平衡时），队列 queue 同时存储 N/2个节点
     */
    private static int maxDepthOfi2(TreeNode root) {
        if(root==null){
            return 0;
        }
        List<TreeNode> queue=new LinkedList<TreeNode>(){
            {
                add(root);
            }
        },tmp;
        int res=0;
        while(!queue.isEmpty()){
            tmp=new LinkedList<>();
            for(TreeNode node:queue){
                if(node.left!=null){
                    tmp.add(node.left);
                }
                if(node.right!=null){
                    tmp.add(node.right);
                }
            }
            queue=tmp;
            res++;
        }
        return res;
    }

    /**
     * 深度优先搜索
     */
    private static int maxDepthOfi3(TreeNode root) {
        if(root==null){
            return 0;
        }

        int depth=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode head=new TreeNode(3);
        TreeNode one=new TreeNode(9);
        TreeNode two=new TreeNode(2);
        TreeNode three=new TreeNode(1);
        TreeNode four=new TreeNode(7);

        head.left=one;
        head.right=two;
        two.left=three;
        two.right=four;

        maxDepthOfi2(head);
    }

}
