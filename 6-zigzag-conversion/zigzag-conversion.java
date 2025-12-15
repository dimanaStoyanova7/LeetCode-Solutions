class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1 || s.length()<numRows){
            return s;
        }
        StringBuilder[] result = new StringBuilder[numRows];
        for (int i=0; i<numRows; i++){
            result[i] = new StringBuilder();
        }
        int rowIndex = 0;
        boolean goingUp = true;
        for(char c: s.toCharArray()){
            //check if we need to switch direction
            if(rowIndex == 0 || rowIndex == numRows-1){
                goingUp = !goingUp;
            }
            //add character at index
            result[rowIndex].append(c);
            //update index
            if(goingUp){
                rowIndex--;
            }
            else{
                rowIndex++;
            }
        }
        StringBuilder finalResult = new StringBuilder();
        for( StringBuilder sb: result){
            finalResult.append(sb);
        }
        return finalResult.toString();
    }
}