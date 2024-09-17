"""Python implementation of finding the peak element
Time complexity : O(logN) where N is the number of elements in the array
Space Complexity : O(1) re-using the given array 
Did the program run for all test cases on leetcode ? : Yes
"""

class Solution:
    def findPeakElement(self, nums: [int]) -> int:
        #edge case
        if not nums or len(nums) == 0:return -1
        
        l,h = 0,len(nums)-1
        
        while l <= h:
            m = (l+h)//2
            if (m == 0 or (nums[m] > nums[m-1])) & (m == len(nums)-1 or (nums[m] > nums[m+1])):
                return m
            elif (m > 0) & (nums[m] < nums[m-1]):
                h = m - 1
            else:
                l = m + 1
        return -1
    

S = Solution()
nums = [1,2,3,4,5,6,7,8,1,2]
print(S.findPeakElement(nums))