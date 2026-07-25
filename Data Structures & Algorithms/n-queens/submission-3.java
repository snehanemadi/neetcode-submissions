class Solution {
    public List<List<String>> solveNQueens(int n) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> posDia = new HashSet<>();
        Set<Integer> negDia = new HashSet<>();

        List<List<String>> res = new ArrayList<>();

        char[][] board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row, '.');
        }

        backtrack(0, n, col, posDia, negDia, board, res);
        return res;
    }
    private void backtrack(int r, int n, Set<Integer> col, Set<Integer> posDia,
    Set<Integer> negDia, char[][] board, List<List<String>> res){
        if(r == n){
            List<String> copy = new ArrayList<>();
            for(char[] row : board) {
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }

        // every col in cur row
        for(int c = 0 ; c < n ; c++){
            if(col.contains(c) || posDia.contains(r+c) || negDia.contains(r-c)){
                continue;
            }

            col.add(c);
            posDia.add(r+c);
            negDia.add(r-c);
            board[r][c] = 'Q';

            backtrack(r + 1, n, col, posDia, negDia, board, res);

            col.remove(c);
            posDia.remove(r+c);
            negDia.remove(r-c);
            board[r][c] = '.';
        }
    }
}
