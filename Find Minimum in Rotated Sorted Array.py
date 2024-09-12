# Time Complexity: O(logn)
# Space complexity: O(1)

# Explaination: Find the sorted and unsorted part of the array 
#                and the Minimum will lie in the Unsorted part



class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return -1
        
        low = 0
        high = len(nums) - 1
        
        while(low <= high):
            if nums[low] < nums[high]:
                return nums[low]
            
            mid = (high + low) / 2
            if (mid == 0 or nums[mid] < nums[mid - 1]) and (mid == len(nums)-1 or nums[mid] < nums[mid + 1]):
                return nums[mid]
            elif(nums[mid] >= nums[low]):
                low = mid + 1
            else:
                high = mid - 1
                
        return -1
        