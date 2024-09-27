#Time Complexity :O(log n)
#Space Complexity:O(1)

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if target in nums:
            first=self.FindFirst(nums,target)
            last=self.FindLast(nums,target)
            return first,last
        return -1,-1
    
    def FindFirst(self, nums: List[int], target: int) -> int:
        low=0
        high=len(nums)-1
        while(low<=high):
            mid=low+(high-low)//2
            if(nums[mid]==target):
                if(mid==0 or nums[mid-1]<nums[mid]):
                    return mid
                else:
                    high=mid-1
                    continue
            if(nums[mid]>target):
                high=mid-1
            else:
                low=mid+1
    
    def FindLast(self, nums: List[int], target: int) -> int:
        low=0
        high=len(nums)-1
        while(low<=high):
            mid=low+(high-low)//2
            if(nums[mid]==target):
                if(mid==len(nums)-1 or nums[mid+1]>nums[mid]):
                    return mid
                else:
                    low=mid+1
                    continue
            if(nums[mid]>target):
                high=mid-1
            else:
                low=mid+1