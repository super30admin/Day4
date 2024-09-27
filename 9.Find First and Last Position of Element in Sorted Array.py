class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0 or nums is None:
            return [-1, -1]
        first = self.find_first(nums, target)
        if first == None: return [-1, -1]
        last = self.find_last(nums, first, len(nums)-1, target)
        return [first, last]        
            
    def find_first(self, nums, target) -> int:
        low = 0
        high = len(nums)-1
        
        while(low<=high):
            mid = (low + high) // 2
            
            if nums[mid] == target:
                if mid == 0 or nums[mid] > nums[mid-1]:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] < target:
                    low = mid + 1
            else:
                high = mid - 1
    
    def find_last(self, nums, low, high, target):
    
        while(low<=high):
            mid = (low + high) // 2
            
            if nums[mid] == target:
                if mid == len(nums)-1 or nums[mid] < nums[mid+1]:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] < target:
                    low = mid + 1
            else:
                high = mid - 1