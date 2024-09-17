# Time complexity: O(log(n))
# Space Complexity: O(1) 
# Approach: Binary search; if (mid == low or nums[mid-1] < nums[mid]) and (mid == high or nums[mid] > nums[mid+1]), we found the peak, return it's index.
# Elseif nums[mid] > nums[mid+1], now we need to confirm for mid-1, so we move left (high = mid-1), else (nums[mid]<nums[mid+1]) we move right side.
# Also nums[-1] = nums[n] = -∞, so we might get 0th or last element index as answer, as 1st elem < 0th elem > -∞ and last second elem < last elem > -∞
# if no peak found, return -1

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if not nums:
            return -1
        low = 0
        high = len(nums) - 1
        
        while (low <= high):
            mid = low + (high - low) // 2
            if ((mid == low or nums[mid-1] < nums[mid]) and (mid == high or nums[mid] > nums[mid+1])):
                return mid
            elif nums[mid] > nums[mid+1]:
                high = mid - 1
            else:
                low = mid + 1
        return -1