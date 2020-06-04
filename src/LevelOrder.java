import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * title :https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *   3
 * / \
 * 9  20
 *  /  \
 * 15   7
 * 返回其层次遍历结果：
 *
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *  
 * 提示：
 * 节点总数 <= 1000
 *
 * Description :
 * Created by jiangjunchi on 2020/6/4 17:29
 **/
public class LevelOrder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 时间复杂度 O(N)： N为二叉树的节点数量，即 BFS 需循环 N次
     * 空间复杂度 O(N)： 最差情况下，即当树为平衡二叉树时，最多有 N/2个树节点同时在 queue 中，使用 O(N)大小的额外空间
     */
    private static List<List<Integer>> levelOrderDiy(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root!=null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            int n=queue.size();
            List<Integer> level=new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        TreeNode two=new TreeNode(9);
        TreeNode three=new TreeNode(20);
        TreeNode four=new TreeNode(15);
        TreeNode five=new TreeNode(7);
        root.left=two;
        root.right=three;
        three.left=four;
        three.right=five;
        System.out.println(levelOrderDiy(root));
    }

}
