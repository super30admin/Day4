class Solution:
    def findMin(self, nums: List[int]) -> int:
        l = 0
        h = len(nums) - 1
       
        
        while l <= h:
            mid = int((l+h)/2)
            if nums[mid] >= nums[l] and nums[mid] > nums[h]:
                l = mid+1
            elif nums[mid] >= nums[l] and nums[mid]  <= nums[h]:
                return nums[l]
            elif nums[mid] < nums[l] and nums[mid] < nums[h]:
                h = mid
        return -1