1class Solution {
2    static final int MOD = 1_000_000_007;
3    long[] val, pow10, prefSum;
4    int[] cnt;
5    char[] s;
6
7    public int[] sumAndMultiply(String str, int[][] queries) {
8        s = str.toCharArray();
9        int n = s.length;
10        pow10 = new long[n + 1];
11        prefSum = new long[n + 1];
12        pow10[0] = 1;
13        for (int i = 1; i <= n; i++) pow10[i] = pow10[i - 1] * 10 % MOD;
14        for (int i = 0; i < n; i++) prefSum[i + 1] = prefSum[i] + (s[i] - '0');
15
16        val = new long[4 * n];
17        cnt = new int[4 * n];
18        build(1, 0, n - 1);
19
20        int[] ans = new int[queries.length];
21        for (int i = 0; i < queries.length; i++) {
22            int l = queries[i][0], r = queries[i][1];
23            long[] res = query(1, 0, n - 1, l, r);
24            long sum = (prefSum[r + 1] - prefSum[l]) % MOD;
25            ans[i] = (int) (res[0] * sum % MOD);
26        }
27        return ans;
28    }
29
30    void build(int node, int l, int r) {
31        if (l == r) {
32            int d = s[l] - '0';
33            cnt[node] = d == 0 ? 0 : 1;
34            val[node] = d;
35            return;
36        }
37        int m = (l + r) / 2;
38        build(2 * node, l, m);
39        build(2 * node + 1, m + 1, r);
40        cnt[node] = cnt[2 * node] + cnt[2 * node + 1];
41        val[node] = (val[2 * node] * pow10[cnt[2 * node + 1]] + val[2 * node + 1]) % MOD;
42    }
43
44    long[] query(int node, int l, int r, int ql, int qr) {
45        if (qr < l || r < ql) return new long[]{0, 0};
46        if (ql <= l && r <= qr) return new long[]{val[node], cnt[node]};
47        int m = (l + r) / 2;
48        long[] a = query(2 * node, l, m, ql, qr);
49        long[] b = query(2 * node + 1, m + 1, r, ql, qr);
50        return new long[]{(a[0] * pow10[(int) b[1]] + b[0]) % MOD, a[1] + b[1]};
51    }
52}