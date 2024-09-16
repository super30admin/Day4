# Time Complexity :  O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes!
# Any problem you faced while coding this : I had trouble with understanding
# the concept but it was easier to code the solution after the session.

# Your code here along with comments explaining your approach
class Solution(object):
    # if array empty return [-1, -1]
    # else perform 2 binarySearches to find start and end index
    def searchRange(self, nums, target):
        if(len(nums) == 0):
            return [-1, -1]
        start = self.binarySearchLeft(nums, target, 0, len(nums)-1)
        end = self.binarySearchRight(nums, target, 0, len(nums)-1)
        return [start, end]

    # if target at mid
    #       check for first occurrence if yes return mid
    #       else another occurrence before mid, bring right = mid - 1
    # else check for first occurrence in either right or left array and adjust pointers accordingly
    def binarySearchLeft(self, nums, target, left, right):
        while left <= right:
            mid = left + (right - left) / 2
            if nums[mid] == target:
                if mid == 0 or nums[mid] > nums[mid-1]:
                    return mid
                else:
                    right = mid - 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        return -1

    # if target at mid
    #       check for last occurrence if yes return mid
    #       else another occurrence after mid, bring low = mid + 1
    # else check for last occurrence in either right or left array and adjust pointers accordingly
    def binarySearchRight(self, nums, target, left, right):
        while left <= right:
            mid = left + (right - left) / 2
            if nums[mid] == target:
                if mid == len(nums)-1 or nums[mid] < nums[mid+1]:
                    return mid
                else:
                    left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        return -1

nums = [5, 7, 8, 8, 8, 9, 10]
target = 8
s = Solution()
print s.searchRange(nums, target)

