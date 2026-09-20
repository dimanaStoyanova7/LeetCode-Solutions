class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int queens[] = new int[n]; // for each queen: on which row is it
        backtrackHelper(result, queens, 0, n);
        return result;
    }
    //current - the current rows so far
    // index - row to tackle now
    private void backtrackHelper(List<List<String>> result, int[] queens, int row, int n){
        if(row == n){
            // turns  queens into a List<String>
            List<String> resultBoard = new ArrayList<>();
            for(int r = 0; r<n; r++){
                StringBuilder sb = new StringBuilder();
                for(int col = 0; col<n; col++){
                    if(col==queens[r]){
                        sb.append("Q");
                    }
                    else{
                        sb.append(".");
                    }
                }
                resultBoard.add(sb.toString());
            }
            result.add(resultBoard);
            return;
        }
        //iterate though the columns
        for(int col = 0; col<n; col++){
            if(safe(col, queens, row)){
                queens[row] = col; 
                backtrackHelper(result, queens, row+1, n);
            }
        }

    }
    private boolean safe(int col, int[]queens ,int row){
        for(int r = 0; r<row; r++){ // for  each row
            int c = queens[r];       //get the column where we have a queen
            if(c==col){
                return false;
            }
            if (row - col == r - c) return false;
            if (row + col == r + c) return false;
        }
        return true;
    }
}