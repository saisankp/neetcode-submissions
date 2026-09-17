class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int max = 0;
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            hm.put(rightChar, hm.getOrDefault(rightChar, 0) + 1);

            int mostFrequent = getMostFrequentCharFrequency(hm);
            int windowLength = right - left + 1;

            while (windowLength - mostFrequent > k) {
                char leftChar = s.charAt(left);
                hm.put(leftChar, hm.get(leftChar) - 1);
                left++;
                windowLength = right - left + 1;
                mostFrequent = getMostFrequentCharFrequency(hm);
            }

            max = Math.max(max, windowLength);
        }

        return max;
    }

    private int getMostFrequentCharFrequency(HashMap<Character, Integer> hm) {
        int result = 0;
        for (int freq : hm.values()) {
            result = Math.max(result, freq);
        }
        return result;
    }
}