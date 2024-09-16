# Time Complexity : O(log N) due to binary search, where N is length of array
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
class Solution:
    def findMin(self, nums: [int]):
        # edge case
        if not nums or len(nums) == 0:
            return -1
        if len(nums) == 1:
            return nums[0]
        low = 0
        high = len(nums) - 1

        # if already sorted array return smallest
        if nums[low] < nums[high]:
            return nums[low]

        # binary search
        while nums[low] > nums[high]:
            mid = low + (high - low) // 2
            if nums[mid] > (nums[low]):
                low = mid + 1
            elif nums[mid] < nums[low]:
                high = mid
            else:
                return nums[high]
        return nums[low]


r = Solution()
nums1 = [3, 4, 5, 1, 2]
print("Minimum element is:", r.findMin(nums1))
nums2 = [4, 5, 6, 7, 0, 1, 2]
print("Minimum element is:", r.findMin(nums2))
