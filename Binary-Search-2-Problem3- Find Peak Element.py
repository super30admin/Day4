"""
 FAANMG Problem #10 {Medium }

Problem 3
162. Find Peak Element

Time Complexity : O( log n)
 

Space Complexity : O(1)
Constant Space 

Did this code successfully run on Leetcode : Yes

Using Binary Search, trying ti check if the mid value is smaller than the next value and taking the 
right half or working in the left half
    
@name: Rahul Govindkumar_RN27JUL2022
"""


class Solution:
    
    def binarySearch(self, arr, l ,r):
        
        while( l< r):
            
            mid = (l+r)//2
            
            if( arr[mid] < arr[mid+1]):
                l= mid+1
            else:
                r = mid
        
        return l
            
    def findPeakElement(self, nums: List[int]) -> int:
        
        l =0
        r = len(nums) -1
      
        return self.binarySearch(nums, l,r)