class Solution {
    public int numIslands(char[][] grid) {
        //implicit graph problem
        //mark the visited as 0 
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for(int i = 0; i<rows; i++){
            for(int j = 0 ; j< cols; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    /*
    * method marks all adjacent 1st forming an island as 0s 
    */
    public void dfs(char[][] grid, int i, int j){
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == '0') return ;
        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);

        

    }
}