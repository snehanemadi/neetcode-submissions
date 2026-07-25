class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> col = new HashMap<>();
        Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer, Set<Character>> square = new HashMap<>();

        for(int i = 0; i < 9 ; i++){
            for(int j =0 ; j < 9; j++){
                char cell = board[i][j];
                if(cell == '.'){
                    continue;
                }
                if(row.getOrDefault(i , new HashSet<>()).contains(cell)
                || col.getOrDefault(j , new HashSet<>()).contains(cell)
                ||square.getOrDefault((i / 3) * 3 + j / 3 , new HashSet<>()).contains(cell)){
                    return false;
                }
                row.computeIfAbsent(i, k -> new HashSet<>()).add(cell);
                col.computeIfAbsent(j, k -> new HashSet<>()).add(cell);
                square.computeIfAbsent((i /3) * 3 + j /3, k -> new HashSet<>()).add(cell);
            }
        }
        return true;
    }
}
