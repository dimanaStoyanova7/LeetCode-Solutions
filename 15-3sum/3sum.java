class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i<nums.length-2; i++){
            int target = -nums[i];
            Set<Integer> seen = new HashSet<>();
            for(int j = i+1; j<nums.length; j++){
                int complement  = target -nums[j];
                if(seen.contains(complement)){
                    result.add(Arrays.asList(nums[i], nums[j], complement));
                }
                seen.add(nums[j]);
            }
        }
        return new ArrayList<>(result);
        */
        Set<List<Integer>> result = new HashSet<>();
        
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        // Step 2: Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i]; // Target for the two-sum
            int left = i + 1;
            int right = nums.length - 1;
            
            // Step 3: Two-pointer approach
            while (left < right) {
                int sum = nums[left] + nums[right];
                
                if (sum == target) {
                    // Add triplet to the set (automatically handles duplicates)
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < target) {
                    left++; // Increase the left pointer if the sum is too small
                } else {
                    right--; // Decrease the right pointer if the sum is too large
                }
            }
        }
        
        return new ArrayList<>(result);
    }
}