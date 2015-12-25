class Solution(object):
    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        all_elem = {'1':1, '2':1, '3':1, '4':1, '5':1, '6':1, '7':1, '8':1, '9':1}
        candidates = [[dict(all_elem) for i in range(9)] for j in range(9)]
        for i in range(9):
            for j in range(9):
                if board[i][j] == '.':
                    for k in range(9):
                        if board[i][k] != '.':
                            candidates[i][j][board[i][k]] = 0
                        if board[k][j] != '.':
                            candidates[i][j][board[k][j]] = 0
                    r = i / 3
                    c = j / 3
                    for _i in range(3):
                        for _j in range(3):
                            x = r * 3 + _i
                            y = c * 3 + _j
                            if board[x][y] != '.':
                                candidates[i][j][board[x][y]] = 0
        self.solve(board, candidates, [0, 0])

    def solve(self, board, candidates, coord):
        i = coord[0]
        j = coord[1]
        if i >= 9:
            return True
        if board[i][j] != '.':
            return self.solve(board, candidates, self.next(i, j))
        else:
            for candid in candidates[i][j]:
                if candidates[i][j][candid] == 1:
                    board[i][j] = candid
                    collections = self.get_collections(board, candidates, candid, i, j)
                    if self.feasible(candid, collections):
                        self.update(candid, collections)
                        if self.solve(board, candidates, self.next(i, j)):
                            return True
                        self.de_update(candid, collections)
                    board[i][j] = '.'
            return False

    def next(self, i, j):
        if j >= 8:
            return [i + 1, 0]
        return [i, j + 1]

    def get_collections(self, board, candidates, candid, i, j):
        ans = []
        for k in range(9):
            if (board[i][k] == '.') and (candidates[i][k][candid] == 1):
                ans.append(candidates[i][k])
            if (board[k][j] == '.') and (candidates[k][j][candid] == 1):
                ans.append(candidates[k][j])
        r = i / 3
        c = j / 3
        for _i in range(3):
            for _j in range(3):
                x = r * 3 + _i
                y = c * 3 + _j
                if (board[x][y] == '.') and (candidates[x][y][candid] == 1):
                    ans.append(candidates[x][y])
        return ans

    def feasible(self, candid, collections):
        for collection in collections:
            if collection[candid] == 1:
                tmp = False
                for num in collection:
                    if (collection[num] == 1) and (num != candid):
                        tmp = True
                        break
                if not tmp:
                    return False
        return True

    def update(self, candid, collections):
        for collection in collections:
            if collection[candid] == 1:
                collection[candid] = 2

    def de_update(self, candid, collections):
        for collection in collections:
            if collection[candid] == 2:
                collection[candid] = 1

if __name__ == "__main__":
    board = [['.','.','9','7','4','8','.','.','.'],
             ['7','.','.','.','.','.','.','.','.'],
             ['.','2','.','1','.','9','.','.','.'],
             ['.','.','7','.','.','.','2','4','.'],
             ['.','6','4','.','1','.','5','9','.'],
             ['.','9','8','.','.','.','3','.','.'],
             ['.','.','.','8','.','3','.','2','.'],
             ['.','.','.','.','.','.','.','.','6'],
             ['.','.','.','2','7','5','9','.','.']]
    Solution().solveSudoku(board)
    print board
