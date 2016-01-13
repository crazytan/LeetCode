class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if (not nums) or (len(nums) == 0):
            return []
        if len(nums) == 1:
            return [nums]
        ans = []
        self._permute(ans, nums, [])
        return ans

    def _permute(self, ans, nums, now):
        if not nums:
            ans.append(now)
            return
        for i in range(len(nums)):
            num = nums.pop(i)
            self._permute(ans, nums, now + [num])
            nums.insert(i, num)

if __name__ == "__main__":
    print Solution().permute([1,2,3])
