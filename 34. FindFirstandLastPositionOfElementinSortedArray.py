class Solution:   
    def binarysearchFirst(self,nums, target):
        n = len(nums)
        low = 0
        high = n-1
        while (low<=high):
            mid = (low + high) //2
            if nums[mid] == target:
                if (mid == low or nums[mid-1]<nums[mid]):
                    return mid
                   
                high  = mid -1 
            elif target < nums[mid]:
                high = mid-1
            else:
                low = mid+1
        return -1
        
        
    def binarysearchLast(self,nums, target): 
        n = len(nums)
        low = 0
        high = n-1
        while (low<=high):
            mid = (low + high) //2
            if (nums[mid]==target):
                if (mid==high or nums[mid+1]>nums[mid]):
                    return mid
                low = mid+1
            elif target < nums[mid]:
                high = mid-1
            else:
                low = mid+1
        return -1
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if (len(nums)==0):
            print("hi")
            return [-1,-1]
        if (target < nums[0] or target > nums[len(nums)-1]):
            return [-1,-1]
    
        first = self.binarysearchFirst(nums,target) 
        if first == -1:
            return [-1,-1]
        
        secondary= self.binarysearchLast(nums,target)
        return [first,secondary]    