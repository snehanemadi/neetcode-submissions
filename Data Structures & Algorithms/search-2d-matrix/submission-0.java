class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int top = 0, bot = row - 1;;
        while(top <= bot){
            int row_2 = (top + bot) / 2;
            if(target > matrix[row_2][col-1]){
                top = row_2 + 1;
            } else if(target < matrix[row_2][0]){
                bot = row_2 - 1;
            } else {
                break;
            }
        }

        if(!(top <= bot)){
            return false;
        }

        int row_1 = (top + bot) / 2;
        int l = 0;
        int r = col-1;
        while(l <= r){
            int m = (l + r) / 2;
            if(target > matrix[row_1][m]){
                l = m + 1;
            } else if(target < matrix[row_1][m]){
                r = m - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}

