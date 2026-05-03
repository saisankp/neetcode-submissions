class Solution {
    public boolean isAnagram(String s, String t) {
        //DS: hashmap
        char[] sToCharArray = s.toCharArray();
        char[] tToCharArray = t.toCharArray();

        HashMap<Character, Integer> hms = new HashMap<>();
        HashMap<Character, Integer> hmt = new HashMap<>();

        for(int i=0; i<sToCharArray.length; i++) {
            hms.put(sToCharArray[i], hms.getOrDefault(sToCharArray[i], 0) + 1);
        }

        for(int i=0; i<tToCharArray.length; i++) {
            hmt.put(tToCharArray[i], hmt.getOrDefault(tToCharArray[i], 0) + 1);
        }

        // r = 2 hmt

        // r = 1 hms

        // Check if both hashmaps equal
        return hms.equals(hmt);

    }
}
