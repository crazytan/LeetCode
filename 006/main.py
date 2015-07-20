__author__ = 'tan'


class Solution:
    # @param {string} s
    # @param {integer} numRows
    # @return {string}
    def convert(self, s, numRows):
        if numRows == 0:
            return s
        rows = []
        for i in xrange(numRows):
            rows.append([])
        r = -1
        diff = 1
        for ch in s:
            r += diff
            if r >= numRows:
                r = numRows - 2
                diff = -1
            elif r < 0:
                r = 1
                diff = 1
            rows[r].append(ch)
        return ''.join(map(lambda x: ''.join(x), rows))

if __name__ == "__main__":
    s = raw_input("enter the string: ")
    n = int(raw_input("enter numRows: "))
    print Solution().convert(s, n)
