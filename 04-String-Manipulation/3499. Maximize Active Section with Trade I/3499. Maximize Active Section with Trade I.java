1class Solution {
2    public int maxActiveSectionsAfterTrade(String s) {
3        int ones = 0;
4        for (char c : s.toCharArray())
5            if (c == '1')
6                ones++;
7
8        s = 1 + s + 1;
9
10        int n = s.length();
11        int i = 0;
12
13        int ans = ones;
14
15        // Skip first 1's
16        while (i < n && s.charAt(i) == '1')
17            i++;
18
19        // Read first 0-block
20        int c10 = 0;
21        while (i < n && s.charAt(i) == '0') {
22            c10++;
23            i++;
24        }
25
26        while (i < n) {
27
28            // Read middle 1-block
29            int c11 = 0;
30            while (i < n && s.charAt(i) == '1') {
31                c11++;
32                i++;
33            }
34
35            if (c11 == 0)
36                break;
37
38            // Read right 0-block
39            int c20 = 0;
40            while (i < n && s.charAt(i) == '0') {
41                c20++;
42                i++;
43            }
44
45            if (c20 == 0)
46                break;
47
48            ans = Math.max(ans, ones + c10 + c20);
49
50            // Slide the window
51            c10 = c20;
52        }
53
54        return ans;
55    }
56}