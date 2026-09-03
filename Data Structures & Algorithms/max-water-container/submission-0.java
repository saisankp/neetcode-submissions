class Solution {
    public int maxArea(int[] heights) {
        // area = height x length
        // height = heights[i] until height[j] where one of min(i,j) is used
        // length = range of indexes between heights[i] and heights[j]...i.e. number of indexes between i and j.
        int pointerA = 0;
        int pointerB = heights.length-1;
        int maxHeight = 0; 

        while(pointerA != pointerB) {
            int height = Math.min(heights[pointerA], heights[pointerB]);
            int length = pointerB - pointerA;
            int area = height * length;
            if(maxHeight < area) {
                maxHeight = area;
            }
                // move smaller height to right
                if(heights[pointerA] < heights[pointerB]) {
                    pointerA++;
                } else {
                    pointerB--;
                }
        
        }

        return maxHeight;

    }
}
