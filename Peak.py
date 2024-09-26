class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0
        low, high = 0,len(nums)-1
        
        while low<=high:
            mid = low + (high-low)//2
            if (mid==0 or nums[mid-1] < nums[mid]) and (mid+1 == len(nums) or nums[mid+1] < nums[mid]):
                return mid
            elif(mid == 0 or nums[mid-1] < nums[mid]):
                #go right
                low = mid +1
            else:
                #go left
                high = mid-1
                
        return 0
            
