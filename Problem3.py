#Time complexity:
#O(log(n)) where n is array size

#Space complexity
# O(1)

# Approach:
#Binary search - the paradigm to half the array is as follows:
#Find mid -> check if it is a peak, if yes return mid
# If mid elem is not peak, compare mid elem with mid + 1 and mid - 1 and move to whichever side the elem is > mid
# Mathematically -> A peak will mandatorily lie on the side which we move to i.e the higher side

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        low = 0
        high = n - 1
        
        while low <= high:
            mid = (low + high) // 2
            if (mid == 0 or nums[mid-1] < nums[mid]) and (mid == n - 1 or nums[mid + 1] < nums [mid] ):
                return mid
            else:
                if nums[mid + 1] > nums[mid]:
                    low = mid + 1
                else:
                    high = mid - 1
            
                    
        