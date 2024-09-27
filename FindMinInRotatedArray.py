#Time Complexity : O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this :

class Solution:
    def findMin(self, nums) -> int:
        left = 0
        right = len(nums) - 1
        while left < right:
            mid = (left + right) // 2
            if (nums[mid] > nums[right]):
                left = mid + 1
            else:
                right = mid

        return nums[left]