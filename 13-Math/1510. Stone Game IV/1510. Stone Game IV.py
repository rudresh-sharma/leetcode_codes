1class Solution:
2    def winnerSquareGame(self, n: int) -> bool:
3        @cache
4        def dfs(i):
5            if i == 0: return False
6
7            for j in range(1, isqrt(i) + 1):
8                if not dfs(i - j ** 2): return True
9
10            return False
11
12        return dfs(n)