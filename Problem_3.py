'''Find Peak Element'''
# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : N/A
# Leetcode Link: https://leetcode.com/problems/find-peak-element/

'''
# Key Insight: we only need to compare nums[mid] > nums[mid+1] as for all three cases (ascending, descending, peak)
If the mid is on an ascending slope (nums[mid] < nums[mid+1]), the peak element is in the right subarray
If the mid is on a descending slope (nums[mid] > nums[mid+1]), the peak is in the left subarray
The boundary elements may always be peaks
'''
# // Your code here along with comments explaining your approach
def findPeakElement(self, nums: List[int]) -> int:    
    l, r = 0, len(nums)-1
    while l < r:
        mid = (l+r)//2
        if nums[mid] > nums[mid+1]:
            r = mid
        else:
            l = mid+1
    return l