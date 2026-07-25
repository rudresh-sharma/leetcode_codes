1class Solution {
2
3    public int maxProduct(int n) {
4        int first = 0,
5            second = 0;
6        while (n > 0) {
7            int x = n % 10;
8            if (x > first) {
9                second = first;
10                first = x;
11            } else if (x > second) {
12                second = x;
13            }
14            n /= 10;
15        }
16        return first * second;
17    }
18}