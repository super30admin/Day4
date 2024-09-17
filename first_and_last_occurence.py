# Time Complexity : O(log(n)) as we are using binary search
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0 or target not in nums: # returning [-1,-1] if list is empty
            return [-1,-1]
        if target < nums[0] or target > nums[len(nums) - 1]: # returning [-1,-1] if index is out of bounds
            return [-1,-1]
        first = self.searchFirstOccurence(nums, target) # calling a function that checks first occurence
        if first == -1:
            return [-1,-1]
        last = self.searchLastOccurence(nums,target) # calling a function that checks second occurence
        return [first,last] # returning indices of first and last occurences

    # Function to check first occurence
    def searchFirstOccurence(self,nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while(low <= high):
            mid = low + ((high - low) // 2) # To avoid integer overflow
            if nums[mid] == target:
                if mid == 0 or nums[mid - 1] < nums[mid]:
                    return mid # first index found
                else:
                    high = mid - 1
            elif target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    # Function to check last occurence 
    def searchLastOccurence(self,nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while(low <= high):
            mid = low + ((high - low) // 2) # To avoid integer overflow
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid + 1] > nums[mid]:
                    return mid # last index found
                else:
                    low = mid + 1
            elif target > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return -1
