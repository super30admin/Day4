# time complexity = O(logn)
# space complexity = O(1)
# Tested on leetcode
# Use binary search to find the peak element
# Always move towards the higher number as it guarantees finding a peak element
# If we have to find all peak elements or max peak element then it would be a O(n) solution

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        # [7,6,5,4,3,1,2,1]
        low = 0
        high = len(nums)-1
        while (low <= high):
            mid = low + (high - low) // 2
            # confirm if its the peak element by checking its neighbors. 
            # handly mid as first and last element
            if (mid == 0 or  nums[mid] > nums[mid-1]) and (mid == len(nums)-1 or nums[mid] > nums[mid+1]):
                return mid
            # move towards higher end
            elif  nums[mid + 1] > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return low
