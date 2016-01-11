class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if len(height) <= 2:
            return 0
        i = 0
        q = []
        ans = 0
        while i < len(height):
            if (not q) or (height[q[-1]] >= height[i]):
                q.append(i)
                i += 1
            else:
                mid = q.pop()
                if q:
                    ans += (min(height[q[-1]], height[i]) - height[mid]) * (i - q[-1] - 1)
        return ans


if __name__ == "__main__":
    print Solution().trap([0,1,0,2,1,0,1,3,2,1,2,1])
