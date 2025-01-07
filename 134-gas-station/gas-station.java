class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // brute force approach : check from every station as if it was the starting

        // greedy approach

        // total amount of gas should be bigger than total cost
        // at each station : add possible gas  and deduct cost
        // if deducting the cost makes balance < 0 => update start

        //KEY OBSERVATION: if starting at a positin i and failing at position j, none of the positions between i and j included are feasible start poisiton
        int startStation = 0;
        int totalGas = 0;
        int currentGas = 0;
        for (int i = 0; i < gas.length; i++){
            totalGas += gas[i] - cost[i];
            currentGas += gas[i] - cost[i];
            if(currentGas<0) { //update start statin
                startStation = i+1;
                currentGas = 0;
            } 
        }

        return totalGas>=0 ? startStation : -1;

    }
}