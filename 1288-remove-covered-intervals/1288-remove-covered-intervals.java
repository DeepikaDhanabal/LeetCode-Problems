class Solution {
    public static int removeCoveredIntervals(int[][] intervals) {
        int count = 0;

        for (int i = 0; i < intervals.length; i++) {
            boolean covered = false;
            for (int j = 0; j < intervals.length; j++) {
                if (i == j)
                    continue;
                if (intervals[j][0] <= intervals[i][0] &&
                    intervals[i][1] <= intervals[j][1]) {
                    covered = true;
                    break;
                }
            }

            if (!covered)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {

        int[][] intervals = {
                {1,4},
                {3,6},
                {2,8}
        };

        System.out.println(removeCoveredIntervals(intervals));
    }
}
    
