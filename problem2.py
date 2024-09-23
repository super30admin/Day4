class Solution:
    def findMin(self, nums: List[int]) -> int:
        low, high = 0, len(nums)-1

        while low<=high:
            
            #check if low, high in sorted range
            if nums[low] <= nums[high]:
                return nums[low]
            
            mid = low + (high-low)//2

            #check if mid is minimum 
            if (mid==0 or nums[mid]<nums[mid-1]) and (mid==len(nums)-1 or nums[mid]<nums[mid+1]):
                return nums[mid]
            elif nums[low]<=nums[mid]:  #left sorted, so move to right
                low = mid+1
            else:   #right sorted, so move to left
                high = mid-1