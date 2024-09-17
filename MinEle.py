#Time complexity: O(log n)
#Space Complexity: O(1); as no extra space is being used
# Successful Run on leetcode: yes
# Any Issues while coding: no
'''
we first check if the array is sorted, if so return the first value
else check if left side is sorted and reject that side and check on other side, same goes with the right side

'''

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = low + (high - low) // 2
            if nums[low] <= nums[high]:
                return nums[low]
            if (mid == 0 or nums[mid] < nums[mid-1]) and (mid == len(nums)-1 or nums[mid] < nums[mid+1]):
                return nums[mid]
            elif nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return 999
            
        
