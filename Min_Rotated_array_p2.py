# // Time Complexity : O(logn) as it is using binary search.
# // Space Complexity : O(1) constant time as it is not using any auxilary memory.
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : faced some difficulty  in intialising low and high variables.


# // Your code here along with comments explaining your approach
# In this problem we perform binary search to calculate the low and high indices and in the end took the minimum of those indices and #returned the value of that index which is the minimum value.



class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low=0
        high=len(nums)-1
        while (low<high):
            mid=int(low+((high-low)/2))
            if nums[mid]>nums[low]:
                if nums[high]<nums[mid]:
                    low=mid
                else:
                    high=mid
            elif nums[mid]<nums[low]:
                high=mid
            else:
                if nums[high]<nums[mid]:
                    low=mid+1
                else:
                    high=mid
        return min(nums[low],nums[high])
            
        
            
                
        