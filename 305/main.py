class Solution(object):
    dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]

    def check_bound(self, x, y, m, n):
        return (x >= 0) and (y >= 0) and (x < m) and (y < n)

    def find_root(self, x, y, root):
        if (root[x][y][0] == x) and (root[x][y][1] == y):
            return root[x][y]
        root[x][y] = self.find_root(root[x][y][0], root[x][y][1], root)
        return root[x][y]

    def numIslands2(self, m, n, positions):
        """
        :type m: int
        :type n: int
        :type positions: List[List[int]]
        :rtype: List[int]
        """
        if not len(positions):
            return []
        ans = []
        cnt = 0
        root = [[[] for _ in range(n)] for _ in range(m)]
        for position in positions:
            i, j = position
            root[i][j] = [i, j]
            root_map = {}
            roots = []
            for dir in self.dirs:
                _i = i + dir[0]
                _j = j + dir[1]
                if self.check_bound(_i, _j, m, n) and root[_i][_j]:
                    root_i, root_j = self.find_root(_i, _j, root)
                    roots.append((root_i, root_j))
                    root_map[root_i * n + root_j] = True
            for _root in roots:
                root[_root[0]][_root[1]] = [i, j]
            cnt += 1 - len(root_map)
            ans.append(cnt)
        return ans

if __name__ == "__main__":
    print Solution().numIslands2(3, 3, [[0,1],[1,2],[2,1],[1,0],[0,2],[0,0],[1,1]])
