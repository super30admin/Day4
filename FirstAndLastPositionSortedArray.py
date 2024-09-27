# -*- coding: utf-8 -*-
"""
Created on Sat Sep 19 18:27:18 2020

@author: Tripti Santani

Time Complexity: O(log N)
Space Complexity: O(log N)

Code submitted successfully in leetcode

Approach:
   Step1: Define an output list and initialize it with [-1,-1]. This will be the default value of the output if input
          not found or if input array is empty. Define left = 0 i.e. starting index of list and right = len(nums)-1
          as it is the end of the list
   Step2: Write a function binary_search where the arguments are list,target,left,right,isLeft(boolean) and output
   Step3: Start a while loop with terminating condition of left <= right
   Step4: Find the middle index and store it in mid
   Step5: Check if the list at index mid is equal to target. If yes, and we are finding the first occurence(Check
          for boolean isLeft, if true the we are searching for fitst occurence), then replace the 0th index of output
          with the mid else replace the 1st index number of the output with mid
   Step6: Else if the target is smaller than the list with index mid, replace right = mid - 1 (Intuition is if target 
          is smaller, then it will lie to the left of mid in case if the target is present)
   Step7: Else it will lie to the right of target and in that case, update left = mid + 1
   Step8: Call the binary_search method twice one to find start position (boolean isLeft True) and the last position
   Step9: Return output
    
    
"""

class Solution:
    
    
    def searchRange(self, nums, target):
        
        output =[-1,-1]
        #edge case
        if len(nums) == 0 or nums == None:
            return output
        
        left = 0
        right = len(nums) - 1
        self.binary_search(nums,target,left,right,True,output)
        self.binary_search(nums,target,left,right,False,output)
        
        return output
        
        
        
    
    def binary_search(self,arr, target, left, right, isLeft,output):
        
        while(left <= right):
            
            mid = int(left+(right-left)/2)
            
            if arr[mid] == target:
                if isLeft:
                    output[0] = mid
                    right = mid-1
                else:
                    output[1] = mid
                    left = mid + 1
            
            elif arr[mid] > target:
                right = mid - 1
                
            else:
                left = mid + 1
                
''' Driver Code '''
                
nums=[5,7,7,8,8,10]
target1 = 8
target2 = 6
bs = Solution()
result1 = bs.searchRange(nums,target1)  
print(result1)              
result2 = bs.searchRange(nums,target2)  
print(result2)
        
  
# Code when separate methods were written to find first and last element      
#         result = []
#         first = self.first_index(nums,target)
#         last = self.last_index(nums,target)
        
#         result.append(first)
#         result.append(last)
        
#         return result
    
#     def first_index(self,arr,target):
#         start = 0
#         end = len(arr) - 1
#         first = -1
        
#         while(start<=end):
            
#             mid = int(start + (end-start)/2)
            
#             if arr[mid] == target:
#                 first = mid
#                 end = mid - 1
#             elif target < arr[mid]:
#                 end = mid - 1
#             else:
#                 start = mid + 1
        
#         return first
    
#     def last_index(self,arr,target):
#         start = 0
#         end = len(arr) - 1
#         last = -1
        
#         while(start<=end):
            
#             mid = int(start + (end-start)/2)
            
#             if arr[mid] == target:
#                 last = mid
#                 start = mid + 1
#             elif target < arr[mid]:
#                 end = mid - 1
#             else:
#                 start = mid + 1
        
#         return last
                