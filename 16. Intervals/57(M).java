//57. Insert Interval (Medium)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int m = newInterval[0];
        int n = newInterval[1];
        for(int[] interval : intervals){
            int a = interval[0];
            int b = interval[1];
            if(b < m){                      //before - if interval goes before newInterval
                list.add(interval);
            }
            else if(a > n){                 //after - if interval goes after newInterval
                list.add(new int[]{m, n});
                m = interval[0];
                n = interval[1];
            }
            
             else{                          //overlapping - merging intervals
                m = Math.min(m, a);
                n = Math.max(n, b);
            }
        }
        list.add(new int[]{m, n});
        return list.toArray(new int[list.size()][]);
    }
}
