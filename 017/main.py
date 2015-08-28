__author__ = 'tan'

class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        if not digits:
            return []
        comb = self.letterCombinations(digits[1:])
        if not comb:
            comb.append('')
        ans = []
        mappings = {'2': 'abc',
                    '3': 'def',
                    '4': 'ghi',
                    '5': 'jkl',
                    '6': 'mno',
                    '7': 'pqrs',
                    '8': 'uv',
                    '9': 'wxyz',
                    '0': ' '}
        for s in comb:
            for ch in mappings[digits[0]]:
                ans.append(ch + s)
        return ans

if __name__ == '__main__':
    print Solution().letterCombinations('23')
