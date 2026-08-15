1class Solution {
2
3    public int longestSubsequence(int[] nums) {
4        int n = nums.length;
5        int totalXor = 0;
6        boolean allZero = true;
7
8        for (int x : nums) {
9            totalXor ^= x;
10            if (x > 0) {
11                allZero = false;
12            }
13        }
14        if (totalXor > 0) {
15            return n;
16        }
17
18        return allZero ? 0 : n - 1;
19    }
20}