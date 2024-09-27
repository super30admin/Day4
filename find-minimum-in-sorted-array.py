"""
Runtime Complexity:
O(log n) - runtime for binary search is O(log n). The array is divided into two halves by finding the mid and check whether the mid is lesser than mid-1 and same with mid+1.
If this condition satisfies then we have found the mid else we check whether the left side is sorted. If the left side is sorted the chances of finding the minimum element lies on
the unsorted part. So we update the low to mid+1 and if the left part is not sorted we go on the left side by updating high to mid-1.
Space Complexity: O(1) - constant as no extra data structure is used to compute the result.
Yes, the code worked on leetcode.
"""


class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums)==1:
            return nums[0]
        low = 0
        high = len(nums)-1
        while (low<= high):
            if nums[low]<=nums[high]:
                return nums[low]
            mid = (low+(high-low)//2)
            if ((mid-1 < low or nums[mid] < nums[mid-1]) and
            (mid+1 > high or nums[mid]< nums[mid+1])):
                return nums[mid]
            else:
                if nums[low]<=nums[mid]:
                    low=mid+1
                else:
                    high=mid-1
        return mid
            
            
        
