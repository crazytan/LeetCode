class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def firstMissingPositive(self, nums):
        if not nums:
            return 1
        i = 0
        l = len(nums)
        while i < l:
            n = nums[i]
            if n == (i + 1):
                i += 1
            elif (n <= 0) or (n > l) or (n == nums[n - 1]):
                l -= 1
                nums[i], nums[l] = nums[l], nums[i]
            else:
                nums[i], nums[n - 1] = nums[n - 1], n
        return l + 1

if __name__ == "__main__":
    nums = raw_input("enter the list: ").split(',')
    print Solution().firstMissingPositive(map(lambda x: int(x), nums))
