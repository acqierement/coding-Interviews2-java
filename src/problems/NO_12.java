package problems;

import java.util.prefs.BackingStoreException;

/**
 * 矩阵中的路径
 * leetcode79
 * @author acqierement
 * Data: 2018年11月20日
 * Time: 下午7:00:28
 */
public class NO_12 {
	boolean visited[][];
	public boolean hasPath(char[][] board, String word) {
		if(board == null || board.length < 1 || board[0].length < 1) return false; 
		visited = new boolean[board.length][board[0].length];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == word.charAt(0) && hasPahtCore(board, word, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean hasPahtCore(char[][] board, String word, int i, int j, int pathLength) {
		if(pathLength == word.length())
			return true;
		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length ||board[i][j] != word.charAt(pathLength) || visited[i][j] == true ) {
			return false;
		}
		visited[i][j] = true;
		if(hasPahtCore(board, word, i+1, j, pathLength+1)||
			hasPahtCore(board, word, i-1, j, pathLength+1)||
			hasPahtCore(board, word, i, j+1, pathLength+1)||
			hasPahtCore(board, word, i, j-1, pathLength+1)) {
			return true;
		}
		visited[i][j] = false;
		return false;
	}
	
}
