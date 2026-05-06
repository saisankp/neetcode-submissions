class Solution {
    public int[] twoSum(int[] nums, int target) {
        //[3,4,5,6] -> 7
        //[0,1]

        //[4,5,6] -> 10
        //[0, 2]

        HashMap<Integer, Integer> hm = new HashMap<>();
        // key -> values
        // lookingFor -> nums[i]
        // 3 -> 4
        // hm.get(4)
        // .getOrDefault(value, 0)
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
