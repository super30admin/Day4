
# Approach
# Get min value rotated array
# if mid-1 >= mid =<mid+1 then the mid is small element else if mid > low and mid<high move right else move left




# Complexities
# Time Complexity: O(log n)
# space Complexity : O(1) + O( log n) recursive stack space


from typing import List




class Solution:
    def findMin(self, nums: List[int]) -> int:
        result = self.binarySearch(nums, 0, len(nums) - 1)
        return result

    def binarySearch(self, nums, low, high):
        if (high - low) > 0:

            mid = int((low + high) / 2)

            if nums[mid - 1] > nums[mid] < nums[mid + 1]:
                return nums[mid]
            else:
                if nums[low] <= nums[mid] and nums[mid]>nums[high]:
                    return self.binarySearch(nums, mid + 1, high)
                else:
                    return self.binarySearch(nums, low, mid - 1)
        else:
            return nums[low]



s = Solution()
print(s.findMin([2,1]))