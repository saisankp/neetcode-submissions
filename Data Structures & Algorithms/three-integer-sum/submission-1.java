class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet();
        Arrays.sort(nums); // n log n
        //Input: nums = [-1,0,1,2,-1,-4]
        // [-4, -1, -1,0, 1, 2 ], // target = 0 for 3 indexes
        for(int i=0; i<nums.length; i++) {
           int j = i + 1;
           int k = nums.length -1;
           while(j < k) {
            int attempt = nums[i] + nums[j] + nums[k];
            if (attempt < 0) {
                j++; // too low, increase lower bound
            } else if (attempt > 0) {
                k--; //too high, decrease upper bound
            } else {
                //equal to 0, found a pair. Store.
                List<Integer> list = new ArrayList<Integer>();
                list.add(nums[i]);
                list.add(nums[j]);
                list.add(nums[k]);
                set.add(list);
                // dont forget to move pointers for next approach
                j++;
                k--;
            }
           }
        }
        List<List<Integer>> result = new ArrayList<>(set);
        return result;
    }
}
