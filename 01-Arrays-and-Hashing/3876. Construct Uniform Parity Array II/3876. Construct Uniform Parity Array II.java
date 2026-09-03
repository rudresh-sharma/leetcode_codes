1class Solution {
2    public boolean uniformArray(int[] nums1) {
3        int min = nums1[0];
4        boolean hasOdd = false;
5
6        for (int num : nums1) {
7            if (num < min) min = num;
8            if ((num & 1) != 0) hasOdd = true;
9        }
10
11        // If the minimum is odd, every even element can subtract it to become odd.
12        if ((min & 1) != 0) return true;
13
14        // If the minimum is even, success only if no odd elements exist at all.
15        return !hasOdd;
16    }
17}