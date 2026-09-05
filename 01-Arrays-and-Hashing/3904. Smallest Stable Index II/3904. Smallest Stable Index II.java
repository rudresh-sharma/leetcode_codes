1class Solution {
2    public int firstStableIndex(int[] nums, int k) {
3        int n = nums.length;
4        int[] suffixMin = new int[n];
5        suffixMin[n - 1] = nums[n - 1];
6        for (int i = n - 2; i >= 0; i--) {
7            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
8        }
9
10        int runningMax = Integer.MIN_VALUE;
11        for (int i = 0; i < n; i++) {
12            runningMax = Math.max(runningMax, nums[i]);
13            if (runningMax - suffixMin[i] <= k) {
14                return i;
15            }
16        }
17        return -1;
18    }
19}