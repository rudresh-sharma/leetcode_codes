1class Solution {
2    public int firstStableIndex(int[] nums, int k) {
3        int n = nums.length;
4
5        // prefixMax[i] = max(nums[0..i])
6        int[] prefixMax = new int[n];
7        prefixMax[0] = nums[0];
8        for (int i = 1; i < n; i++) {
9            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
10        }
11
12        // suffixMin[i] = min(nums[i..n-1])
13        int[] suffixMin = new int[n];
14        suffixMin[n - 1] = nums[n - 1];
15        for (int i = n - 2; i >= 0; i--) {
16            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
17        }
18
19        // check instability score at each index
20        for (int i = 0; i < n; i++) {
21            int instabilityScore = prefixMax[i] - suffixMin[i];
22            if (instabilityScore <= k) {
23                return i;
24            }
25        }
26
27        return -1;
28    }
29}