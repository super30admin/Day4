class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low,high= 0,len(nums)-1
        
        while low<=high:
            mid=(low+high)//2
            if (mid==0 or nums[mid]> nums[mid-1]) and (mid==len(nums)-1 or nums[mid]> nums[mid+1]):
                return mid
            
            elif (mid>0 and nums[mid-1]>nums[mid]):
                high=mid-1
                
            elif(mid<len(nums)-1 and nums[mid+1]>nums[mid]):
                low= mid+1
                                