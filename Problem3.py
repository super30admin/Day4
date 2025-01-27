#Find Peak Element
#Check if neighbors are less than the current element
#if not found move to the side which is larger than mid
#Time Complexity: O(logn)
#Space COmplexity: O(1)

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        low  = 0
        high = n - 1

        while low <= high:
            mid = low + (high - low) // 2
            if ((mid == 0 or nums[mid] > nums[mid - 1])
                and (mid == n - 1 or nums[mid] > nums[mid +1])):
                return mid
            else:
                if mid > 0 and nums[mid - 1] > nums[mid]:
                    high  = mid -1
                else:
                    low  = mid + 1