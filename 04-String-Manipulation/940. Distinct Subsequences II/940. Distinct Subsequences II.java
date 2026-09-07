1class Solution {
2    int MOD = 1000000007;
3
4    public int distinctSubseqII(String s) {
5        int tot = 0;
6        int[] dp = new int[26];
7
8        for (int i = 0; i < s.length(); i++) {
9            int c = s.charAt(i) - 97;
10            int add = (tot - dp[c] + MOD) % MOD;
11
12            dp[c] = 1 + tot;
13            tot = (dp[c] + add) % MOD;
14        }
15
16        return tot;
17    }
18}