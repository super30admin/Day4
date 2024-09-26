'''Find First and Last Position of Element in Sorted Array'''
# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : N/A
# Leetcode Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

'''
Modify the usual binary search for two seperate use cases
To find leftmost occurence: 
- Binary search to find the target in the sorted array
- If current element is less than target, move to the right subarray
- If current element is less than or equal to target
    * If elem is target: Update found_idx with current idx
    Keep searching a lower boundary, in the left subarray

Similarly, implement the conditions for the rightmost occurence
'''
def searchRange(self, nums: List[int], target: int) -> List[int]:
    
    # Binary Search to find the leftmost occurence
    def bin_bisect_left(): 
        ans = -1
        l, r = 0, len(nums)-1
        while l <= r:
            mid = (l+r)//2
            if nums[mid] < target:
                l = mid+1
            else:
                if nums[mid] == target:
                    ans = mid
                r = mid-1
        return ans 
    
    # Binary Search to find the rightmost occurence
    def bin_bisect_right(): 
        ans = -1
        l, r = 0, len(nums)-1
        while l <= r:
            mid = (l+r)//2
            if nums[mid] > target:
                r = mid-1
            else:
                if nums[mid] == target:
                    ans = mid
                l = mid+1
        return ans 
    
    return [bin_bisect_left(), bin_bisect_right()]
        