from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        """
        Brute force solution is to do a linear scan and keep track of min integer. Time complexity is O(n).
        Another way is to sort the array and return first integer. Time complexity is O(n log (n)).
        Optimal way is to use binary search to find the smallest integer.
        Time complexity is O(log (n)).
        :param nums: rotated sorted array of integers with no duplicates
        :return: minimum number
        """
        lo = 0
        hi = len(nums) - 1

        while lo <= hi:
            # lands on sorted range between lo and hi then minimum is nums[lo]
            # for example when the number of rotations = 0 or when there is one integer in the array. 
            if nums[lo] <= nums[hi]:
                return nums[lo]

            mid = lo + (hi - lo) // 2
            print(lo, mid, hi)
            # binary search base case, when the integer is smaller than both the right and left integers
            if nums[mid - 1] > nums[mid] < nums[mid + 1]:
                return nums[mid]

            # when array is left sorted move to right part since minimum will lie in that part
            elif nums[lo] <= nums[mid]:
                lo = mid + 1

            # when array is right sorted move to left part since minimum will lie in that part
            elif nums[mid] < nums[hi]:  # right sorted
                hi = mid - 1


obj = Solution()
print(obj.findMin([2]))
