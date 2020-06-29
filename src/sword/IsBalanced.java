package sword;

/**
 * title :https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true
 *
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 * Description :
 * Created by jiangjunchi on 2020/6/10 10:01
 **/
public class IsBalanced {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 后序遍历 + 剪枝 （从底至顶）
     * 对二叉树做后序遍历，从底至顶返回子树深度，若判定某子树不是平衡树则 “剪枝” ，直接向上返回
     *
     * 时间复杂度 O(N)O(N)： NN 为树的节点数；最差情况下，需要递归遍历树的所有节点。
     * 空间复杂度 O(N)O(N)： 最差情况下（树退化为链表时），系统递归需要使用 O(N)O(N) 的栈空间
     */
    private static boolean isBalanced1(TreeNode root) {
        return recur(root)!=-1;
    }

    private static int recur(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=recur(root.left);
        if(left==-1){
            return -1;
        }
        int right=recur(root.right);
        if(right==-1){
            return -1;
        }
        return Math.abs(left-right)<2?Math.max(left,right)+1:-1;
    }

    /**
     * 先序遍历 + 判断深度 （从顶至底）
     * 时间复杂度：每层执行复杂度 × 层数复杂度 = O(N×logN)
     * 空间复杂度 O(N)： 最差情况下（树退化为链表时），系统递归需要使用 O(N)的栈空间
     */
    private static boolean isBalanced2(TreeNode root) {
        if(root==null){
            return true;
        }
        return Math.abs(depth(root.left)-depth(root.right))<=1 &&
                isBalanced2(root.left) && isBalanced2(root.right);
    }

    private static int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(depth((root.left)),depth(root.right))+1;
    }

    private static void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.left);
        dfs(root.right);
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

        isBalanced1(head);
    }

}
