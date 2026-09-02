public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean ans = false;
        int R = board.length, C = board[0].length;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (dfs(board, visited, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, boolean[][] visited, int row, int col, String word, int ind) {
        if (ind == word.length())
            return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != word.charAt(ind)) {
            return false;
        }
        boolean res = false;

        visited[row][col] = true;
        char temp = board[row][col];
        board[row][col] = '_';

        if (dfs(board, visited, row - 1, col, word, ind + 1) ||
                dfs(board, visited, row, col - 1, word, ind + 1) ||
                dfs(board, visited, row + 1, col, word, ind + 1) ||
                dfs(board, visited, row, col + 1, word, ind + 1))
            res = true;

        board[row][col] = temp;

        return res;
    }
}
