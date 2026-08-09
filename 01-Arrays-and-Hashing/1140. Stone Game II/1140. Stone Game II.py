1class Solution:
2    def stoneGameII(self, piles: List[int]) -> int:
3        for i in range(len(piles) - 2, -1, -1):
4            piles[i] += piles[i + 1]
5
6        @cache
7        def dfs(i, M):
8            if i + M * 2 >= len(piles):
9                return piles[i]
10
11            return piles[i] - min(dfs(i + j, max(M, j)) for j in range(1, M * 2 + 1))
12
13        return dfs(0, 1)