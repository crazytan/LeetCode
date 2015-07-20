__author__ = 'tan'

class Solution:
    # @param {integer[]} nums1
    # @param {integer[]} nums2
    # @return {float}
    def findMedianSortedArrays(self, nums1, nums2):
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1
        INT_MAX = 2**31 - 1
        INT_MIN = -2**31
        l1 = len(nums1)
        l2 = len(nums2)
        l = 0
        r = 2 * l1
        while l <= r:
            mid = (l + r) / 2
            mid_ = l1 + l2 - mid
            L1 = nums1[(mid - 1) / 2] if mid > 0 else INT_MIN
            R1 = nums1[mid / 2] if mid < (l1 * 2) else INT_MAX
            L2 = nums2[(mid_ - 1) / 2] if mid_ > 0 else INT_MIN
            R2 = nums2[mid_ / 2] if mid_ < (l2 * 2) else INT_MAX
            if (L1 <= R2) & (L2 <= R1):
                return (max(L1, L2) + min(R1, R2)) / 2.0
            if L1 > R2:
                r = mid - 1
            else:
                l = mid + 1

if __name__ == "__main__":
    nums1 = raw_input("enter the list1: ").split(',')
    nums1 = map(lambda x: int(x), nums1)
    nums2 = raw_input("enter the list2: ").split(',')
    nums2 = map(lambda x: int(x), nums2)
    print Solution().findMedianSortedArrays(nums1, nums2)
