1class Solution {
2    public int[] sumAndMultiply(String s, int[][] queries) {
3        final int MOD = 1_000_000_007;
4        int n = s.length();
5
6        long[] pow10 = new long[n + 1];
7        pow10[0] = 1;
8
9        for (int i = 1; i <= n; i++) {
10            pow10[i] = (pow10[i - 1] * 10) % MOD;
11        }
12
13        // idx[i] = number of non-zero digits before index i
14        int[] idx = new int[n + 1];
15
16        // val[i] = number formed by first i non-zero digits
17        long[] val = new long[n + 1];
18
19        // total[i] = sum of first i non-zero digits
20        long[] total = new long[n + 1];
21
22        int cnt = 0;
23
24        for (int i = 0; i < n; i++) {
25            int digit = s.charAt(i) - '0';
26
27            if (digit != 0) {
28                cnt++;
29                val[cnt] = (val[cnt - 1] * 10 + digit) % MOD;
30                total[cnt] = total[cnt - 1] + digit;
31            }
32
33            idx[i + 1] = cnt;
34        }
35
36        int[] ans = new int[queries.length];
37
38        for (int i = 0; i < queries.length; i++) {
39
40            int l = queries[i][0];
41            int r = queries[i][1];
42
43            int left = idx[l];
44            int right = idx[r + 1];
45
46            // No non-zero digit in the range
47            if (left == right) {
48                ans[i] = 0;
49                continue;
50            }
51
52            int len = right - left;
53            long number = (val[right] - (val[left] * pow10[len]) % MOD) % MOD;
54
55            if (number < 0)
56                number += MOD;
57
58            long sum = total[right] - total[left];
59            ans[i] = (int) ((number * sum) % MOD);
60        }
61
62        return ans;
63    }
64}