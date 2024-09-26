class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        if not nums:
            return [-1, -1]
        
        low = 0
        high = len(nums)-1
        
        def find_first(low, high):
            while low <= high:

                mid = (low + high)//2

                if nums[mid] == target:
                    if mid == 0 or nums[mid-1] < target:
                        return mid
                    else:
                        high = mid - 1
                elif nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1

            return -1
        
        
        def find_last(low, high):
            while low <= high:

                mid = (low + high)//2

                if nums[mid] == target:
                    if mid == len(nums)-1 or target < nums[mid+1]:
                        return mid
                    else:
                        low = mid + 1
                elif nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1

            return -1
        
        first = find_first(low, high)
        
        if first == -1:
            return [-1, -1]
        
        last = find_last(low, high)
        
        return [first, last]
    
        
        