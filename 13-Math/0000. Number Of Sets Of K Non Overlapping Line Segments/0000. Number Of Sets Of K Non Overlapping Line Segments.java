1class Solution {
2
3    private static final int MOD = 1000000007;
4
5    public int numberOfSets(int n, int k) {
6        int[] dp = new int[n];
7        int[] prefixSums = new int[n + 1];
8        for (int j = 0; j < n; j++) {
9            dp[j] = 1;
10            prefixSums[j + 1] = (prefixSums[j] + dp[j]) % MOD;
11        }
12        for (int i = 1; i <= k; i++) {
13            dp[0] = 0;
14            for (int j = 1; j < n; j++) {
15                dp[j] = (dp[j - 1] + prefixSums[j]) % MOD;
16            }
17            for (int j = 0; j < n; j++) {
18                prefixSums[j + 1] = (prefixSums[j] + dp[j]) % MOD;
19            }
20        }
21        return dp[n - 1];
22    }
23}