from typing import List


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        """
        Brute force solution is to do a linear scan while comparing the right and left neighbour to the ith index
        and once peak is found return it. Time complexity is O(n).
        Optimal way is to use binary search to find the index of the peak.
        The idea is: peak can be found while moving towards the higher number (imagine like a mountain).
        So when comparing mid with its neighbours update lo or hi to higher neighbour of mid.
        This  is classic example which shows that it is not necessary that array has to be sorted for binary search.
        This takes O(log n) time.
        Edge cases: since the comparison is among mid+1, mid-1 and mid. Array out of bound array might happen.
        :param nums: integer array
        :return: peak element
        """
        lo = 0
        hi = len(nums) - 1

        while lo <= hi:
            mid = lo + (hi - lo) // 2
            # base case
            # mid-1 is not valid index and if it is nums[mid - 1]  is less than nums[mid] AND
            # mid+1 is not valid index and if it is nums[mid] is greater than nums[mid + 1]
            if (mid == 0 or nums[mid - 1] < nums[mid]) and (mid + 1 >= len(nums) or nums[mid] > nums[mid + 1]):
                return mid

            elif mid > 0 and nums[mid - 1] > nums[mid]:
                hi = mid - 1

            elif mid < len(nums) and nums[mid + 1] > nums[mid]:
                lo = mid + 1


obj = Solution()
print(obj.findPeakElement([1]))
print(obj.findPeakElement([1, 2, 6]))
print(obj.findPeakElement([1, 4, 5, 8, 9, 10, 12]))
