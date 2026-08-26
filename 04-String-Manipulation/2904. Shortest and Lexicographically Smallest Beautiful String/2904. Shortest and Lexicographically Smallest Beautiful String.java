1class Solution {
2
3    public String shortestBeautifulSubstring(String s, int k) {
4        int total = 0;
5        for (int i = 0; i < s.length(); i++) total += s.charAt(i) - '0';
6        if (total < k) return ;
7        String ans = s;
8        int cnt = 0,
9            left = 0;
10        for (int right = 0; right < s.length(); right++) {
11            cnt += s.charAt(right) - '0';
12            while (cnt > k || s.charAt(left) == '0') {
13                cnt -= s.charAt(left++) - '0';
14            }
15            if (cnt == k) {
16                String t = s.substring(left, right + 1);
17                if (
18                    t.length() < ans.length() ||
19                    (t.length() == ans.length() && t.compareTo(ans) < 0)
20                ) {
21                    ans = t;
22                }
23            }
24        }
25        return ans;
26    }
27}