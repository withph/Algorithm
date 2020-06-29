package sword;

import java.util.HashMap;
import java.util.Map;

/**
 * title :https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字
 *
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *   15   7
 *
 * 限制：
 * 0 <= 节点个数 <= 5000
 *
 * Description :
 * Created by jiangjunchi on 2020/6/15 9:43
 **/
public class BuildTree {

    private static int[] po;
    private static Map<Integer,Integer> map=new HashMap<>();

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    private static TreeNode buildTreeOfi(int[] preorder, int[] inorder) {

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return recur(0,0,inorder.length-1);
    }

    private static TreeNode recur(int pre_root,int in_left,int in_right){
        if(in_left>in_right){
            return null;
        }
        TreeNode root=new TreeNode(po[pre_root]);
        int i=map.get(po[pre_root]);
        root.left=recur(pre_root+1,in_left,i-1);
        root.right=recur(pre_root+i-in_left+1,i+1,in_right);
        return root;
    }

    public static void main(String[] args) {

    }

}
