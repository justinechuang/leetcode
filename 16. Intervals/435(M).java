/*435. Non-overlapping intervals (Medium)

this is a greedy approach that first sorts by start times
and keeps tracks of the overlap by doing prev[1] = Math.min(prev[1], interval[1]);
--> when two intervals overlap, we remove one and keep the one with the smaller end (the greedy invariant).
*/
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int ans = 0;
        int[] prev = intervals[0]; 
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] < prev[1]) {
                ans++;
                prev[1] = Math.min(prev[1], interval[1]);
            } else {
                prev = interval;
            }
        }
        return ans;
    }
}

//this greedy approach sorts by end time and then keeps track of the last non-overlapping interval and counts overlaps:
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                count++; // overlap
            } else {
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }
}