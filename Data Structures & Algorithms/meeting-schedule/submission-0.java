/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        // loop through each tuple/interval in the list
        // start from interval[0] to interval[size] and set in hashmap.put()

        // do it for all elements, when doing .put, we check if element exists already, if so return false
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(Interval tuple : intervals) {
            for(int i=tuple.start; i<tuple.end; i++) {
                int getCurr = hm.getOrDefault(i, 0);
                if(getCurr == 1) {
                    return false;
                }
                hm.put(i, 1);
            }
        }
        return true;
    }
}
