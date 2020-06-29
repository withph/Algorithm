package sword;

/**
 * title :https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）
 *
 * [['a','b','c','e'],
 * ['s','f','c','s'],
 * ['a','d','e','e']]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后
 * 路径不能再次进入这个格子
 *
 * 示例 1：
 * 输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'ABCCED'
 * 输出：true
 *
 * 示例 2：
 * 输入：board = [['a','b'],['c','d']], word = 'abcd'
 * 输出：false
 *
 * 提示：
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 *
 * Description :
 * Created by jiangjunchi on 2020/6/15 19:56
 **/
public class Exist {

    /**
     * M,N 分别为矩阵行列大小， KK 为字符串 word 长度
     * <p>
     * 时间复杂度 O(3^KMN)：最差情况下，需要遍历矩阵中长度为 K 字符串的所有方案，时间复杂度为 O(3^K)
     * 矩阵中共有 MN 个起点，时间复杂度为 O(MN)
     * 方案数计算： 设字符串长度为 K ，搜索中每个字符有上、下、左、右四个方向可以选择，舍弃回头（上个字符）的方向
     * 剩下 3 种选择，因此方案数的复杂度为 O(3^K)
     * 空间复杂度 O(K) ： 搜索过程中的递归深度不超过 K ，因此系统因函数调用累计使用的栈空间占用 O(K) （因为函数返回后
     * 系统调用的栈空间会释放）。最坏情况下 K = MN ，递归深度为 MN ，此时系统栈使用 O(MN) 的额外空间
     */
    private static boolean existOfi(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = tmp;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'F'}};
        String word = "ABCCED";
        System.out.println(existOfi(board, word));
    }
}
