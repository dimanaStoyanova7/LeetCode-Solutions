class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
         int n = nums.length;
        // if (k == 0) { // need sum 0 with length >= 2 -> two consecutive zeros
        //     for (int i = 1; i < n; i++) if (nums[i] == 0 && nums[i - 1] == 0) return true;
        //     return false;
        // }
        // if (k < 0) k = -k; // optional normalize

        Map<Integer, Integer> firstIndex = new HashMap<>();
        firstIndex.put(0, -1); // remainder 0 at index -1

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int r = sum % k;
            if (r < 0) r += k; // safe mod

            if (firstIndex.containsKey(r)) {
                if (i - firstIndex.get(r) >= 2) return true;
            } else {
                firstIndex.put(r, i); // only store first occurrence
            }
        }
        return false;
    }
}