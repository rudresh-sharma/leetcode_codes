1class Solution {
2
3    public int maximumLengthSubstring(String s) {
4        int[] count = new int[26];
5        int left = 0;
6        int res = 0;
7        for (int right = 0; right < s.length(); right++) {
8            int ch = s.charAt(right) - 'a';
9            count[ch]++;
10            while (count[ch] > 2) {
11                int ch2 = s.charAt(left) - 'a';
12                count[ch2]--;
13                left++;
14            }
15            res = Math.max(res, right - left + 1);
16        }
17        return res;
18    }
19}