# Time Complexity : O(log*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
# minimum element is the element which is less than it's neighbours
# if mid-element is greater than start-element which means array is left sorted and minimum element lies on right side
# shift start element to mid + 1
# else end = mid - 1


class Solution:
    def findMin(self, nums: list[int]) -> int:
        start = 0
        end = len(nums) - 1
        while start <= end:
            mid = start + (end-start)//2
            if nums[start] <= nums[end]:
                return nums[start]
            elif (mid == 0 or nums[mid] < nums[mid-1]) and (mid == len(nums) - 1 or nums[mid] < nums[mid+1]):
                return nums[mid]
            elif nums[mid] > nums[start]:
                start = mid + 1
            else:
                end = mid - 1


check = Solution()
print(check.findMin([4, 5, 6, 7, 0, 1, 2]))


# class Solution:
#     def findMin(self, nums: list[int]) -> int:
#         if nums[0] <= nums[-1]:
#             return nums[0]
#         else:
#             start = 0
#             end = len(nums) - 1
#             while start <= end:
#                 mid = start + (end-start)//2
#                 if nums[mid] > nums[mid+1]:
#                     return nums[mid + 1]
#                 elif nums[start] <= nums[mid]:
#                     start = mid + 1
#                 else:
#                     end = mid - 1
#
#
# check = Solution()
# print(check.findMin([4, 5, 6, 7, 0, 1, 2]))
