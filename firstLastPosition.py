class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return [-1,-1]

        if target < nums[0] or target > nums[-1]:
            return [-1,-1]

        firstPosition = self.binarySearchFirstPosition(nums,target)
        if firstPosition == -1:
            return [-1,-1]
        lastPosition  = self.binarySearchLastPosition(nums,target) 
        return [firstPosition, lastPosition]


    def binarySearchFirstPosition(self,nums,target):
        low = 0
        high = len(nums)-1

        while low <= high:
            mid = (low+high)//2

            if nums[mid]==target:
                if (mid == 0 or nums[mid-1]!=nums[mid]):
                    return mid
                high = mid-1    
            elif nums[mid] > target:
                high = mid-1
            else:
                low = mid+1  
        return -1  

    def binarySearchLastPosition(self,nums,target):
        low = 0
        high = len(nums)-1

        while low <=high:
            mid = (low+high)//2

            if nums[mid]==target:
                if (mid == len(nums)-1 or nums[mid+1]!=nums[mid]):
                    return mid
                low = mid+1    
            elif nums[mid] > target:
                high = mid-1
            else:
                low = mid+1  
        return -1                             
        
