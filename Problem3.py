#Time Complexity - O(log n)
#Space Complexity - O(1)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        start = 0
        end = len(nums) - 1
        
        while start <= end:
            mid = (start + end) // 2
            
            mGtLeft = mid == 0 or nums[mid] > nums[mid - 1]
            mGtRight = mid == len(nums) - 1 or nums[mid] > nums[mid + 1]
            
            if mGtLeft and mGtRight:
                return mid
            elif mGtLeft:
                start = mid + 1
            else:
                end = mid - 1
            
        return -1