__author__ = 'tan'


class Solution:
    # @param {integer[]} nums
    # @return {integer[][]}
    def threeSum(self, nums):
        neg = []
        pos = []
        zero = 0
        for num in nums:
            if num < 0:
                neg.append(num)
            elif num > 0:
                pos.append(num)
            else:
                zero += 1
        ans = []

        if zero >= 3:
            ans.append([0, 0, 0])
        neg = sorted(neg)
        pos = sorted(pos)

        if zero >= 1:
            i = 0
            j = len(pos) - 1
            while (i < len(neg)) and (j >= 0):
                if neg[i] + pos[j] == 0:
                    ans.append([neg[i], 0, pos[j]])
                    i = self.forward(neg, i)
                    j = self.backward(pos, j)
                elif neg[i] + pos[j] < 0:
                    i = self.forward(neg, i)
                else:
                    j = self.backward(pos, j)

        i = 0
        while i < len(neg):
            ans.extend(self.find(neg[i], pos))
            i = self.forward(neg, i)

        i = 0
        while i < len(pos):
            ans.extend(self.find(pos[i], neg))
            i = self.forward(pos, i)

        return ans

    def find(self, tar, nums):
        ans = []
        i = 0
        j = len(nums) - 1
        while i < j:
            if nums[i] + nums[j] + tar == 0:
                if tar < 0:
                    ans.append([tar, nums[i], nums[j]])
                else:
                    ans.append([nums[i], nums[j], tar])
                i = self.forward(nums, i)
                j = self.backward(nums, j)
            elif nums[i] + nums[j] + tar < 0:
                i = self.forward(nums, i)
            else:
                j = self.backward(nums, j)
        return ans

    def forward(self, nums, i):
        while ((i+1) < len(nums)) and (nums[i+1] == nums[i]):
            i += 1
        return i + 1

    def backward(self, nums, i):
        while (i > 0) and (nums[i-1] == nums[i]):
            i -= 1
        return i - 1


if __name__ == '__main__':
    s = raw_input("enter the integers: ").split(',')
    print Solution().threeSum(map(lambda x: int(x), s))
