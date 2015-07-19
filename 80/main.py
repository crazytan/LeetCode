class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def removeDuplicates(self, nums):
        if len(nums) == 0:
            return 0

        t = False
        p = 1
        for i in xrange(1, len(nums)):
            if nums[i] == nums[i - 1]:
                if not t:
                    t = True
                    nums[p] = nums[i]
                    p += 1
            else:
                t = False
                nums[p] = nums[i]
                p += 1

        print nums
        return p

if __name__ == "__main__":
    s = Solution()
    nums = raw_input("enter the list: ").split(',')
    nums = \
        map(lambda x: int(x), nums)
    print s.removeDuplicates(nums)
