1class Solution {
2
3    public long countCommas(long n) {
4        long p = 1000, res = 0;
5        while (p <= n) {
6            res += n - p + 1;
7            p *= 1000;
8        }
9        return res;
10    }
11}