# Time Complexity :
#  O(LOG(N)) , binary search algorithm


# Space Complexity : 
#  O(1), since you are just searching, not creating new matrix/array


# Approach:
# Start with left and right pointers, find mid pointer.
# Case 1: If array already sorted, then return the element at "left" pointer
# Case 2: Calculate mid, check if mid element is smaller than its adjacent elements, If so, return that "mid" element
# Case 3: If above cases don't hold true, then check if the left sub-array is sorted:
#     Case 3a: if it is sorted, then advance the left pointer to mid+1 to search in right sub-array,
#              since the minimum element would be present in right sub-array
#      else: advance right pointer to mid-1 to search in this left sub-array

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums or len(nums)==0:
            return 0
        left = 0
        right = len(nums)-1

        while(left<=right):
            # check if the array is already sorted
            if nums[left] <= nums[right]:
                return nums[left]

            mid = (left + right) / 2
            # check if mid is smaller than it's adjacent elements
            if(mid==0 or nums[mid-1]>nums[mid]) and (mid==len(nums)-1 or nums[mid+1]>nums[mid]):
                return nums[mid]
            # if above conditions don't satisfy, check if the left sub-array is sorted
            if(nums[left]<=nums[mid]):
                # move to right sub-array since minimum element would live in right subarray
                left = mid+1
            else:
                right = mid-1
        
        return 0

            
        