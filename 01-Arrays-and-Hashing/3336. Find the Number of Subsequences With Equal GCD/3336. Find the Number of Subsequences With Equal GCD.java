1class Solution {
2
3    static final int MOD = 1000000007;
4
5    public int subsequencePairCount(int[] nums) {
6        int m = 0;
7        for (int num : nums) {
8            m = Math.max(m, num);
9        }
10
11        int[][] dp = new int[m + 1][m + 1];
12        dp[0][0] = 1;
13
14        for (int num : nums) {
15            int[][] ndp = new int[m + 1][m + 1];
16            for (int j = 0; j <= m; j++) {
17                int divisor1 = gcd(j, num);
18                for (int k = 0; k <= m; k++) {
19                    int val = dp[j][k];
20                    if (val == 0) {
21                        continue;
22                    }
23                    int divisor2 = gcd(k, num);
24                    ndp[j][k] = (ndp[j][k] + val) % MOD;
25                    ndp[divisor1][k] = (ndp[divisor1][k] + val) % MOD;
26                    ndp[j][divisor2] = (ndp[j][divisor2] + val) % MOD;
27                }
28            }
29            dp = ndp;
30        }
31
32        int ans = 0;
33        for (int j = 1; j <= m; j++) {
34            ans = (ans + dp[j][j]) % MOD;
35        }
36        return ans;
37    }
38
39    private int gcd(int a, int b) {
40        while (b != 0) {
41            int temp = a;
42            a = b;
43            b = temp % b;
44        }
45        return a;
46    }
47}