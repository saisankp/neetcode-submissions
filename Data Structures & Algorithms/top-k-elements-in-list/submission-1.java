class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // return array = length of k

        // 1 = #1
        // 2 = #2
        // 3 = #3
        // .pop() for k times off a Priority queue where we set priority when initializing
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {
            // negative → a comes before b
            // 0        → same priority
            // positive → b comes before a
            // If:
            // a = 5
            // b = 2
            // then:
            // 2 - 5 = -3
            // Negative → a comes first.
    return b.getValue() - a.getValue();
});
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i =0; i<nums.length; i++) {
            int curr = hm.getOrDefault(nums[i], 0);
            hm.put(nums[i], curr + 1);
        }

        for(Map.Entry<Integer, Integer> entry: hm.entrySet()) {
            // key, value = number, frequency
            pq.add(entry);
        }

        int[] result = new int[k];
        for(int i=0; i<result.length; i++) {
            result[i] = pq.poll().getKey();
        }
        return result;

    }
}
