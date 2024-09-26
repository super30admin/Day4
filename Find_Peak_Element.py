class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        nums = [float("-inf")] + nums + [float("-inf")]
        left = 1
        right = len(nums)-2
        peak = max(nums[0],nums[-1])
        while(left<=right):
            mid = left + (right-left)//2
            if nums[mid]<nums[mid-1]:
                peak = mid-1
                right = mid-1
            else:
                peak = mid
                left = mid+1
        return peak-1
#Time Complexity:O(n)
#Space Complexity: O(n)