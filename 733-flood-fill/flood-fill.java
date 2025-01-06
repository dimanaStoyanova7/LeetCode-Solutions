class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image.length==0 || image==null) return image;
        if (sr>=image.length || sc>=image[0].length) return image;
        int colorToChange = image[sr][sc];
        if (colorToChange == color) return image;
        helper(image, colorToChange, sr,sc, color);
        return image;
    }
    public void helper(int[][] image,int colorToChange ,int row, int col, int color){
        if(row<0 || col<0 || row>=image.length || col>=image[0].length) return;
        if(image[row][col]!=colorToChange) return;
        image[row][col] = color;
        helper(image, colorToChange, row+1, col, color);
        helper(image, colorToChange, row-1, col, color);
        helper(image, colorToChange, row, col+1, color);
        helper(image, colorToChange, row, col-1, color);

    }
}