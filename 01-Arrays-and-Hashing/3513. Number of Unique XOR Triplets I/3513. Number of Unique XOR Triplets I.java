1class Solution {
2    public int uniqueXorTriplets(int[] nums) {
3        int n = nums.length;
4        int m = n;
5        
6        m |= m >> 1;
7        m |= m >> 2;
8        m |= m >> 4;
9        m |= m >> 8;
10        m |= m >> 16;
11        
12        return (m + 1) >> (3 / (n + 1));
13    }
14}