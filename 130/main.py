__author__ = 'tan'


class Solution:
    # @param {character[][]} board
    # @return {void} Do not return anything, modify board in-place instead.
    def solve(self, board):
        if not any(board):
            return
        if len(board) <= 2:
            return
        board[:] = [[c for c in row] for row in board]
        n, m = len(board), len(board[0])
        for i in range(m):
            if board[0][i] == '0':
                self.fill(board, 0, i)
            if board[-1][i] == '0':
                self.fill(board, n - 1, i)

        for i in range(n):
            if board[i][0] == '0':
                self.fill(board, i, 0)
            if board[i][m - 1] == '0':
                self.fill(board, i, m - 1)
        board[:] = map(lambda row: map(lambda ch: 'X0'[ch == '1'], row), board)

    def fill(self, board, x, y):
        n, m = len(board), len(board[0])
        dirs = ((-1, 0), (1, 0), (0, -1), (0, 1))
        queue = [(x, y)]
        while queue:
            x, y = queue.pop()
            board[x][y] = '1'
            for dir in dirs:
                if (n > x + dir[0] >= 0) and (m > y + dir[1] >= 0):
                    if board[x + dir[0]][y + dir[1]] == '0':
                        queue.append((x + dir[0], y + dir[1]))

if __name__ == '__main__':
    b = ["OOO","OOO","OOO"]
    # b = ["X"]
    Solution().solve(b)
    print b
