1class Solution {
2    public int minEatingSpeed(int[] piles, int h) {
3        int lo = 1, hi = 0;
4        for (int p : piles) hi = Math.max(hi, p);
5
6        while (lo < hi) {
7            int mid = lo + (hi - lo) / 2;
8            if (hoursNeeded(piles, mid) <= h) {
9                hi = mid;       // mid works, try smaller k
10            } else {
11                lo = mid + 1;   // mid too slow, need bigger k
12            }
13        }
14        return hi;
15    }
16
17    private long hoursNeeded(int[] piles, int k) {
18        long hours = 0;
19        for (int p : piles) {
20            hours += (p + k - 1) / k;   // ceil(p / k)
21        }
22        return hours;
23    }
24}