1class Solution {
2    public int totalNumbers(int[] digits) {
3        int[] freq = new int[10];
4        for (int d : digits) freq[d]++;
5
6        int N = 0, z = 0, Ne = 0, n2 = 0, m = 0, p5 = 0;
7        for (int d = 0; d <= 9; d++) {
8            if (freq[d] == 0) continue;
9            N++;
10            boolean even = (d % 2 == 0);
11            if (d == 0) z = 1;
12            if (even) Ne++;
13            if (d != 0 && freq[d] >= 2) n2++;
14            if (d != 0 && even && freq[d] >= 2) m++;
15            if (d != 0 && even && freq[d] >= 3) p5++;
16        }
17
18        int Az = N - z;
19        int P5 = p5;
20        int P4 = (freq[0] >= 2 ? Az : 0) + m * (Az - 1);
21        int P3 = m * (N - 1);
22        int P2 = n2 * Ne - m;
23        int P1 = (N < 3) ? 0 : (N - 2) * (z * (N - z) + (Ne - z) * (N - z - 1));
24
25        return P1 + P2 + P3 + P4 + P5;
26    }
27}