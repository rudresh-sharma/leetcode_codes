1class Solution {
2    public int maximumProduct(int[] nums) {
3        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
4        int minFirst = Integer.MAX_VALUE, minSecond = Integer.MAX_VALUE;
5
6        for (int n : nums) {
7            // track three largest
8            if (n > first) {
9                third = second;
10                second = first;
11                first = n;
12            } else if (n > second) {
13                third = second;
14                second = n;
15            } else if (n > third) {
16                third = n;
17            }
18
19            // track two smallest
20            if (n < minFirst) {
21                minSecond = minFirst;
22                minFirst = n;
23            } else if (n < minSecond) {
24                minSecond = n;
25            }
26        }
27
28        return Math.max(first * second * third, first * minFirst * minSecond);
29    }
30}