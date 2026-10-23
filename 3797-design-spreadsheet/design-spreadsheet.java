class Spreadsheet {
    HashMap<String, Integer> map; 

    public Spreadsheet(int rows) {
        map = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        map.put(cell, value);
    }
    
    public void resetCell(String cell) {
        map.put(cell, 0);
    }
    
    public int getValue(String formula) {
        String[] elements = formula.substring(1).split("\\+");
        return resolve(elements[0])+resolve(elements[1]);
    }

    private int resolve(String element){
        if (Character.isLetter(element.charAt(0))){
            return map.getOrDefault(element,0);
        }
        else{
            return Integer.parseInt(element);
        }
    }


}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */