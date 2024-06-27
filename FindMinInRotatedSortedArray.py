#The findMin method finds the minimum element in a rotated sorted array using binary search. It uses two pointers (left and right) to narrow down the search space. By comparing the middle element (mid) with the rightmost element, it determines which half of the array contains the minimum value, and adjusts the pointers accordingly. This process continues until the pointers converge, at which point nums[left] is the minimum element. The method operates in O(log n) time due to the binary search and uses O(1) space since it requires only a few variables.

class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        while left < right:
            mid = left + (right - left) // 2
            if nums[mid] < nums[right]:
                right = mid
            else:
                left = mid + 1
                
        return nums[left]