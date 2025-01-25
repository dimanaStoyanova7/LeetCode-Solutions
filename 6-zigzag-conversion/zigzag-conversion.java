class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || s.length()<=numRows) return s;
        int currentRow = 0;
        boolean goingDown = false;
        //use array of stringBuilders
        StringBuilder[] res = new StringBuilder[numRows];
        for(int i = 0; i<numRows; i++){
            res[i] = new StringBuilder();
        }

        //traverse sting and put characters in corresponding strings
        for(char c : s.toCharArray()){
            res[currentRow].append(c);
            if(currentRow == 0 || currentRow == numRows - 1) goingDown = !goingDown;
            currentRow += goingDown ? 1 : -1; 
        }
        StringBuilder finalResult = new StringBuilder();
        for (StringBuilder sb : res){
            finalResult.append(sb.toString());
        }
        return finalResult.toString();
    }
}