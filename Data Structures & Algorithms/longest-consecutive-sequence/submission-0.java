class Solution {
    public int longestConsecutive(int[] nums) {
        // O(N)  = 1 loop
        // n log n
        // nums = [0,3,2,5,4,6,1,1]
        // [ 0,1,2, 3,4,5,6].contains()
        HashSet<Integer> hs = new HashSet();
        for(int i=0; i<nums.length; i++) { // O(N)
            hs.add(nums[i]);
        }
        
        // [ 0,1,2, 3,4,5,6].contains()
        int max = 0;
        for(int num : hs) {
            if(hs.contains(num-1)) {
                // num is not the start

            } else {
                // num is the start
                int length = 1;
                int current = num;
                while(hs.contains(current+1)) {
                    current++;
                    length++;
                }
                max = Math.max(max, length);
            }
        }
        return max;

        
        
    }
}
