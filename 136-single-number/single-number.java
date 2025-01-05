class Solution {
    public int singleNumber(int[] nums) {
        // o(n) space solution
        /*
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            if(!set.contains(num)){
                set.add(num);
            }else{
                set.remove(num);
            }
        }
        return set.iterator().next();
        */

        //o(1) space solution
        int res = 0;
        for (int num : nums){
            res ^= num;
        }
        return res;
    }
}