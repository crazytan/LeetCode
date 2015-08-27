__author__ = 'tan'


class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums.sort()
        ans = nums[0] + nums[1] + nums[2]
        l = len(nums)
        for start in xrange(l - 2):
            i = start + 1
            j = l - 1
            while i < j:
                sum = nums[start] + nums[i] + nums[j]
                if abs(target - ans) > abs(target - sum):
                    ans = sum
                if sum < target:
                    i += 1
                else:
                    j -= 1
        return ans


if __name__ == '__main__':
    print Solution().threeSumClosest([-1,2,1,-4], 1)
