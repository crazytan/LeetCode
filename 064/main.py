class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if not len(grid):
            return 0
        if len(grid) == 1:
            return sum(grid[0])
        if len(grid[0]) == 1:
            return reduce(lambda x, y: x + y[0], grid, 0)
        n = len(grid)
        m = len(grid[0])
        f = [[0 for j in range(m)] for i in range(n)]
        f[0][0] = grid[0][0]
        for i in range(1, n):
            f[i][0] = f[i-1][0] + grid[i][0]
        for i in range(1, m):
            f[0][i] = f[0][i-1] + grid[0][i]
        for i in range(1, n):
            for j in range(1, m):
                f[i][j] = min(f[i-1][j],f[i][j-1]) + grid[i][j]
        return f[n-1][m-1]

if __name__ == "__main__":
    print Solution().minPathSum([[1],[2],[3]])
