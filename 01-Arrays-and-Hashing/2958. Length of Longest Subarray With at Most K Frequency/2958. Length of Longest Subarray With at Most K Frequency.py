1class Solution:
2    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
3        freq = {}
4        maxlen = 0
5        i = 0
6
7        for j in range(len(nums)):
8            freq[nums[j]] = freq.get(nums[j], 0) + 1
9
10            while freq[nums[j]] > k:
11                freq[nums[i]] -= 1
12                i += 1
13
14            maxlen = max(maxlen, j - i + 1)
15
16        return maxlen