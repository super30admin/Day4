# Time Complexity : O(lg n) - first, last, searchRange
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Tried tocombine two searches in one BS. (Attempted before class)
#
# Your code here along with comments explaining your approach
# 1. Run two binary search for first and last occurrence of target separately
# 2. In first(), if mid finds target -> check if its greater than it's left neighbor (as it's sorted array) -> if Yes, return mid which is the first occurrence
#                                    -> if Not, then we move to left as the first occurrence of target can only occur before this mid
# 3. Similarly in second(), if mid finds target -> check if its less than it's right neighbor (as it's sorted array) -> if Yes, return mid which is the last occurrence
#                                               -> if Not, then we move to right as the last occurrence of target can only occur after this mid


class Solution:
    def first(self, nums, start, end, target):
        while start <= end:
            mid = start + (end - start) // 2
            
            if nums[mid] == target:
                if mid == 0 or nums[mid] > nums[mid - 1]:
                    return mid
                else:
                    end = mid - 1
                    
            elif nums[mid] < target:
                start = mid + 1
                
            else:
                end = mid - 1
                
        return -1
    
    def last(self, nums, start, end, target):
        while start <= end:
            mid = start + (end - start) // 2
            
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid] < nums[mid + 1]:
                    return mid
                else:
                    start = mid + 1
                    
            elif nums[mid] < target:
                start = mid + 1
                
            else:
                end = mid - 1
                
        return -1
                
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        if not nums:
            return [-1, -1]
        
        first_pos = self.first(nums, 0, len(nums) - 1, target)
        last_pos = self.last(nums, first_pos, len(nums) - 1, target)
        
        return [first_pos, last_pos]
        
