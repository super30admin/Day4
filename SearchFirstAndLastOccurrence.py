# Time complexity : O(log n)
# Space complexity : O(1)
# Did this code run successfully on leetcode: Yes
# Any problem in solving this : No

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return [-1, -1]
        firstPosition = self.findFirstPosition(nums, target)
        if firstPosition == -1:
            return [-1, -1]
        lastPosition = self.findLastPosition(nums, target)
        return [firstPosition, lastPosition]

    def findFirstPosition(self, nums, target):  # O(log n)
        index = -1
        left, right = 0, len(nums)-1
        while left <= right:
            mid = (left+right)//2
            if nums[mid] == target:
                index = mid
                right = mid-1
            elif nums[mid] < target:
                left = mid+1
            else:
                right = mid-1
        return index

    def findLastPosition(self, nums, target):  # O(log n)
        index = -1
        left, right = 0, len(nums)-1
        while left <= right:
            mid = (left+right)//2
            if nums[mid] == target:
                index = mid
                left = mid+1
            elif nums[mid] < target:
                left = mid+1
            else:
                right = mid-1
        return index


solution = Solution()
print(solution.searchRange([0, 0, 0, 1, 2, 3], 0))
print(solution.searchRange([], 3))
