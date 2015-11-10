class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if not matrix:
            return 0
        l = len(matrix)
        w = len(matrix[0])
        ans = 0
        f = [[0 for i in range(w)] for j in range(l)]
        for i in range(l):
            for j in range(w):
                if (not i) or (not j) or ('0' == matrix[i][j]):
                    if '1' == matrix[i][j]:
                        f[i][j] = 1
                    else:
                        f[i][j] = 0
                else:
                    if f[i-1][j] != f[i][j-1]:
                        f[i][j] = min(f[i-1][j],f[i][j-1])+1
                    else:
                        s = f[i-1][j]
                        if '1' == matrix[i-s][j-s]:
                            f[i][j] = s+1
                        else:
                            f[i][j] = s
                if f[i][j] > ans:
                    ans = f[i][j]
        return ans * ans


if __name__ == "__main__":
#    print Solution().maximalSquare([['1','0','1','0','0'],['1','0','1','1','1'],['1','1','1','1','1'],['1','0','0','1','0']])
#    print Solution().maximalSquare([['1','0','1','0','0'],['1','0','1','1','1'],['1','1','1','1','1'],['1','0','1','1','1']])
    print Solution().maximalSquare([['0']])
