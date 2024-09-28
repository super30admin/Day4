# // Time Complexity : O(lg n) 
# // Space Complexity : O(1)  
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums: return [-1,-1]
        self.nums = nums
        self.target = target
        index_first = self.first_pos(0, len(nums)-1)
        if index_first == -1:
            return [-1,-1]
        index_last = self.last_pos(index_first, len(nums)-1)
        
        return [index_first, index_last]
    
    
    def first_pos(self, start, end):
        while start <= end:
            # print(start,end)
            mid = start + (end-start)//2
            # if the mid element matches target element, 
            # we need to ensure the element is the left most 
            # occurrence of the target 
            if self.nums[mid] == self.target and (mid == 0 or self.nums[mid-1] < self.target):
                return mid
            elif self.nums[mid] < self.target:
                start = mid + 1
            else:
                # go left as mid element is greater 
                # than or equal to target
                end = mid-1
        return -1
    
    
    def last_pos(self, start, end):
        while start <= end:
            mid = start + (end-start)//2
            # if the mid element matches target element, 
            # we need to ensure the element is the right most 
            # occurrence of the target 
            if self.nums[mid] == self.target and (mid == len(self.nums)-1 or self.nums[mid+1] > self.target):
                return mid
            # need to keep moving right as we haven't 
            # found the target element yet
            elif self.nums[mid] <= self.target:
                start = mid + 1
            else:
                end = mid - 1
        return -1