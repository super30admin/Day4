class Solution:
    
    def binSearchLft(self, low, high,nums, target):
        idx = -1
        while (low <= high):
            mid = (low + high) //2
            if target < nums[mid]:
                high = mid -1
            elif target > nums[mid]:
                low = mid + 1
            else:
                idx = mid
                high = mid - 1
        return idx
    def binSearchRgt(self,low, high,nums, target):
        idx = -1
        
        while (low <= high):
            #print("OP", low, high ,mid)
            mid = (low + high) //2

            if target < nums[mid]:
                high = mid -1
            elif target > nums[mid]:
                low = mid + 1
            else:
                idx = mid
                low = mid + 1
        return idx
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums is None:
            return [-1, -1]
        low = 0
        high = len(nums) - 1
        
        
        left = self.binSearchLft(low, high,nums, target)
        rgt = self.binSearchRgt(low, high,nums, target)
        # if rgt == -1:
        #     return [-1, -1]
       
        return [left, rgt ]
