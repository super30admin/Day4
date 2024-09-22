# Time Complexity : O(logn)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach in three sentences only
# -> Check if mid is minimum element.
# -> Check if left sub-array is sorted.
# -> Check if right sub-array is sorted.

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low=0
        high=len(nums)-1
        if(len(nums)==0):
            return -1
        while(low<=high):
            #Check if the array is already sorted
            if(nums[low]<=nums[high]):
                return nums[low]
            mid = low+(high-low) // 2
            #Check if the mid is the minimum element, Happens if mid element is rotated point
            if((mid==0 or nums[mid]<=nums[mid-1]) and (mid==len(nums)-1 or nums[mid]<=nums[mid+1])):
                return nums[mid]
            #Check if left is the sorted array, Then check for right array as minimum exists in right because of the rotation
            elif(nums[low]<=nums[mid]):
                low = mid + 1
            #Check if right is the sorted array, Then check for left array as minimum exists in left because of the rotation
            else:
                high = mid - 1
        return -1 


            
            
        