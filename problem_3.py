# Time Complexity : O(log*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
# search towards greater element of mid
# there will always be a peak towards the greater element than mid.

class Solution:
    def findPeakElement(self, nums: list[int]) -> int:
        start = 0
        end = len(nums) - 1
        while start <= end:
            mid = start + (end - start) // 2
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums)-1 or nums[mid] > nums[mid + 1]):
                return mid
            elif nums[mid] < nums[mid + 1]:
                start = mid + 1
            else:
                end = mid - 1


check = Solution()
print(check.findPeakElement([2, 1]))


# class Solution:
#     def peak(self, nums, start, end):
#         while start <= end:
#             mid = start + (end - start)//2
#             if mid != 0 and mid != len(nums)-1 and nums[mid] > nums[mid+1] and nums[mid] > nums[mid-1]:
#                 return mid
#             elif mid != len(nums)-1 and nums[mid] < nums[mid + 1]:
#                 start = mid + 1
#             else:
#                 end = mid - 1
#
#     def findPeakElement(self, nums: list[int]) -> int:
#         start = 0
#         end = len(nums) - 1
#         mid = start + (end-start)//2
#         if mid != 0 and mid != len(nums)-1 and nums[mid] > nums[mid+1] and nums[mid] > nums[mid-1]:
#             return mid
#         if self.peak(nums, mid + 1, end):
#             return self.peak(nums, mid + 1, end)
#         if self.peak(nums, start, mid-1):
#             return self.peak(nums, start, mid-1)
#         return nums.index(max(nums[0], nums[-1]))
#
#
# check = Solution()
# print(check.findPeakElement([1, 6, 5, 4, 3]))
