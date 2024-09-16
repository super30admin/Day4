# Time Complexity : O(lg n) - findPeakElement
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
# Your code here along with comments explaining your approach
# 1. Can be done by modified Binary Search. Compute mid. 
# 2. if mid is greater than it's both - left and right neighbors OR if mid is first, then greater than it's right neighbor OR if mid is last and it's greater than it's left 
#    neighbor -> It's the peak element
# 3. Else, always move to the greater part because there are 2 cases -> it can keep increasing - then our mid is the last / first element
#                                                                    -> it can keep increase and decrease - then we have found our peak 

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if not nums:
            return -1
        
        start , end = 0, len(nums) - 1
        while start <= end:
            mid = start + (end - start) // 2
            
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
                return mid
            
            elif mid + 1 < len(nums) and nums[mid] < nums[mid + 1]:
                start = mid + 1
                
            else:
                end = mid - 1
                
        return -1
