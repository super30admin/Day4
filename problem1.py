# Time Complexity: O(log(N))
# Space Complexity: O(log(N))
# Passed on leetcode
# No problems

class Solution:
    
    def binary_search(self, left, right, go_left):
        if left <= right:
            
            mid = left + (right - left) // 2

            if self.nums[mid] == self.target:
                if go_left:
                    self.output[0] = mid
                else:
                    self.output[1] = mid
            
            if self.target < self.nums[mid] or (go_left and self.target == self.nums[mid]):
                self.binary_search(left, mid - 1, go_left)
            else:
                self.binary_search(mid + 1, right, go_left)
                
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        self.nums = nums
        self.target = target
        self.output = [-1, -1]
        
        if len(nums) == 0:
            return self.output
        
        if len(nums) == 1:
            if nums[0] == target:
                return [0, 0]
            return self.output
        
        self.binary_search(0, len(nums) - 1, True)
        
        if self.output[0] == -1:
            return self.output
        
        self.binary_search(0, len(nums) - 1, False)
        
        return self.output