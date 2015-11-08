class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        b = 0
        l = 0
        r = len(nums)
        while True:
            _l = l
            _r = r
            while _l < _r:
                if nums[_l] & (1 << b):
                    _r -= 1
                    nums[_l], nums[_r] = nums[_r], nums[_l]
                else:
                    _l += 1
            if (l + 1) == _l:
                return nums[l]
            if (_r + 1) == r:
                return nums[_r]
            if (_l - l) % 2:
                r = _l
            else:
                l = _r
            b += 1


if __name__ == "__main__":
    print Solution().singleNumber([98, 92, 92, 97, 97, 13, 13, 22, 22])
