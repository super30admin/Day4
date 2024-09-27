# Created by Aashish Adhikari at 3:45 PM 12/25/2020

'''
Time Complexity:
findPeakElement() : O(logn) since a regular binary search

Space Complexity:
findPeakElement(): O(1)

Passes LettCode: Yes

Issue during implementation: Initially yes, failed to come up with such a simple if-else condition.
                             Not now.

'''

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        left = 0
        right = len(nums)-1

        while left <= right:

            if left == right:
                return left

            mid = left + (right-left)//2

            if nums[mid] < nums[mid+1]:
                left = mid+1
            else:
                right = mid
