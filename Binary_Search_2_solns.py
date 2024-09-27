# Time Complexity : O(log(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
import math
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def find_first_index(low, high):
            findex = math.inf
            while low <= high:
                mid = low + (high - low) // 2              
                if nums[mid] == target:
                    findex = min(findex, mid)
                    high = mid - 1
                elif target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
                    
            if findex == math.inf:
                return -1
            return findex
                 
        def find_last_index(low, high):
            lindex = -math.inf
            while low <= high:
                mid = low + (high - low) // 2              
                if nums[mid] == target:
                    lindex = max(lindex, mid)
                    low = mid + 1
                elif target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
                    
            if lindex == -math.inf:
                return -1
            
            return lindex
            
        low = 0
        high = len(nums) - 1
             
        left_index = find_first_index(low, high)
        if left_index == -1:
            return [-1, -1]
        right_index = find_last_index(left_index+1, high)
        
        if right_index == -1:
            return [left_index, left_index]
        
        
        
        return [left_index, right_index]
        


# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        
        if len(nums) == 1:
            return nums[0]
        
        while low <= high:
            mid = low + (high - low) // 2
            
            if nums[low] <= nums[high]:
                return nums[low]
            
            if nums[mid] <= nums[mid-1] and nums[mid] <= nums[mid+1]:
                return nums[mid]
            
            if nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
                       

# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        start = 0
        end = len(nums) - 1
        
        if 
        if nums[start] > nums[start+1]:
            return start
        elif nums[end] > nums[end-1]:
            return end
        
        start += 1
        end -= 1
        index = start + (end - start) // 2
        
        
        while index >= start or index <= end:
            if nums[index] > nums[index-1] and nums[index] > nums[index+1]:
                return index
            
            elif nums[index+1] > nums[index]:
                index += 1
            else:
                index -= 1
            