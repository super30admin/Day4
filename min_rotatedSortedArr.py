# // Time Complexity : O(log(n))
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0 
        high = len(nums)-1
        
        while low <= high:
            
            mid = low + (high-low)//2
            
            # return mid element if its neighboring elements are greater than itself or if its on either ends and one of the neighboring element is greater than itself.
            if (mid == 0 or nums[mid] < nums[mid-1]) and (mid == len(nums)-1 or nums[mid]< nums[mid+1]):
                return nums[mid]
            # if not, compare if the mid element is greater than the high: which would mean that there has been a pivot that lies on the right side
            elif nums[mid] > nums[high]:
                low = mid + 1
            else:
                high = mid - 1
        return -1