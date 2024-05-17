# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
class FindPeakElement:
    def findPeak(self, nums):
        if not nums: # Default check
            return -1
        
        low, high = 0, len(nums) - 1
        # Binary search implementation for logarithmic T.C.
        while low < high:
            mid = (high + low) // 2
            
            if nums[mid] > nums[mid + 1]:
                # Peak element is in the left. So update high value to search the left side
                high = mid
            else:
                # Peak is in the right
                low = mid + 1
        
        return low # Can also return high. Both works

# Example usage
findPeakElement = FindPeakElement()
nums = [1, 2, 3, 1]
print(findPeakElement.findPeak(nums))  # Output: 2

nums = [1, 2, 1, 3, 5, 6, 4]
print(findPeakElement.findPeak(nums))  # Output: 5 or 2 (both are correct answers since both are peak elements)
