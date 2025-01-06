class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //use number for direction : 1 - right, 2 - down, 3 - left, 4 - up
        int top = 0;
        int bottom = matrix.length-1;
        int left  = 0;
        int right = matrix[0].length-1;
        List<Integer> res = new ArrayList<>();
        helper(matrix, res, top, bottom, left, right);
        return res;
    }
    public List<Integer> helper(int[][] matrix, List<Integer>res, int top, int bottom, int left, int right){
        //stopping condition
        if(top>bottom || left>right) return res; 
        //traverse left to right
        for(int i = left; i<=right; i++){
            res.add(matrix[top][i]);
        }
        top++; //shrink the top boundry

        //traverse top down
        for(int i = top; i<=bottom; i++){
            res.add(matrix[i][right]);
        }
        right--; //shrink the right boundry

        //traverse right to left
        //check if top is still <= than bottom
        if(top<=bottom){
            for(int i = right; i>=left; i--){
                res.add(matrix[bottom][i]);
            }
            bottom--;
        }
        
        ////traverse down top
        //check if left is still <= right
        if (left <= right) {
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++; 
        }

        return helper(matrix, res, top, bottom, left, right);
    }
}