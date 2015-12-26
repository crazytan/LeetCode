class Solution(object):
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        if len(candidates) <= 0:
            return []
        candidates = sorted(candidates)
        ans = []
        self.dfs([], candidates, 0, target, ans);
        return ans

    def dfs(self, now, candidates, curr, target, ans):
        if not target:
            ans.append(now)
            return
        if target > 0:
            for i in range(curr, len(candidates)):
                if candidates[i] > target:
                    break
                if (i == curr) or (candidates[i] != candidates[i-1]):
                    self.dfs(now + [candidates[i]], candidates, i + 1, target - candidates[i], ans)

if __name__ == "__main__":
    print Solution().combinationSum2([4,4,2,1,4,2,2,1,3], 6)
