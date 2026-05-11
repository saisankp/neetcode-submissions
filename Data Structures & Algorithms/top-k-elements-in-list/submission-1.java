class Solution {

    
    public int[] topKFrequent(int[] nums, int k) {
        //[1,2,2,3,3,3], k = 2
        //O(N)
        // 1 -> 1
        // 2 -> 2
        // 3 -> 3
        // number -> frequency

        // key -> value

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num: nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: hm.entrySet()) {
            pq.add(entry);
        }

        int[] result = new int[k];
        for(int i=0; i<result.length; i++) {
            result[i] = pq.remove().getKey();
        }

        return result;
    }
}
