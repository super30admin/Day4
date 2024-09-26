class Solution:
    def firstsort(self,low,high,target,nums):
        while low <= high:
            mid = low + (high - low)//2
            print(mid)
            if nums[mid] == target:
                if mid ==0 or nums[mid-1] != nums[mid]:
                    return mid
                else:
                    high = mid - 1
            else:
                if nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
                    
        return -1
                    
    def secondsort(self,low,high,target,nums):
        while low <= high:
            mid = low + (high - low)//2
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid+1] != nums[mid]:
                    return mid
                else:
                    low = mid + 1
            else:
                if nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
        
            
        
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low = 0
        high = len(nums) - 1
        first = self.firstsort(low,high,target,nums)
        if first == -1:
            return [-1,-1]
        second = self.secondsort(low,high,target,nums)
        
        return [first,second]
        