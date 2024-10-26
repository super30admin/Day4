# The code defines a searchRange method to find the starting and ending positions of a target value in a sorted array using binary search.
# The main method calls a helper method, binarySearch, twice to locate the leftmost (starting) and rightmost (ending) occurrences of the target.
# 
# In each call to binarySearch:
#   - Two pointers, 'left' and 'right', represent the boundaries of the current search space.
#   - A variable 'index' is initialized to -1 to store the potential position of the target, if found.
#   - In each iteration:
#       - The mid-point (mid) is calculated to divide the array in half.
#       - If nums[mid] is equal to the target, 'index' is updated to 'mid'.
#           - If searching for the leftmost position (side = 0), the search continues in the left half by setting right = mid - 1.
#           - If searching for the rightmost position (side = 1), the search continues in the right half by setting left = mid + 1.
#       - If nums[mid] is greater than the target, the search shifts to the left half by setting right = mid - 1.
#       - If nums[mid] is less than the target, the search shifts to the right half by setting left = mid + 1.
#   - If the target is not found after the loop, the binarySearch returns -1 for that side, indicating that the target is not present.
# 
# The searchRange method returns a list containing the leftmost and rightmost positions of the target.
# 
# TC: O(log n) - Each binary search call runs in logarithmic time due to the halving of the search space.
# SC: O(1) - Constant space is used, as only pointers and the 'index' variable are maintained.


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        # '0' for left side, '1' for right side
        left = self.binarySearch(nums, target, 0)
        right = self.binarySearch(nums, target, 1)
        return [left, right]

    
    def binarySearch(self, nums, target, side):
        left, right = 0, len(nums) - 1
        index = -1
        while left <= right:

            mid = (left + right) // 2

            if target > nums[mid]:
                left = mid + 1
            elif target < nums[mid]:
                right = mid - 1
            else:
                index = mid
                if side == 0:
                    right = mid - 1
                else:
                    left = mid + 1
        return index