'''Find Minimum in Rotated Sorted Array'''
# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : N/A
# Leetcode Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array

'''
For a rotated array: the minimum element would be in it
- Compare subarrays [l, mid] and [mid, r], which subarray is unrotated and continue there

For an unrotated array: the minimum element would be the leftmost one
'''
# // Your code here along with comments explaining your approach
def findMin(self, nums: List[int]) -> int:
    l, r = 0, len(nums)-1
    while l <= r:
        if nums[l] == nums[r]:
            return nums[l]
        
        # For Minimum element, its left and right elements are greater 
        mid = (l+r)//2
        print(mid)
        # Rotated Array
        if nums[l] > nums[r]:
            
            # Minimum is in the rotated subarray
            if nums[l] <= nums[mid]:
                l = mid+1
            else:
                r = mid
        else:
            # Minimum is the leftmost element of the subarray
            return nums[l]       