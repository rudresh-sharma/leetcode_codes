1class Solution {
2
3    public long gcdSum(int[] nums) {
4        int n = nums.length;
5
6        int[] mx = new int[n];
7        int prefixMax = Integer.MIN_VALUE;
8
9        for (int i = 0; i < n; ++i) {
10            prefixMax = Math.max(prefixMax, nums[i]);
11            mx[i] = prefixMax;
12        }
13
14        int[] prefixGcd = new int[n];
15        for (int i = 0; i < n; ++i) {
16            prefixGcd[i] = gcd(nums[i], mx[i]);
17        }
18
19        Arrays.sort(prefixGcd);
20
21        long ans = 0;
22        int left = 0,
23            right = n - 1;
24        while (left < right) {
25            ans += gcd(prefixGcd[left], prefixGcd[right]);
26            ++left;
27            --right;
28        }
29
30        return ans;
31    }
32
33    public int gcd(int num1, int num2) {
34        while (num2 != 0) {
35            int temp = num1;
36            num1 = num2;
37            num2 = temp % num2;
38        }
39        return num1;
40    }
41}