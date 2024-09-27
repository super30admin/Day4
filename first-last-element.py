# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        low = 0
        high = len(nums)-1
        first = last = -1

        # find first index
        while (low <= high):
            mid = (low+high)//2

            # if target is found
            if (nums[mid] == target):
                # check if its the lowest index
                if mid == 0 or nums[mid-1] < target:
                    first = mid
                    break
                # find lowest index
                else:
                    high = mid-1
            elif nums[mid] > target:
                high = mid-1
            else:
                low = mid+1

        low = first + 1
        last = first
        high = len(nums)-1

        # if target exists in array find last index
        if first != -1:
            while (low <= high):
                mid = (low+high)//2
                # when target found
                if (nums[mid] == target):
                    # check if its the max index
                    if mid == len(nums)-1 or nums[mid+1] > target:
                        last = mid
                        break
                    # find max index
                    else:
                        low = mid+1
                elif nums[mid] > target:
                    high = mid-1
                else:
                    low = mid+1

        return [first, last]
