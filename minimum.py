//Time complexity: O(logn)
//space complexity: O(1)
//Code run on leetcode: yes

class Solution:
    def findMin(self, nums: List[int]) -> int:
        start, end = 0, len(nums)-1
        
        if len(nums) == 0:
            return -1
        
        if len(nums) ==1:
            return nums[0]
        
        if nums[start] < nums[end]:
            return nums[0]
        
        while start<=end:
            mid = start + (end - start)//2
            
            if nums[mid] > nums[mid+1]:
                return nums[mid+1]
            
            if nums[mid] < nums[mid-1]:
                return nums[mid]
            
            if nums[mid] > nums[0]:
                start = mid+1
            else:
                end = mid-1
            
            
            