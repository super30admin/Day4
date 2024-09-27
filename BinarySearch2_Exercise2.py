"""
Time complexity: O(logN)
Space complexity: O(1)
Did you  execute in leetcode = Yes, but not all test cases. Still working on it.
Challenges: To code for different test cases.
Comments: My logic is complicated and I think its not the ideal solution. I have coded for middle in the edges, drop point,
peak point, and in between sorted array here.
"""
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        # Base condition
        if not nums:
            return -1
        
        # Sorted array or single element in array
        if nums[0]<=nums[-1]:
            return nums[0] 
        
        # Initialize variables
        left, right = 0, len(nums)-1
        
        while left<=right:
            mid = left + (right-left)//2
            
            if mid==0 or mid==len(nums)-1: # Boundary condition
                if nums[0]>nums[-1]:
                    return nums[-1]
                else:
                    return nums[0]
                       
            elif nums[mid]<nums[mid+1] and nums[mid]<nums[mid-1]: # At a drop point.
                # No duplicates as per question
                if nums[mid]<nums[0]:
                    return nums[mid]
                else:
                    return nums[0]
            
            elif nums[mid]> nums[mid+1] and nums[mid]>nums[mid+1]: # One of the peak points
                if nums[mid+1]<nums[0]:
                    return nums[mid+1]
                else:
                    return nums[0]
                
            elif nums[mid-1] < nums[mid] < nums[mid+1]:  #in between the sorted region
                right=mid
                continue
                
            else:
                left=mid
                continue            
        return -1
        
