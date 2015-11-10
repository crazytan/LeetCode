class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        _max = 0
        _sum = 0
        zero = False
        for num in nums:
            if not num:
                zero = True
            if num > _max:
                _max = num
            _sum += num
        cal_sum = _max * (_max + 1) / 2
        if cal_sum == _sum:
            if not zero:
                return 0
            else:
                return _max + 1
        return cal_sum - _sum

#        nums.append(-1)
#        i = 0
#        while i < len(nums):
#            while (nums[i] != -1) and (nums[i] != i):
#                t = nums[i]
#                nums[i], nums[t] = nums[t], nums[i]
#            i += 1
#        for i in range(len(nums)):
#            if nums[i] == -1:
#                return i

if __name__ == "__main__":
    print Solution().missingNumber([3,2,1,0])
