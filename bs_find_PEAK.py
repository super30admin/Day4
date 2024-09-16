'''
// Time Complexity : O(log(N) I is index of target)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Took hints to solve this problem


// Your code here along with comments explaining your approach

Observe following examples, understand what is meant as peak
    [1] => 1
    [2,3] => 3
    [1,3,2] => 3
    [1,3,2,4,5] => 5
    
    Logic is : Go to mid , check next element 
        - if next is bigger discard left sub array search in right sub array
        - keep do this until you reach peak 
'''
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l,r=0,len(nums)-1
        
        while l<r:
            mid=(l+r)//2
            # Check mid is peak
            if nums[mid]>nums[mid+1]:
                r=mid
            else:
                l=mid+1
        
        return l 
