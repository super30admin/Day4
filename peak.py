#  Time complexity: O(logn)
# Space complexity: O(1)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if nums is None:
            return None
        no =  max(nums)
        m = nums.index(no)
        l = 0
        r = len(nums) - 1
        while l < r :
            m = (l + r) //2
            
            # Check if mid elemnt is the peak
            if nums[m] > nums[m -1] and nums[m] > nums[m +1]:
                return m
            
            # If mid elemnt is less than next element, iupdate left 
            if nums[m] < nums[m + 1]:
                l = m + 1
            else:
                r = m -1
        if nums[l] >= nums[r]:
            return l
        else:
            return r
        
