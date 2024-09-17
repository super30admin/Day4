"""Python implementation of first and last occurence of a number
Time complexity : O(logN) where N is the number of elements in the array
Space Complexity : O(1) re-using the given array 
Did the program run for all test cases on leetcode ? : Yes
"""

class Solution:
    
    def firstbinarySearch(self, nums: List[int], target: int, l: int, h: int) -> int:
        l,h = 0, len(nums)-1
        while l <= h:
            m = (l+h)//2
            if nums[m] == target:
                if (m==0 or (nums[m] > nums[m-1])):
                    return m
                else:
                    h = m - 1
            elif nums[m] < target:
                    l = m + 1
            else:
                h = m - 1
        return -1
               
    def lastbinarySearch(self, nums: List[int], target: int, l: int, h: int) -> int:
        l,h = 0, len(nums)-1
        while l <= h:
            m = (l+h)//2
            if nums[m] == target:
                if m==h or (nums[m] < nums[m+1]):
                    return m
                else:
                    l = m + 1
            elif nums[m] > target:
                    h = m - 1
            else:
                l = m + 1
        return -1
        
        
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        #edge case
        if not nums:return [-1,-1]        
              
        l,h = 0, len(nums)-1
        f = self.firstbinarySearch(nums,target,l,h)
        l = self.lastbinarySearch(nums,target,l,h)
        return [f,l]
        