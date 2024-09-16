"""
 FAANMG Problem #9 {Medium }

Problem 2
153. Find Minimum in Rotated Sorted Array

Time Complexity : O( log n)
 

Space Complexity : O(1)
Constant Space 

Did this code successfully run on Leetcode : Yes

BinarySearch is used to fing the minimum in the array
The condition used here is to if( arr[mid] > arr[r]):
    if the mid element value is greater than the last element pointed by the R 
    then the right side arry is considered by l=mid+1
    or else the the end points to the mid value
    
@name: Rahul Govindkumar_RN27JUL2022
"""

class Solution:
    
    def binarySearch(self, arr, l ,r):
        
        while( l< r):
            
            mid = (l+r)//2
            
            if( arr[mid] > arr[r]):
                l= mid+1
            else:
                r = mid
        
        return arr[l]
        
    def findMin(self, nums: List[int]) -> int:
        
        l =0
        r = len(nums) -1
        
        return self.binarySearch(nums, l,r)