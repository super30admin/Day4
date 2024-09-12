# Time-Complexity: O(log(n))
# Space-Complexity: O(1)
# Solved in leetcode: yes
# Problem? : No

class Solution:
    def findPeakElement(self, nums):
        if len(nums) == 1: return 0
        if len(nums) == 2: 
            if nums[0] > nums[1]:
                return 0
            else:
                return 1
            
        left, right = 0, len(nums) - 1
        while(left <= right):
            mid = (left+right)//2
            
            # mid is peak
            if (mid > 0 and mid < len(nums)-1) and (nums[mid-1] < nums[mid] and nums[mid] > nums[mid+1]):
                return mid
            if mid==0:
                if nums[mid] > nums[mid+1]:
                    return mid
            if mid == len(nums) - 1:
                if nums[mid] > nums[mid-1]:
                    return mid
                
            # moving towards higher value direction
            # Go left
            if nums[mid-1] > nums[mid]:
                right = mid - 1
            # Go right no matter what
            else:
                left = mid + 1

obj = Solution()
print(obj.findPeakElement([1,2,3,1]))