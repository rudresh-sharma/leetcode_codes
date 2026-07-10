1class Solution {
2    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
3        int[][] newNums = new int[n][2];
4        for (int i = 0; i < n; i++) newNums[i] = new int[]{nums[i], i};
5        Arrays.sort(newNums, (a, b) -> a[0] - b[0]);
6
7        int[] getI = new int[n];
8        for (int i = 0; i < n; i++) getI[newNums[i][1]] = i;
9
10        int[][] st = new int[n][18];
11        int r = 0;
12        for (int i = 0; i < n; i++) {
13            if (r < i) r = i;
14            while (r + 1 < n &&
15                   newNums[r + 1][0] - newNums[r][0] <= maxDiff &&
16                   newNums[r + 1][0] - newNums[i][0] <= maxDiff)
17                r++;
18            st[i][0] = r;
19        }
20
21        for (int j = 1; j < 18; j++)
22            for (int i = 0; i < n; i++)
23                st[i][j] = st[st[i][j - 1]][j - 1];
24
25        int[] ans = new int[queries.length];
26        for (int i = 0; i < queries.length; i++) {
27            int a = getI[queries[i][0]], b = getI[queries[i][1]];
28            if (a > b) { int t = a; a = b; b = t; }
29            if (a == b) { ans[i] = 0; continue; }
30
31            int curr = a, steps = 0;
32            for (int j = 17; j >= 0; j--)
33                if (st[curr][j] < b) { curr = st[curr][j]; steps += (1 << j); }
34
35            ans[i] = (st[curr][0] >= b) ? steps + 1 : -1;
36        }
37        return ans;
38    }
39}