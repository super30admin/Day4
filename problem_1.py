from typing import List


class Solution:
    def find_first_index(self, lo, hi, nums, target):
        """
       :param lo: 0
       :param hi: length of array -1
       :param nums: integer array with duplicates, can be empty as well
       :param target: to search
       :return: the first index of target in nums if exists else -1
        """
        while lo <= hi:
            mid = lo + (hi - lo) // 2

            # check for out of bound since comparing with mid -1
            if (nums[mid] == target and mid - 1 >= 0 and nums[mid - 1] < target) or (
                    # 0 index is the first index
                    nums[mid] == target and mid - 1 < 0):
                return mid

            # it is possible that target is found but not the first index thus, continue the search
            # that is why >= to sign
            elif nums[mid] >= target:
                hi = mid - 1

            elif nums[mid] < target:
                lo = mid + 1
        return -1

    def find_second_index(self, lo, hi, nums, target):
        """
        :param lo: first index of target
        :param hi: length of array -1
        :param nums: integer array with duplicates, can be empty as well
        :param target: to search
        :return: the second index of target in nums
        """
        while lo <= hi:
            mid = lo + (hi - lo) // 2

            if (nums[mid] == target and mid + 1 <= len(nums) - 1 and nums[mid + 1] > target) or (
                    nums[mid] == target and mid + 1 > len(nums) - 1):
                return mid

            elif nums[mid] > target:
                hi = mid - 1

            elif nums[mid] <= target:
                lo = mid + 1

        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        """
        The brute force method is to do linear search on the array for the target, when first occurrence is found
         keep searching for the last occurrence. This takes O(n) time.
        Intuition: To reduce the time complexity we can two run binary searches, one to find the first occurrence
        and another to find the last occurrence.  This takes O(2 log(n)) time, better than O(n) since the search space
         is reduced by half on each iteration of the binary search algorithm.
        If we do one binary search, for example once target is found do the binary search on the left and right parts
        then the time complexity would be O(n) since every value is touched in the process.
        Edge case: first/second index is 0th or last index.
        :param nums: integer array with duplicates, can be empty as well
        :param target: to search
        :return: return the first and last index of target if found else [-1,-1]
        """

        if not nums:
            return [-1, -1]

        lo = 0
        hi = len(nums) - 1
        first_index = self.find_first_index(lo, hi, nums, target)
        second_index = self.find_second_index(first_index, hi, nums, target)

        return [first_index, second_index]


obj = Solution()
print(obj.searchRange([5, 7, 7, 8, 8, 10], 8))
