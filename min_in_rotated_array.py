# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def findMin(self, nums):
        if len(nums) == 1:
            return nums[0]

        start = 0
        end = len(nums) - 1
        
        # If array is not rotated i.e. array rotated 0, n, 2n, 3n....times
        if nums[start] < nums[end]:
            return nums[start]
        
        while end >= start:
            mid = (start + end) // 2
            
            # Target found
            if nums[mid] > nums[mid+1]:
                return nums[mid+1]
            # Target found
            elif nums[mid] < nums[mid-1]:
                return nums[mid]
            else:
                # Target belongs to right sub-array
                if nums[start] < nums[mid]:
                    start = mid + 1
                # Target belongs to left sub-array
                else:
                    end = mid - 1

solution = Solution()
print(f"OUTPUT >> {solution.findMin([4,5,6,7,-1,0,1,2])}")