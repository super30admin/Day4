# brute force : linear search, keep track of min element
# Time Complexity : O(n)
# Space Complexity : O(1)

# Time Complexity : O (log n)
# Space Complexity : O (1)
# Did this code successfully run on Leetcode : yes

# Your code here along with comments explaining your approach
# picking up from the rotated sorted array problem, here we need to find the pivot
# in rotated sorted array, if we divide at mid, one half would be sorted, one not, it contains the min element 
# if mid < right, right is sorted, if left < mid, left half is sorted

class Solution:
    def findMin(self, nums: List[int]) -> int:
        l = 0
        r = len(nums)-1
        
        while(l<r):
            mid = l + (r-l)//2
            if(nums[mid]<nums[r]):
                r = mid
            else:
                l = mid+1
                
        return nums[l]        