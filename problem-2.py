# Time Complexity
# O(log n)
# Space Complexity
# O(1)

# Approach :

# in a sorted rotated array, the minimum element lies on the unsorted part of the array if present
# apply binary search on both parts of the array, and check if any one side is unsorted. If so, give preference to that side first.
# the criterion for checking smallest element is to ensure that arr[mid-1] > arr[mid] and arr[mid+1] > arr[mid]


class Solution:
    def findMin(self, nums: List[int]) -> int:

        if not nums:
            return -1

        low = 0
        high = len(nums)-1

        while (low <= high):
            if nums[low] <= nums[high]:
                return nums[low]

            mid = (low + high)//2

            if ((mid == 0 or nums[mid-1] > nums[mid]) and (mid == high or nums[mid+1] > nums[mid])):
                return nums[mid]

            if (nums[low] <= nums[mid]):
                low = mid+1

            else:
                high = mid-1
