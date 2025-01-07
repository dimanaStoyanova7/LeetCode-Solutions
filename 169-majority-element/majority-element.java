class Solution {
    public int majorityElement(int[] nums) {
        //brute force: o(n^2)

        //hashmap o(n) space, o(n) time

        /*
        Map<Integer, Integer> map = new HashMap<>();
        int majorityCount = nums.length /2;
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
            if(map.get(num)>majorityCount) return num;
        }
        return -1;

        */

        // voting algorithms o(1) space, o(n) time
        int count = 0;
        int candidate =0;
        for(int num : nums){
            if(count == 0) candidate = num;
            if(candidate == num){
                count++;
            } else count--;
        }
        return candidate;
    
    }
}