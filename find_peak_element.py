# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def findPeakElement(self, nums):
        low = 0 
        high = len(nums) - 1
        # Return the element if only one element present in the input array
        if high == 0:
            return 0
        while low <= high:
            mid = low + (high - low) // 2
            # If start element is peak element
            if mid == 0 and nums[mid] > nums[mid + 1]:
                return mid
            # If end element is peak element
            elif mid == len(nums) - 1 and nums[mid] > nums[mid - 1]:
                return mid
            # If peak element found within the array
            elif  nums[mid - 1] < nums[mid] > nums[mid + 1]:
                return mid
            # Reducing the search space
            else:
                # Target belongs to right sub-array
                if nums[mid] < nums[mid + 1]:
                    low = mid + 1
                # Target belongs to left sub-array
                else:
                    high = mid - 1

solution = Solution()
print(f"OUTPUT >> {solution.findPeakElement([1,2,1,3,5,6,4])}")