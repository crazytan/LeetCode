__author__ = 'tan'


class Solution:
    # @param {integer[]} height
    # @return {integer}
    def maxArea(self, height):
        ans = 0
        i = 0
        j = len(height) - 1
        while i < j:
            tmp = (j - i) * min(height[i], height[j])
            if tmp > ans:
                ans = tmp
            if height[i] < height[j]:
                i += 1
            else:
                j -= 1
        return ans

if __name__ == '__main__':
    height = raw_input("enter heights: ").split(',')
    height = map(lambda x: int(x), height)
    print Solution().maxArea(height)
