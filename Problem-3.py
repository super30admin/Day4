#We can perform iterative binary search by looking for mid elment greater than next element and fix it whenever we find 1 and then set it. Then we search for low element
#This is O(logn)
#Space is O(1)
#Yes, this worked in leetcode

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l = 0
        r = len(nums) - 1
        while l < r:
            mid = (l + r) // 2
            if nums[mid] > nums[mid + 1]:
                r = mid
            else:
                l = mid + 1
        return l