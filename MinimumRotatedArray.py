class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        #if array is rotated then minimum will be on the sorted part
        #if array is sorted then first element is minimum
        if nums is None or len(nums) == 0:
            return -1
        low, high = 0,len(nums)-1
        
        while low <= high:
            if nums[low] <= nums[high]:
                return nums[low]
            mid = low + (high-low)//2
            if (mid == 0 or nums[mid-1] > nums[mid]) and (mid == len(nums)-1 or nums[mid+1] > nums[mid]):
                return nums[mid]
            elif nums[low] <= nums[mid]:
                #go right
                low = mid+1
            else:
                #go left
                high = mid-1
                
        return -1
                
