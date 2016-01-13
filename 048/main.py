class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        if (not matrix) or (len(matrix) <= 1):
            return
        n = len(matrix)
        for i in range(n/2):
            if (n % 2) == 0:
                l = n/2
            else:
                l = n/2 + 1
            for j in range(l):
                x1, y1 = i, j
                x2, y2 = self._rotate(x1, y1, n)
                x3, y3 = self._rotate(x2, y2, n)
                x4, y4 = self._rotate(x3, y3, n)
                matrix[x1][y1], matrix[x2][y2], matrix[x3][y3], matrix[x4][y4] = matrix[x4][y4], matrix[x1][y1], matrix[x2][y2], matrix[x3][y3]

    def _rotate(self, x, y, n):
        return y, n - x - 1

if __name__ == "__main__":
    matrix = [[1,2,3],[4,5,6],[7,8,9]]
    Solution().rotate(matrix)
    print matrix
