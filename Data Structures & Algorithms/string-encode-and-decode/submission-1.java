class Solution {

    // String -> hashFunction(string) -> encodedString
    // encodedString -> hashFunctionReverse(encodedString) -> decodedString a.k.a. String
    // character -> cast int -> integer "5|20,4,4,73,84,5,74,9,6|"
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            char[] strCharArray = str.toCharArray();
            sb.append("~" + strCharArray.length + ",");
            for(Character c : strCharArray) {
                int cAsInt = (int) c;
                sb.append(cAsInt + ",");
            }
        }
        return sb.toString();
    }

// "20,4,4,73,84,5,74,9"
// "20" ,"4", "4",....73,84,5,74,9"
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        String[] parts = str.split("~");                            // fix 4

        for (String part : parts) {
            if (part.isEmpty()) continue;                              // fix 5
            String[] numbers = part.split(",");
            int length = Integer.parseInt(numbers[0]);                 // first number = length
            StringBuilder decodedStr = new StringBuilder();
            for (int i = 1; i <= length; i++) {                        // fix 6: only read 'length' numbers
                int cAsInt = Integer.parseInt(numbers[i]);
                decodedStr.append((char) cAsInt);
            }
            result.add(decodedStr.toString());
        }
        return result;
    }
}
