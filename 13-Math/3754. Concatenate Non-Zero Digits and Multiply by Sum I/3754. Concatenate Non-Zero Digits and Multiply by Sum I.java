1class Solution {
2    public long sumAndMultiply(int n) {
3        if (n == 0) return 0;
4
5        // Reverse n
6        int rev = 0;
7        int temp = n;
8        while (temp > 0) {
9            rev = rev * 10 + temp % 10;
10            temp /= 10;
11        }
12
13        long num = 0;
14        long sum = 0;
15
16        while (rev > 0) {
17            int digit = rev % 10;
18            if (digit != 0) {
19                num = num * 10 + digit;
20                sum += digit;
21            }
22            rev /= 10;
23        }
24
25        return num * sum;
26    }
27}