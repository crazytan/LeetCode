__author__ = 'tan'

class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer[]}
    def twoSum(self, nums, target):
        table = {}
        index = 0
        for num in nums:
            index += 1
            if num in table:
                return [table[num], index]
            table[target - num] = index

if __name__ == "__main__":
    numbers = raw_input("enter the numbers: ").split(',')
    numbers = map(lambda x: int(x), numbers)
    target = int(raw_input("enter the target: "))
    print Solution().twoSum(numbers, target)