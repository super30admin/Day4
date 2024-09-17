class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        
        if nums[0] < nums[-1]:
            return nums[0]
        
        l = 0
        r = len(nums)-1
        
        while l < r:
            while l<r and nums[l] == nums[l+1]:
                l += 1  
                print(nums[l],nums[l+1])
            while l<r and nums[r] == nums[r-1]:
                r -=1
                
            mid = (l+r)//2
            if nums[mid] > nums[r]:
                l = mid+1
                
            else:
                r = mid
        
        return nums[l]
    
#worst case: O(n)
#best case: O(logn)