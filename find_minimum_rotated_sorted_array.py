#find_minimum_rotated_sorted_array
#time complexity: O(logN)
#space complexity: O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def findMin(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1
        n = len(nums)
        if nums[left] <= nums[right]:
            return nums[left]
        while left <= right:
            if nums[left] <= nums[right]:
                return nums[left]
            mid = (left + right)//2
            nxt = (mid + 1) % n
            prev = (mid + n -1) % n
            if nums[mid] <= nums[prev] and nums[mid] <= nums[nxt]:
                return nums[mid]
            if nums[left] <= nums[mid]:
                left = mid + 1
            elif nums[mid] <= nums[right]:
                right = mid - 1
        
        return -1 