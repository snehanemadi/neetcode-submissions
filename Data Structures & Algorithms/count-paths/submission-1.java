class Solution {
    //store in each pos number of ways to reach dest

    // dest holds value 1
    //compute bottom row 1st
    // right to left going to n-1 rows
    // condition is pos = R + D
    //  ending condition -> 
    public int uniquePaths(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row, 1);

        for(int i = 0; i < m-1 ;i++){ // all rows except last one
            int[] newRow = new int[n];
            Arrays.fill(newRow, 1);
            for(int j = n - 2 ; j >= 0 ; j--){
                newRow[j] = newRow[j+1] + row[j];
            }
            row = newRow;
        }
        return row[0];
    }
}
