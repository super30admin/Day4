# Time Complexity: O(log(n))
# Space Complexity: O(1)

class Solution:
    def searchRange(self, nums, target):
        if len(nums) == 0:
            return
        if target not in nums:
            return [-1, -1]
        
        first_occurence = BSFirstOccurence(nums, target)
        last_occurence = BSLastOccurence(nums, target)

        def BSFirstOccurence(nums, target):
            low = 0
            high = len(nums) - 1
            while low <= high:
                mid = low + (high - low) // 2
                if target == nums[mid]:
                    if mid == 0 or nums[mid - 1] < nums[mid]:
                        return mid
                    else:
                        high = mid - 1
                elif target > nums[mid]:
                    low = mid + 1
                else:
                    high = mid - 1
        
        def BSLastOccurence(nums, target):
            low = 0
            high = len(nums) - 1
            while low <= high:
                mid = low + (high - low) // 2
                if target == nums[mid]:
                    if mid == len(nums) -1 or nums[mid + 1] > nums[mid]:
                        return mid
                    else:
                        low = mid + 1
                elif target > nums[mid]:
                    low = mid + 1
                else:
                    high = mid - 1
        
        return [first_occurence, last_occurence]
