# Created by Aashish Adhikari at 3:00 PM 12/25/2020

'''
Time Complexity:
findMin() : O(logn) since a regular binary search

Space Complexity:
findMin(): O(1)

Passes LettCode: Yes

Issue during implementation: No
'''


class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """


        left = 0
        right = len(nums)-1

        while left <= right:

            # Edge case of a single elemnt in the input array
            if left == right:
                return nums[left]

            mid = left + (right - left)//2

            # A rotated array always has at least one side sorted when split into two sub-arrays.

            if nums[left] <= nums[mid]:
                # left side is sorted

                # either right side is also sorted:
                if nums[mid+1] <= nums[right]:
                    if nums[left] < nums[mid+1]:
                        return nums[left]
                    else:
                        return nums[mid+1]
                # right side is not sorted, further search
                else:
                    left = mid+1



            else:
                # right side is sorted

                # either left side is also sorted
                if nums[left] <= nums[mid]:
                    if nums[left] < nums[mid+1]:
                        return nums[left]
                    else:
                        return nums[mid+1]

                else:
                    right = mid






