#Time Complexity - O(log n)
#Space Complexity - O(1)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        start = 0
        end = len(nums) - 1
        while start != end:
            mid = (start + end) // 2
            if nums[mid] >= nums[start]:
                if nums[start] > nums[end]:
                    start = mid + 1
                else:
                    end = mid
            else:
                if nums[start] > nums[end]:
                    end = mid
                else:
                    start = mid
        return nums[start]