# Find Minimum in Rotated Sorted Array
# Time complexity: O(logn)
# Space complexity: O(1)

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = low + (high - low) / 2
            if ((mid == 0 or nums[mid] < nums[mid - 1]) and
            (mid == (len(nums) - 1) or nums[mid] < nums[mid + 1])):
                return nums[mid]
            elif nums[mid] > nums[high]: 
                # Checking this condition first because its a rotated sorted array and depends on how array is rotated
                low = mid + 1
            else:
                high = mid - 1
        return -1

# obj = Solution()
# print(obj.findMin([3,4,5,1,2]))