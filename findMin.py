"""
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:
Input: [3,4,5,1,2]
Output: 1

Example 2:
Input: [20,0,1,2,3,4,5,6,7,8]
Output: 0

Example 3:
Input: [20,19, 18, 17, 16, 10, 1, 2]
Output: 0

ez on search
bi search?
compare mid nt to last, which is smaller?
    back mid -1 //check if smaaler val exist
compare mid to first, smaller
middle value, no target

Time: OLogN
Space: O 1

"""

class Solution:
    def findMin(self, nums: list[int]) -> int:
        # set left and right bounds
        left, right = 0, len(nums)-1

        while left < right:
            mid = left + (right-left)//2

            if nums[mid] > nums[right]:
            #pivot must be on the right
             left = mid + 1
            else: right = mid
        return nums[left]

