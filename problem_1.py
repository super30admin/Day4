# Time Complexity : O(log*n) + O(log*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
# find left-index using a binary search
# find right-index using a binary search


class Solution:
    def lindex(self, nums, start, end, target):
        while start <= end:
            mid = start + (end - start)//2
            if nums[mid] == target:
                if mid == 0 or nums[mid] != nums[mid - 1]:
                    return mid
                end = mid - 1
            elif nums[mid] > target:
                end = mid - 1
            else:
                start = mid + 1
        return -1

    def rindex(self, nums, start, end, target):
        while start <= end:
            mid = start + (end - start)//2
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid] != nums[mid + 1]:
                    return mid
                start = mid + 1
            elif nums[mid] > target:
                end = mid - 1
            else:
                start = mid + 1
        return -1

    def searchRange(self, nums: list[int], target: int) -> list[int]:
        start = 0
        end = len(nums) - 1
        left = self.lindex(nums, start, end, target)
        right = self.rindex(nums, left, end, target)
        return [left, right]


check = Solution()
print(check.searchRange([5, 7, 7, 8, 8, 10], 11))


# class Solution:
#     def searchRange(self, nums: list[int], target: int) -> list[int]:
#         start = 0
#         end = len(nums) - 1
#         result = [-1, -1]
#         while start <= end:
#             mid = start + (end - start) // 2
#             if nums[mid] == target:
#                 end = mid - 1
#                 result[0] = mid
#             elif target > nums[mid]:
#                 start = mid + 1
#             else:
#                 end = mid - 1
#
#         start = 0
#         end = len(nums) - 1
#         while start <= end:
#             mid = start + (end - start) // 2
#             if nums[mid] == target:
#                 start = mid + 1
#                 result[1] = mid
#             elif target > nums[mid]:
#                 start = mid + 1
#             else:
#                 end = mid - 1
#         return result
#
#
# check = Solution()
# print(check.searchRange([5, 7, 7, 8, 8, 10], 8))

# def searchRange(self, nums: List[int], target: int) -> List[int]:
#     start = 0
#     end = len(nums) - 1
#     while start <= end:
#         mid = start + (end - start)//2
#         if nums[mid] == target:
#             l, r = mid, mid
#             while l != 0 and nums[l-1] == target:
#                 l -= 1
#             while r != len(nums)-1 and nums[r+1] == target:
#                 r += 1
#             return [l, r]
#         elif target > nums[mid]:
#             start = mid + 1
#         else:
#             end = mid - 1
#     return [-1, -1]

#
# check = Solution()
# print(check.searchRange([5, 7, 7, 8, 8, 10], 8))
