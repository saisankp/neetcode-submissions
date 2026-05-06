class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int lookingFor = target - nums[i];
            
            if (hm.containsKey(lookingFor)) {
                return new int[] { hm.get(lookingFor), i };
            }
            
            hm.put(nums[i], i);
        }
        
        return new int[] {};
    }
}
