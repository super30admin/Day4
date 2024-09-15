# Time Complexity : O(log n) because twith every iteration the length of array in which we search reduces to half
# Space Complexity : O(1) constant space is required 
# Did this code successfully run on Leetcode :  Yes 
# Any problem you faced while coding this : Managing the edge cases of index out of bounds


# Your code here along with comments explaining your approach : - Just apply normal binary search and check if mid is greater than mid-1 and mid+1 then return mid or else set the first and last accordingly



class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        first =0
        last = len(nums)-1
        
        while first <= last:
            mid = (last+first)//2
            if (mid== first or nums[mid] > nums[mid-1]) and (mid == last or nums[mid] > nums[mid+1]):
                return mid
            elif mid==len(nums)-1 or nums[mid+1] > nums[mid]:
                first = mid + 1
            else:
                last = mid -1
        return 12344     
                
            