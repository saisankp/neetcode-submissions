class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        
        for(String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            //sorted string -> list of original strings
            map.put(key, list);
        }

        return new ArrayList<>(map.values());

    }
}
