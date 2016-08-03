class Solution(object):
    def get_range(self, lower, upper):
        if lower == upper:
            return str(lower)
        return str(lower) + '->' + str(upper)

    def findMissingRanges(self, nums, lower, upper):
        """
        :type nums: List[int]
        :type lower: int
        :type upper: int
        :rtype: List[str]
        """
        if not len(nums):
            return [self.get_range(lower, upper)]
        ans = []
        if nums[0] > lower:
            ans.append(self.get_range(lower, nums[0] - 1))
        current = nums[0]
        for i in range(1, len(nums)):
            if nums[i] > (current + 1):
                ans.append(self.get_range(current + 1, nums[i] - 1))
            current = nums[i]
        if current < upper:
            ans.append(self.get_range(current + 1, upper))
        return ans

if __name__ == "__main__":
    print Solution().findMissingRanges([3], 0, 99)
