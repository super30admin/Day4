# Time Complexity- O(n)
# Space Complexity- O(n)
# Will update this solution to optimize time complexity, submitting whatever is done so far. 
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:

        for i in range(1, len(nums)-1):

            if (nums[i] > nums[i-1] and nums[i] > nums[i+1]):
                return i
        return -1