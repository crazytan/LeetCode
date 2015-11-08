class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        min_n = min(nums)
        if min_n < 0:
            for i in range(len(nums)):
                nums[i] -= min_n
        ans = 0
        b = 1
        while True:
            less = False
            cnt = 0
            for num in nums:
                if num & b:
                    cnt += 1
                if num >= b:
                    less = True
            if not less:
                break
            if cnt % 3:
                ans |= b
            b <<= 1
        if min_n < 0:
            return ans + min_n
        else:
            return ans

if __name__ == "__main__":
    print Solution().singleNumber([-2,-2,1,1,-3,1,-3,-3,-4,-2])
