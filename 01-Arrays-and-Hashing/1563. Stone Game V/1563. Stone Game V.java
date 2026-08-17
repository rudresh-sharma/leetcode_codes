1class Solution {
2
3    int[][] f;
4    int[][] maxl;
5    int[][] maxr;
6
7    public int stoneGameV(int[] stoneValue) {
8        int n = stoneValue.length;
9        f = new int[n][n];
10        maxl = new int[n][n];
11        maxr = new int[n][n];
12        for (int left = n - 1; left >= 0; --left) {
13            maxl[left][left] = maxr[left][left] = stoneValue[left];
14            int sum = stoneValue[left],
15                suml = 0;
16            for (int right = left + 1, i = left - 1; right < n; ++right) {
17                sum += stoneValue[right];
18                while (i + 1 < right && (suml + stoneValue[i + 1]) * 2 <= sum) {
19                    suml += stoneValue[i + 1];
20                    ++i;
21                }
22                if (left <= i) {
23                    f[left][right] = Math.max(f[left][right], maxl[left][i]);
24                }
25                if (i + 1 < right) {
26                    f[left][right] = Math.max(
27                        f[left][right],
28                        maxr[i + 2][right]
29                    );
30                }
31                if (suml * 2 == sum) {
32                    f[left][right] = Math.max(
33                        f[left][right],
34                        maxr[i + 1][right]
35                    );
36                }
37                maxl[left][right] = Math.max(
38                    maxl[left][right - 1],
39                    sum + f[left][right]
40                );
41                maxr[left][right] = Math.max(
42                    maxr[left + 1][right],
43                    sum + f[left][right]
44                );
45            }
46        }
47        return f[0][n - 1];
48    }
49}