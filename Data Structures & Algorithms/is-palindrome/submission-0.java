class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] c = s.toCharArray();
        for (int i = 0, j = c.length - 1; i < j; i++, j--) {

            char pointerA = c[i];
            char pointerB = c[j];

            if(!(pointerA == pointerB)) {
                return false;
            }
        }
        return true;
    }
}
