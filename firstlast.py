//Time complexity: O(logn)
//space complexity: O(1)
//Code run on leetcode: yes

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        start, end = 0,len(nums)
        
        while start < end:
            
            mid = start + (end-start)//2;
            
            if nums[mid] == target:
                start = mid;
                end = mid;
                
                while start-1>=0 and nums[start-1] == target:
                    start = start-1
                
                while end+1 < len(nums) and nums[end+1] == target:
                    end = end +1
                    
                return [start,end]
            elif target < nums[mid]:
                end = mid
            elif target > nums[mid]:
                start = mid+1
                
        return [-1,-1]