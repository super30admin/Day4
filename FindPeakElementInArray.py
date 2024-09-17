# Time Complexity : O(log n) 45ms //Based on leetcode runtime
#  Space Complexity : O(1) 14.1 //Based on leetcode
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        #If no elments in nums return -1, if only one elment present the return 0 index
        n = len(nums)
        if not nums:
            return -1
        if n == 1:
            return 0
        
        #Defining lower and upper bound
        left = 0
        right = n - 1
        
        #Binary Search on nums till we find the desire output
        while left <= right:
            mid = (left+right) // 2 
            
            #If the mid is less than the upper bound and the current number is greater that the mid + 1 then make right provisonal peak
            if mid < right and nums[mid] > nums[mid + 1]:
                right = mid
            #Else if element at mid is less than the element next to it then make the lower bound as that and again run the loop
            elif mid < right and nums[mid] < nums[mid + 1]:
                left = mid + 1
            else:
                return mid
        return right