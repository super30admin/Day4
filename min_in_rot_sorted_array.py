class Solution:
    def findMin(self, nums: List[int]) -> int:
        low=0
        high=len(nums)-1
        
        while(low <= high):
            if(nums[low] < nums[high]):
                return nums[low]
            
            mid=int(low+(high-low)/2)
            

            if( (mid == high or nums[mid] < nums[mid+1]) and (mid == low or nums[mid]< nums[mid-1]) is True):
                return nums[mid]
            elif(nums[mid] > nums[high]):
                low = mid+1
            elif(nums[mid]<nums[low]):
                 high = mid-1