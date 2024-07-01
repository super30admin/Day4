"""
TC - O(Log(N))
SC - O(1)
Approach:
Check if the array is completely sorted then return low = first element in array
If mid is not at 0 and mid value is less than value on the left then min is mid element.
This means the rotation point is found, we creturn mid as it is min.
Otherwise, check if element at low < element at mid, if yes move right.
If not true, go to left side as surely that is where min is located.
"""


class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            if nums[low] <= nums[high]:
                return nums[low]

            mid = low + (high - low) // 2
            if mid != 0 and nums[mid] < nums[mid - 1]:
                return nums[mid]
            elif nums[low] <= nums[mid]:
                low = mid + 1
            else: 
                high = mid - 1