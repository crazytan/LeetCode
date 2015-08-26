__author__ = 'tan'


class Solution:
    # @param {integer[][]} dungeon
    # @return {integer}
    def calculateMinimumHP(self, dungeon):
        m = len(dungeon)
        n = len(dungeon[0])
        i = 0
        j = 0
        life = dungeon[0][0]
        r = -dungeon[0][0] + 1 if dungeon[0][0] < 0 else 1
        while (i < m - 1) or (j < n - 1):
            if j < n - 1:
                j += 1
                life += dungeon[i][j]
            else:
                i += 1
                life += dungeon[i][j]
            if (life < 0) and (-life + 1 > r):
                r = -life + 1

        l = 1
        while l < r:
            mid = (l + r) / 2
            if self.validate(mid, dungeon):
                r = mid
            else:
                l = mid + 1
        return l

    def validate(self, health, dungeon):
        m = len(dungeon)
        n = len(dungeon[0])
        max_health = [[-1 for j in range(n)] for i in range(m)]
        max_health[0][0] = health + dungeon[0][0]
        if max_health[0][0] <= 0:
            return False
        for i in xrange(m):
            for j in xrange(n):
                if i == 0 and j == 0:
                    pass
                if j > 0 and max_health[i][j - 1] > 0:
                    max_health[i][j] = max_health[i][j - 1] + dungeon[i][j]
                if i > 0 and max_health[i - 1][j] > 0:
                    max_health[i][j] = max(max_health[i][j], max_health[i - 1][j] + dungeon[i][j])
        return max_health[-1][-1] > 0


if __name__ == '__main__':
    print Solution().calculateMinimumHP([[0, -3]])
