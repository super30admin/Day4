#Time Complexity: O(logn)
#Space Complexity: O(logn)
#Did it run on leetcode: Yes

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        while low < high:
            mid = int(low + (high - low) / 2)
            if nums[mid] > nums[high]:
                low = mid + 1
            else:
                high = mid
        return nums[low]