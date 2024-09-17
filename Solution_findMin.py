"""
Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :Nope

Minimum in rotated sorted array
"""


class Solution_findMin:
    def findMin(self, nums: List[int]) -> int:
        if len(nums)==1:
            return nums[0]
        left=0
        right=len(nums)-1
        
        if nums[left]<nums[right]: #sorted not rotated - first elem<last elem
            return nums[0]
        
        while(left<=right):
            mid=left+(right-left)//2
            
            if nums[mid] > nums[0]: #if mid element is greater than first element, search right side
                left = mid + 1
            else:#if mid element is lesser than first element, search left side
                right = mid - 1
            
            #if the mid element is greater than next element, thats where rotation happens so mid+1 element is smallest
            if nums[mid] > nums[mid + 1]:
                return nums[mid + 1]
            #if the mid element is less than previous element, mid is smaller
            if nums[mid-1] > nums[mid]:
                return nums[mid]
            
            
            
