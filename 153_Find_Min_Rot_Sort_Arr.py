# Time complexity: O(log(n))
# space: O(1) 
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if(len(nums) == 0):
            return
        if(len(nums) == 1):
            return nums[0]
        low =0
        high= len(nums) - 1
        while(low <= high):
            mid = low + (high-low)//2
            ctr = ctr +1
            if(nums[low]<= nums[high]):
                return nums[low]
            if( (mid == low) or nums[mid]< nums[mid-1]) and ((mid == high) or nums[mid] < nums[mid+1]):
                return nums[mid]
            if(nums[low]<=nums[mid]):
                low = mid +1
            else: 
                high = mid -1

                
