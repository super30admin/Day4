"""
time complexity: O(log n)
space complexity: O(1)
"""

class Solution:
    def startPos(self,nums: List[int],target: int,low : int, high: int) -> int:
        while(low<=high):
            mid = low+(high-low)//2
            
            if(nums[mid]==target):
                if(mid==low or nums[mid]>nums[mid-1]): return mid
                else:
                    high = mid-1
            else:
                if(nums[mid]>target):
                    high = mid-1
                else:
                    low = mid+1
        return -1
    def endPos(self,nums: List[int],target: int,low : int, high: int) -> int:
        while(low<=high):
            mid = low+(high-low)//2
            
            if(nums[mid]==target):
                if(mid==high or nums[mid]<nums[mid+1]): return mid
                else:
                    low = mid+1
            else:
                if(nums[mid]>target):
                    high = mid-1
                else:
                    low = mid+1
                    
        return -1
                    
                
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        lowPos = self.startPos(nums,target,0,len(nums)-1)
        highPos = self.endPos(nums,target,0,len(nums)-1)
        return [lowPos,highPos]
        