# Created by Aashish Adhikari at 2:58 PM 12/25/2020

'''
Time Complexity:
searchRange() : O(2 * logn) since two consecutive binary searches

Space Complexity:
searchRange(): O(1) since the auxiliary space created for each call of searchRange() is a constant
                Regardless of how many times the while loop executes, the same variable is reused.

Passes LettCode: Yes

Issue during implementation: No
'''

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        l = 0
        r = len(nums)-1

        low = None
        high = None

        # Binary search to find the leftmost target
        while l <= r:

            mid = l + (r-l)//2


            if nums[mid] == target:

                if mid != 0:

                    if nums[mid-1] != target:
                        low = mid
                        break
                    else:
                        r = mid-1
                else:
                    low = 0
                    break
            elif nums[mid] < target:

                l = mid+1
            else:
                r = mid-1

        if low is None:
            # a single instance of target wasnt found, so return [-1,-1]
            return [-1, -1]

        # Binary search to find the rightmost target
        l = 0
        r = len(nums)-1
        while l <= r:

            mid = l + (r-l)//2


            if nums[mid] == target:

                if mid != len(nums)-1:

                    if nums[mid+1] != target:
                        high = mid
                        break
                    else:
                        l = mid+1
                else:
                    high = len(nums)-1
                    break
            elif nums[mid] < target:

                l = mid+1
            else:
                r = mid-1

        return [low, high]





