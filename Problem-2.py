'''
    Time Complexity: O(logn)
    Space Complexity: O(1)
    Ran successfully on Leetcode
    Difficulty: Had difficulty in building this logic. 
    Approach: The minimum element will be in the unsorted part of the array except if is a sorted range completely in which case it will be the first element. 
    Check the middle if it is the minimum element or move to the unsorted range
'''
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low, high = 0, len(nums) - 1

        while low <= high:
            # if nums[low] <= nums[high]:
            #     return nums[low]

            mid = low + (high - low) // 2

            if (mid == low or nums[mid - 1] > nums[mid]) and (mid == high or nums[mid] < nums[mid + 1]):
                return nums[mid]
            # Eliminate right side first if you don't need the sorted range check
            elif nums[high] >= nums[mid]: 
                high = mid - 1
            else:
                low = mid + 1

        return 0