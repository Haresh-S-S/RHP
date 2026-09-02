import java.util.*;

public class WordSearchII {
    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        String word;
    }

    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {

        for (String word : words)
            insert(word);

        List<String> result = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, i, j, root, result);
            }
        }

        return result;
    }

    void insert(String word) {

        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (node.child[index] == null)
                node.child[index] = new TrieNode();

            node = node.child[index];
        }

        node.word = word;
    }

    void search(char[][] board, int r, int c,
            TrieNode node, List<String> result) {

        if (r < 0 || r >= board.length ||
                c < 0 || c >= board[0].length)
            return;

        char ch = board[r][c];

        if (ch == '#')
            return;

        TrieNode next = node.child[ch - 'a'];

        if (next == null)
            return;

        if (next.word != null) {
            result.add(next.word);
            next.word = null; // Avoid duplicates
        }

        board[r][c] = '#';

        search(board, r + 1, c, next, result);
        search(board, r - 1, c, next, result);
        search(board, r, c + 1, next, result);
        search(board, r, c - 1, next, result);

        board[r][c] = ch;
    }

    public static void main(String[] args) {

        Main obj = new Main();

        char[][] board = {
                { 'o', 'a', 'a', 'n' },
                { 'e', 't', 'a', 'e' },
                { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' }
        };

        String[] words = {
                "oath",
                "pea",
                "eat",
                "rain"
        };

        System.out.println(obj.findWords(board, words));
    }
}
