package sword;

/**
 * title :https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 *
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *  
 * 限制：
 * 1 ≤ k ≤ 二叉搜索树元素个数
 *
 * Description :
 * 二叉搜索树的中序遍历为 递增序列--->倒序为递减序列
 * 二叉搜索树第k大的节点--->中序遍历倒序的第k个节点
 *
 * 中序遍历：左、根、右，递归代码如下：
 * void dfs(TreeNode root){
 *     if(root==null){
 *         return;
 *     }
 *     dfs(root.left);
 *     System.out.println(root.val);
 *     dfs(root.right);
 * }
 *
 * 中序遍历的倒序：右、根、左，递归代码如下：
 * void dfs(TreeNode root){
 *     if(root==null){
 *         return;
 *     }
 *     dfs(root.right);
 *     System.out.println(root.val);
 *     dfs(root.left);
 * }
 *
 * Created by jiangjunchi on 2020/6/9 16:54
 **/
public class KthLargest {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static int res,k;

    /**
     * 时间复杂度 O(N)： 当树退化为链表时（全部为右子节点），无论 k的值大小，递归深度都为 N，占用 O(N)时间
     * 空间复杂度 O(N)： 当树退化为链表时（全部为右子节点），系统使用 O(N)大小的栈空间。
     */
    private static int kthLargestOfi(TreeNode root, int value) {
        k=value;
        dfs(root);
        return res;
    }

    private static void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.right);
        if(k==0){
            return;
        }
        if(--k==0){
            res=root.val;
        }
        dfs(root.left);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        TreeNode one=new TreeNode(3);
        TreeNode two=new TreeNode(6);
        TreeNode three=new TreeNode(2);
        TreeNode four=new TreeNode(4);
        TreeNode five=new TreeNode(1);

        root.left=one;
        root.right=two;
        one.left=three;
        one.right=four;
        three.left=five;

        System.out.println(kthLargestOfi(root,3));
    }

}
