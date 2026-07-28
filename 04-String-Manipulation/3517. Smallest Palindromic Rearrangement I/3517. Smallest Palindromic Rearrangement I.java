1class Solution {
2    public String smallestPalindrome(String s) {
3        int n = s.length(), j = 0;
4        int[] freq = new int[26];
5        char[] chars = s.toCharArray();
6
7        for (int i = 0; i < n >> 1; i++)
8            freq[(chars[i] & 31) - 1]++;
9
10        for (int i = 0; i < 26; i++) {
11            while (freq[i]-- > 0) {
12                chars[j] = (char) (97 + i);
13                chars[n - 1 - j++] = (char) (97 + i);
14            }
15        }
16
17        return new String(chars);
18    }
19}