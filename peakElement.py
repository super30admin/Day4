# // Time Complexity : O(lg n) 
# // Space Complexity : O(1)  
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums) < 2:
            return 0
        # binary search method
        start = 0
        end = len(nums)-1
        
        while start <= end:
            mid = (end-start)//2 + start
            # checking if the mid is the peak
            # by comparing it with its neighbours
            if (mid == 0 or nums[mid-1] < nums[mid]) and (mid == len(nums)-1 or nums[mid+1] < nums[mid]): 
                return mid
            # we know that right side is going downhill
            # so we move left
            elif nums[mid] > nums[mid+1]: 
                end = mid - 1
            # we move right as it is going uphill
            else:
                start = mid + 1
        return -1