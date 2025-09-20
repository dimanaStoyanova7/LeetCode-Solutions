class Solution {
    // public int longestConsecutive(int[] nums) {

    //    Map<Integer, Integer> starts = new HashMap<>();

    //    for(int i = 0; i < nums.length; i++) {
    //         if(starts.containsKey(nums[i] + 1)) {
    //             int len = starts.get(nums[i] + 1);
    //             starts.put(nums[i], len+1);
    //         }
    //         if(!starts.containsKey(nums[i])){
    //             starts.put(nums[i], 1);
    //         }
    //    }

    //    int maxLen = 0;

    //    Set<Integer> visited = new HashSet<>();

    //    for(int start : starts.keySet()) {
    //         visited.add(start);
    //         int end = start + starts.get(start);
    //         int len = starts.get(start);

    //         while(starts.containsKey(end)){
    //             len += starts.get(end);
    //             end = end + starts.get(end);
    //         }

    //         if(len > maxLen) {
    //             maxLen = len;
    //         }
    //    }

    //    return maxLen;
        
    // }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);

        int best = 0;
        for (int x : nums) {
            if (!set.contains(x)) continue;   // already consumed in some run
            set.remove(x);

            int prev = x - 1, next = x + 1, len = 1;
            while (set.remove(prev)) { prev--; len++; }
            while (set.remove(next)) { next++; len++; }

            best = Math.max(best, len);
        }
        return best;
    }
}

