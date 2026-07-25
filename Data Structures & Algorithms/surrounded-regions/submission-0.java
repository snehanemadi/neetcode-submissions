class Solution {
    //O(m*n)

    //scan from edges to inverds and mark every O to T , touching the edge and O touching the T also
    // in the later scan mark remaning O to X
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        for(int r = 0 ; r < row ;r++){
            for(int c = 0 ; c < col ; c++){
                if(board[r][c] == 'O' && (r ==0 || c ==0|| r == row-1 || c== col-1)){
                    dfs(r, c, row, col, board);
                }
            }
        }
        for(int r = 0 ; r < row ;r++){
            for(int c = 0 ; c < col ; c++){
                if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }
            }
        }
        for(int r = 0 ; r < row ;r++){
            for(int c = 0 ; c < col ; c++){
                if(board[r][c] == 'T'){
                    board[r][c] = 'O';
                }
            }
        }
    }

    public void dfs(int r, int c, int row, int col, char[][] board){
        if(r < 0 || c < 0 || r == row || c == col || board[r][c] != 'O'){
            return;
        }

        board[r][c] = 'T';
        dfs(r - 1, c, row, col, board);
        dfs(r + 1, c, row, col, board);
        dfs(r, c - 1, row, col, board);
        dfs(r, c + 1, row, col, board);
    }
}
