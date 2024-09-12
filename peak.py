//Time complexity: O(logn)
//space complexity: O(1)
//Code run on leetcode: yes


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left,right = 0,len(nums)-1
        while left+1 < right:
            mid = left + (right-left)//2
            if nums[mid]<nums[mid+1]:
                left = mid
            elif nums[mid]<nums[mid-1]:
                right = mid
            else:
                return mid
        
        if nums[left]>nums[right]:return left
        else: return right