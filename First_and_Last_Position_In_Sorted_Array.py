# Time Complexity : O(logn)
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # two binary seaarch to get leftmost and rightmost element
        left = self.leftBinarySearch(nums, target)
        right = self.rightBinarySearch(nums, target)
        # element is not present hence rightmost can be assumed to be -1 too
        if left == -1:
            return [-1,-1]
        else:
            return [left,right]

    # function to get leftmost elemenet
    def leftBinarySearch(self,nums, target):
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = low + int((high - low)/2)
            # if target is found
            if nums[mid] == target:
                # return if its the first element or the leftmost
                if mid == 0 or nums[mid-1] != target:
                    return mid
                else:
                # else keep looking more left
                    high = mid -1
            # usual binary search conditions to find the target in sorted array
            elif nums[mid] < target:
                low = mid +1
            else:
                high = mid -1
       #if not found return -1         
        return -1

    # function to get the rightmost element
    def rightBinarySearch(self,nums, target):
        low, high = 0, len(nums) -1
        while low <= high:
            mid = low + int((high - low)/2)
            # if target if found
            if nums[mid] == target:
                # return index if its the rightmost element or last lement of the array
                if mid == len(nums)-1 or nums[mid+1] != target:
                    return mid
                else:
                # else keep expanding search to right subarray
                    low = mid + 1
                # if target is not found then usual binary search condition in sorted array
            elif nums[mid] < target:
                low = mid +1
            else:
                high = mid -1
        # if not found then return -1        
        return -1
        
        