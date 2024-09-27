class Solution:

    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        global_low = 0
        def left(nums, target):
            low = 0
            high = len(nums) - 1
            while low <= high:
                mid = low + (high - low)//2
                if nums[mid] == target:
                    if (mid == 0 or nums[mid] > nums[mid - 1]):
                        global_low = mid
                        return mid
                    else:
                        high = mid - 1
                elif nums[mid] < target:
                        low = mid + 1
                else:
                        high = mid - 1
                        
            return -1
    
        def right( nums, target):
            low = global_low
            high = len(nums) - 1
            while low<=high:
                mid = low + (high - low)//2
                if nums[mid] == target:
                    if (mid == len(nums)-1 or nums[mid] < nums[mid + 1]):
                        return mid
                    else:
                        low = mid + 1
                elif nums[mid] < target: 
                        low = mid + 1
                else:
                        high = mid -1
            return -1
        
        if nums:
            left = left(nums,target)
            if left == -1:
                return [-1,-1]
            right = right(nums, target)
            return [left,right]
        
        return [-1,-1]
        
        
# Time complexity O(2log(n)) since we are performing binary search twice
# Space complexity O(1) since we are not initializing additonal data structure
