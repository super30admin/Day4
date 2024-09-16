'''
    Time Complexity:
        O(log(n))

    Space Complexity:
        O(1)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        -> If mid is less than its neighbors, than it is the smallest.
        -> If [left:mid] subarray is sorted:
            -> Continue search in [mid+1:high]
        -> Else:
            -> Continue search in [low:mid-1]
'''
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            if nums[low] < nums[high]:
                return nums[low]

            mid = low + (high - low) // 2

            if (mid == 0 or nums[mid] < nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] < nums[mid + 1]):
                return nums[mid]

            if nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1

        return -1
