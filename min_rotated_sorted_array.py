"""Python implementation of finding the minimum in a sorted rotated array
Time complexity : O(logN) where N is the number of elements in the array
Space Complexity : O(1) re-using the given array 
Did the program run for all test cases on leetcode ? : Yes
"""

class Solution:
    def findMin(self, nums: [int]) -> int:
        #Edge case
        
        if not nums or len(nums)==0:return -1
        
        l,h = 0,len(nums)-1
        
        while l<=h:
            if nums[l] < nums[h]: return nums[l] #if array is already sorted ex. 0,1,2
            m = l + (h-l)//2 
            if (m==0 or nums[m] < nums[m-1]) & (m==len(nums)-1 or (nums[m] < nums[m+1])): #check for neighbours
                return nums[m]
            elif nums[l] <= nums[m]: #check for sorted array part
                l = m+1 #left half is sorted move towards right
            else:
                h = m-1 #right part is sorted, move towards left
        return -1
    
S=Solution()
nums = [5,-3,0,1,2,3,4]
print(S.findMin(nums))