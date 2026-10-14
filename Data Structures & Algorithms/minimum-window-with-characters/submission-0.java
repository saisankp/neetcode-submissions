class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char c : t.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        // NOW HS HAS MAPPINGS OF CHAR -> FREQUENCY FROM CHARS IN T.

        char[] sIterable = s.toCharArray();
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        int have = 0;
        int need = t.length();

        while(left < sIterable.length && right < sIterable.length) {
            char current = sIterable[right];
            if(!isInT(current, hm)) {
                right++;
            } else {
                // it is in T
                // check if we have everything we need, need == have
                if (hm.get(current) > 0) {
                    have++;
                }
                hm.put(current, hm.get(current) - 1);

                while(need == have) {
                    int windowLength = right - left +1;

                    if(windowLength < minLength) {
                        minLength = windowLength;
                        minStart = left;
                    }

                    char leftChar = sIterable[left];

                    if (hm.containsKey(leftChar)) {
                        hm.put(leftChar, hm.get(leftChar) + 1);

                        if (hm.get(leftChar) > 0) {
                            have--;
                        }
                    }
                    left++;
                }
                right++;
            }
        }


        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minStart, minStart + minLength);


    }

    // key -> value, character -> integer
    private static boolean isInT(char c, HashMap<Character, Integer> hm) {
        return hm.containsKey(c);
    }
}
