class Solution(object):
# Python program to find minimum element in a 
# sorted and rotated numsay using binary search
    def findMin(self,nums):
        l, r = 0, len(nums) - 1

        while l < r:
            if nums[l]<=nums[r]:
                return nums[l]
            
            mid = l + (r - l) // 2
            
            if nums[mid] > nums[r]:
                l = mid + 1
            else:
                r = mid
        
         
        return nums[l]
**Time Complexity: O(log n)**

- The algorithm uses binary search, dividing the search space in half with each iteration

**Space Complexity: O(1)**

- Only uses a constant amount of extra space for variables (l, r, mid)
