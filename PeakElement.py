# Time Complexity : O(logn)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach in three sentences only
# -> Check if mid is peak element
# -> Check if we have to iterate through left sub array
# -> Check if we have to iterate through right sub array

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        high = len(nums)-1
        while(low<=high):
            mid = low+(high-low) // 2
            #To Check if the mid is peak element
            #If mid is first element then there is no previous element and if it is > next element, Then that is peak element
            #If mid is last element then there is no next element and if it is > previous element, Then that is peak element
            #If mid is greater than previous and next element then that is the peak element
            if ((mid==0 or nums[mid]>nums[mid-1]) and (mid==len(nums)-1 or nums[mid]>nums[mid+1])):
                return mid
            #If we are checking [mid-1] element then we should make sure mid > 0, Which denotes left is increasing array and more likely peak is on that side
            elif(mid>0 and nums[mid]<nums[mid-1]):
                high = mid - 1
            #If we are checking [mid-1] element then we should make sure mid < len(nums)-1, Which denotes right is increasing array and more likely peak is on that side
            else:
                low = mid + 1
        return -1