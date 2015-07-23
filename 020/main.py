__author__ = 'tan'


class Solution:
    # @param {string} s
    # @return {boolean}
    def isValid(self, s):
        counter = {')': '(', ']': '[', '}': '{'}
        diff = {'(': 1, ')': -1, '[': 1, ']': -1, '{': 1, '}': -1}
        stack = []
        for ch in s:
            if diff[ch] > 0:
                stack.append(ch)
            else:
                if (not any(stack)) or (stack[-1] != counter[ch]):
                    return False
                stack.pop()
        if any(stack):
            return False
        return True


if __name__ == '__main__':
    s = raw_input("enter s: ")
    print Solution().isValid(s)
