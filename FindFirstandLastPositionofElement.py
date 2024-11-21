// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def binarysearchleft(low,high,target,nums): #binary search for the left most index of target
            while low<=high:
                
                mid=low+(high-low)//2

                if nums[mid]==target:
                    if mid==0 or nums[mid-1]!=target  :
                        return mid
                    else:

                        high=mid-1
                elif nums[mid]>target:
                    high=mid-1
                else:
                    low=mid+1
                    
            return -1
        def binarysearchright(low,high,target,nums): # binary search for the right most index of target
            while low<=high:

                mid=low+(high-low)//2

                if nums[mid]==target:
                    if mid==len(nums)-1 or nums[mid+1]!=target :
                        return mid
                    else:

                        low=mid+1
                elif nums[mid]>target:
                    high=mid-1
                else:
                    low=mid+1
                    
            return -1
        
        left=0
        right=len(nums)-1
        first=binarysearchleft(left,right,target,nums)
        last=binarysearchright(left,right,target,nums)
        return [first,last] # returning answer of array of left and right.
