class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = [1] + nums + [1]
        n = len(nums)
        f = [[0] * n for i in range(n)]
        for l in range(2, n):
            for i in range(0, n - l):
                j = i + l
                for k in range(i + 1, i + l):
                    tmp = f[i][k] + f[k][j] + nums[i] * nums[k] * nums[j]
                    if tmp > f[i][j]:
                        f[i][j] = tmp
        return f[0][n - 1]

if __name__ == "__main__":
    print Solution().maxCoins([3,1,5,8])
