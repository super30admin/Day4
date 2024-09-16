"""
Approach:
The idea is to eliminate one of the two partitions during binary whose likelihood of having a peak element is less.
since there are multiple peaks, even if the eliminated partition has a peak, we do not care. This solution wll not work
for cases where max, min or all peaks are to be found.

1) during binary search, compare the middle element to its neighbours, the greater neighbour could be peak if its other
neighbor (if present) is also smaller than itself. so it makes more sense to search the partition including it.

2) middle element's smaller neighbor is for sure not a peak, so eliminate the partition including it.
"""
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        lo = 0
        hi = n - 1


        while lo <= hi:
            m = lo + (hi - lo )//2

            # when peak found
            if (m == 0 or nums[ m -1 ] <nums[m]) and \
                    (m == n- 1 or nums[m + 1] < nums[m]):
                return m

            # when left neighbor is greater, its more likely to find the peak on the left partition...
            elif (m == 0 or nums[m] < nums[m - 1]) and (m == n - 1 or nums[m] > nums[m + 1]):
                hi = m - 1
            else:
                lo = m + 1
        return -1

"""
Time Complexity: O(log n)
Space Complexity: O(1)
"""