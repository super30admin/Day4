# Time Complexity : O(log(N))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findFirst(self, nums, target, index):
        left = 0
        right = index
        print(index)
        
        while left <= right:
            mid = int((left + right)/2)
            
            if nums[mid] == target and (mid == 0 or nums[mid-1] != target):
                return mid
            
            if nums[mid] < target:
                left = mid + 1
            
            if nums[mid] >= target:
                right = mid - 1

                
    def findLast(self, nums, target, index):
        left = index
        right = len(nums) - 1
        
        while left <= right:
            mid = int((left + right)/2)
            print(mid)
            if nums[mid] == target and (mid == len(nums) - 1 or nums[mid+1] != target):
                return mid
            
            if nums[mid] <= target:
                left = mid + 1
            
            if nums[mid] > target:
                right = mid - 1

        
        
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        output = []
        left = 0
        right = len(nums) - 1
        
        while left <= right:
            mid = int((left + right)/2)
            
            if nums[mid] == target:
                output.append(self.findFirst(nums, target, mid))
                output.append(self.findLast(nums, target, mid))
                return output
            elif nums[mid] < target:
                left = mid + 1
            else: 
                right = mid - 1
        return [-1, -1]
        
            
            
                
                    
                
        