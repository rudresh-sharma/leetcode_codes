class Solution:
    def gcdValues(self, nums: List[int], queries: List[int]) -> List[int]:
        max_num = max(nums)
        
        # cnt[x] stores how many times x appears in nums
        cnt = [0] * (max_num + 1)
        for x in nums:
            cnt[x] += 1
            
        exact_gcd = [0] * (max_num + 1)
        
        # Calculate exact_gcd backwards
        for g in range(max_num, 0, -1):
            # Count how many numbers in nums are multiples of g
            multiples_count = 0
            for m in range(g, max_num + 1, g):
                multiples_count += cnt[m]
            
            # Calculate pairs where both numbers are multiples of g
            pairs = multiples_count * (multiples_count - 1) // 2
            
            # Subtract pairs where the exact GCD is a multiple of g, but strictly greater than g
            for m in range(g * 2, max_num + 1, g):
                pairs -= exact_gcd[m]
                
            exact_gcd[g] = pairs
            
        # Prefix sums for binary search
        # prefix[g] will store the total number of pairs with GCD <= g
        prefix = [0] * (max_num + 1)
        for g in range(1, max_num + 1):
            prefix[g] = prefix[g - 1] + exact_gcd[g]
            
        # Answer each query
        ans = []
        for q in queries:
            # bisect_right finds the smallest GCD index g where prefix[g] > q
            ans.append(bisect.bisect_right(prefix, q))
            
        return ans