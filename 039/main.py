class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        if len(candidates) <= 0:
            return []
        candidates = sorted(candidates)
        f = [False for i in range(target + 1)]
        prev = [[] for i in range(target + 1)]
        f[0] = True
        for candidate in candidates:
            for i in range(target):
                if f[i] and ((i + candidate) <= target):
                    f[i + candidate] = True
                    prev[i + candidate].append(i)
        if f[target]:
            ans = []
            self.add(target, [], max(candidates), prev, ans)
            return ans
        else:
            return []

    def add(self, now, comb, max, prev, ans):
        if not now:
            ans.append(comb)
            return
        for p in prev[now]:
            if (now - p) <= max:
                self.add(p, [now - p] + comb, now - p, prev, ans)

if __name__ == "__main__":
    print Solution().combinationSum([8,7,4,3], 11)
