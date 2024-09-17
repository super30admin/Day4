# Time complexity : O(log n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        
        while low <= high:
             # checking if the whole array is sorted, if so then return the first element
            if nums[low] < nums[high]:
                return nums[low]
            
            # finding middle pointer
            mid = low + (high - low) // 2
            
            # Check if the element is the last element in the sub-array and comparing it with the neighbors, in order to get the min element
            if (mid == 0 or nums[mid] < nums[mid-1]) and (mid == len(nums)-1 or nums[mid] < nums[mid+1]):
                return nums[mid]
            elif nums[low] <= nums[mid]:
                # Checking the right sub-array as left sub-array is sorted
                low = mid + 1
            else:
              # Checking the left sub-array as right sub-array is sorted
                high = mid - 1
        
        return -1
                
