class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        
        # If the element is not in the array then return [-1,-1] directly
        if len(nums) == 0:
            return [-1,-1]
        
        if (target > nums[-1]) or (target < nums[0]):
            return [-1,-1]
        
        # function for getting the first index
        def BinarySearchFirstIndex(nums, target):
            left = 0
            right = len(nums) - 1
            
            while left <= right:
                mid = (left + right) // 2
                
                if nums[mid] == target: # if target is found
                    # Then we check whether the mid is first index
                    # if it is then return the mid because it will be the first occurance
                    # or else we check if the immediate left element is less then the current
                    # this will prove that we are at the first occurance of target
                    if ((mid == 0) or (nums[mid - 1] < nums[mid])):
                        return mid
                    right = mid - 1
                elif (nums[mid] < target):
                    left = mid + 1
                elif (nums[mid] > target):
                    right = mid - 1
            return -1
        
        def BinarySearchLastIndex(nums, target):
            left = 0
            right = len(nums) - 1
            
            while left <= right:
                mid = (left + right) // 2
                
                if nums[mid] == target: # if target is found
                    # Then we check whether the mid is at last index
                    # If it is then return the mid because it will be the last occurance
                    # Or else we check if the immediate right element is greater then the current
                    # This will prove that we are at the last occurance of target
                    if ((mid == len(nums) - 1) or (nums[mid + 1] > nums[mid])):
                        return mid
                    left = mid + 1
                elif (nums[mid] < target):
                    left = mid + 1
                elif (nums[mid] > target):
                    right = mid - 1
            return -1
                
        firstIndex = BinarySearchFirstIndex(nums, target)
        secondIndex = BinarySearchLastIndex(nums, target)
        
        return [firstIndex, secondIndex]
            
        # Time Complexity: O(log(n))
        # Space Complexity: O(1)
            