1class Solution {
2    public int minDays(int[] bloomDay, int m, int k) {
3        long need = (long) m * k;
4        if (need > bloomDay.length) return -1;
5
6        int lo = 1, hi = 0;
7        for (int d : bloomDay) hi = Math.max(hi, d);
8
9        while (lo < hi) {
10            int mid = lo + (hi - lo) / 2;
11            if (canMake(bloomDay, mid, m, k)) {
12                hi = mid;       // mid works, try earlier day
13            } else {
14                lo = mid + 1;   // mid too early, need more days
15            }
16        }
17        return lo;
18    }
19
20    private boolean canMake(int[] bloomDay, int day, int m, int k) {
21        int bouquets = 0, streak = 0;
22        for (int d : bloomDay) {
23            if (d <= day) {
24                streak++;
25                if (streak == k) {
26                    bouquets++;
27                    streak = 0;
28                }
29            } else {
30                streak = 0;
31            }
32        }
33        return bouquets >= m;
34    }
35}