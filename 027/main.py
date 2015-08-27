__author__ = 'tan'

class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        while nums.count(val):
            nums.remove(val)
        return len(nums)

if __name__ == '__main__':
    print Solution().removeElement([1,1,2], 1)
