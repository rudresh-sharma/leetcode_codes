1constexpr uint8_t GCD[10][10] = {
2    {},
3    {1},
4    {2, 1},
5    {3, 1, 1},
6    {4, 1, 2, 1},
7    {5, 1, 1, 1, 1},
8    {6, 1, 2, 3, 2, 1},
9    {7, 1, 1, 1, 1, 1, 1},
10    {8, 1, 2, 1, 4, 1, 2, 1},
11    {9, 1, 1, 3, 1, 1, 3, 1, 1},
12};
13
14constexpr int MAXN = 200'001;
15long long rem[MAXN];
16char buf[MAXN + 1];
17
18class Solution {
19public:
20    string smallestNumber(string num, long long t) {
21        long long temp = t >> __builtin_ctzll(t);
22        for (int i : {3, 5, 7})
23            while (temp % i == 0)
24                temp /= i;
25
26        if (temp > 1)
27            return -1;
28
29        int n = num.length();
30        rem[0] = t, rem[n] = 0;
31        int pos = n - 1;
32        for (int i = 0; i < n; i++) {
33            if (num[i] == '0') {
34                pos = i;
35                break;
36            }
37            long long digit = num[i] - '0';
38            rem[i + 1] = rem[i] / GCD[digit][rem[i] % digit];
39        }
40        if (rem[n] == 1)
41            return num;
42
43        for (int i = pos; i >= 0; i--) {
44            while (++num[i] <= '9') {
45                long long digit = num[i] - '0';
46                auto curr = rem[i] / GCD[digit][rem[i] % digit];
47                int k = 9;
48                for (int j = n - 1; j > i; j--) {
49                    while (curr % k)
50                        k--;
51
52                    curr /= k;
53                    num[j] = '0' + k;
54                }
55                if (curr == 1)
56                    return num;
57            }
58        }
59
60        int p = MAXN + 1;
61        for (int i = 9; i > 1; i--) {
62            while (t % i == 0) {
63                buf[--p] = i + '0';
64                t /= i;
65            }
66        }
67
68        while (MAXN - p < n)
69            buf[--p] = '1';
70
71        return string(buf + p, MAXN + 1 - p);
72    }
73};