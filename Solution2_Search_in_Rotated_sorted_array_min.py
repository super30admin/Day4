// Time Complexity : O(logn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
'''
1. Goal is move towards position where element is less
   than previous element
2. move pointers to unsorted portion of the array
3. Edge cases will be when mid at zero position 
'''



class Solution:
    def findMin(self, nums: List[int]) -> int:
        s=0
        e=len(nums)-1
    
        
        while(s<=e):
            
            #array is sorted
            if nums[s]<=nums[e]:
                return nums[s]
            
            mid=s+(e-s)//2
            
            #searching for pivot element
            if (mid!=0 and nums[mid] < nums[mid-1]):
                    return nums[mid]
            
            if nums[mid] < nums[e]:
                e=mid-1
                
            else:
                s=mid+1
            
            
                
        