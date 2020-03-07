package com.qiming.algorithm;

/**
 * 矩阵中的路径
 *
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED" 输出：true
 *
 * 1 <= board.length <= 200 1 <= board[i].length <= 200
 *
 * 思路：这一看就是回溯法的做法哦，回溯的同时需要去减枝（此元素和目标字符不同，此元素应被访问）
 * 递归参数：当前元素矩阵board所在的行列索引i和j，当前目标字符串在word中的索引k
 * 终止条件：
 * 1、返回false，行或列索引越界，当前矩阵元素与目标字符不同，当前矩阵元素已经被访问过，后两者可合并
 * 2、返回true，字符串word已经全部匹配，即k=len(word) - 1
 * 递推工作：
 * 1、标记当前矩阵元素，将board[i][j]值暂存于变量tmp，并修改为字符'/'，代表此元素已被访问过，防止之后搜索时重复访问
 * 2、搜索下一单元格，朝当前元素的上、下、左、右四个方向开启下层递归，使用或连接，并记录结果至res
 * 3、还原当前矩阵元素，将tmp暂存值还原至board[i][j]
 * 回溯返回值：返回res，代表是否搜索到目标字符串
 *
 * 回溯模板的一种变体
 *
 */
public class WordSearch {

  public boolean exist(char[][] board, String word) {

    char[] words = word.toCharArray();
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[0].length; j++) {
        if(dfs(board, words, i, j, 0)) return true;
      }
    }
    return false;

  }

  private boolean dfs(char[][] board, char[] word, int i, int j, int k) {

    if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
    if(k == word.length - 1) return true;
    char tmp = board[i][j];
    board[i][j] = '/';
    boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
        dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
    board[i][j] = tmp;
    return res;

  }

}
