package sword;

/**
 * title :https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *  
 * 限制：
 * 0 <= 节点个数 <= 1000
 *
 * Description :
 * Created by jiangjunchi on 2020/6/3 11:04
 **/
public class IsSymmetric {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        /**
         * 时间复杂度 O(N)： 其中 N为二叉树的节点数量，每次执行 recur() 可以判断一对节点是否对称，因此最多调用 N/2次 recur() 方法。
         * 空间复杂度 O(N)： 最差情况下（见下图），二叉树退化为链表，系统使用 O(N)大小的栈空间。
         */
        private static boolean isSymmetricOfi(TreeNode root) {
            return root==null?true:recur(root.left,root.right);
        }

        private static boolean recur(TreeNode L,TreeNode R){
            if(L==null && R==null){
                return true;
            }
            if(L==null || R==null || L.val!=R.val){
                return false;
            }
            return recur(L.left,R.right) && recur(L.right,R.left);
        }

        public static void main(String[] args) {
            TreeNode root=new TreeNode(1);
            TreeNode one=new TreeNode(2);
            TreeNode two=new TreeNode(2);
            TreeNode three=new TreeNode(3);
            TreeNode four=new TreeNode(3);
            TreeNode five=new TreeNode(4);
            TreeNode six=new TreeNode(4);

            root.left=one;
            root.right=two;

            one.left=three;
            one.right=five;

            two.left=six;
            two.right=four;

            System.out.println(isSymmetricOfi(root));

        }

    }
}
