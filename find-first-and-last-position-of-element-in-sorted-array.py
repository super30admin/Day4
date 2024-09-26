#Time Complexity: O(N)
#Space Complexity: O(1)
#Did this code successfully run on Leetcode: Yes


class Solution(object):
    def searchRange(self, nums, target):
        lis = []

        left = self.binarysearchleft(nums, target, 0, len(nums) - 1)
        right = self.binarysearchright(nums, target, 0, len(nums) - 1)
        lis.append(left)
        lis.append(right)
        return lis

    def binarysearchleft(self, nums, target, low, high):

        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid != low and nums[mid - 1] == target:
                    high = mid - 1
                else:
                    return mid



            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def binarysearchright(self, nums, target, low, high):

        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid != high and nums[mid + 1] == target:
                    low = mid + 1
                else:
                    return mid



            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1