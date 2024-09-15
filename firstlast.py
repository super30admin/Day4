#time complexity = O(lon(n))
#Space complexity = O(1)
#Ran successfully on leetcode
#no problems faced 

class Solution:
    
    def firstBinSearch(self,nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
            
        while(low <= high):
            mid = low + ((high-low) // 2)
            if(nums[mid] == target):
                if(mid == 0 or nums[mid] > nums[mid-1]):
                    return mid
                else:
                    high = mid - 1
            elif(nums[mid] < target):
                low = mid + 1
            else:
                high = mid - 1
                    
        return -1
        
    def secondBinSearch(self,nums: List[int],target: int,low: int,high: int) -> int:
        
        while(low <= high):
            mid = low + (high - low) // 2
            if(nums[mid] == target):
                if(mid == len(nums) - 1 or nums[mid+1] > target):
                    return mid
                else:
                    low = mid + 1
            elif(nums[mid] > target):
                high = mid-1
            else:
                low = mid+1
        return -1
    
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        
        if(len(nums) == 0):
            return [-1,-1]
        
        if(nums[0] > target or nums[len(nums)-1] < target):
            return [-1,-1]
        
        first = self.firstBinSearch(nums,target)
        last = self.secondBinSearch(nums,target,first,len(nums)-1)
        return [first,last]