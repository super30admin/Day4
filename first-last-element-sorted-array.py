# Time Complexity : O(log(n)) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

#Approach:
#1. We will use binary search. This is the iterative solution for binary search.
#2. We use binary search for both the first and last element one by one. For finding the first element, if we find the target at the mid element of the array,
# we compare it with its left neighbor and check that either it should be leftmost element or it should be larger than its left neighbor. 
# If it is so, we return mid, or else we move towards left subarray.
#3. Similarly, to find the last element, we compare the matching target element with its right neighbor, if it's the rightmost element or it is smaller than its
# right neighbor, then it is our last element. If it is so, we return mid, or else we move towards the right subarray.

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        def first(nums, target, start, end):
            if start > end: return -1
            while start <= end:
                mid = start + (end - start) // 2
                if nums[mid] == target:
                    if mid == 0 or nums[mid-1] < target:
                        return mid
                    else: end = mid - 1
                elif nums[mid] < target:
                    start = mid + 1
                else:
                    end = mid - 1
            return -1
        
        def second(nums, target, start, end):
            if start > end: return -1
            while start <= end:
                mid = start + (end - start) // 2
                if nums[mid] == target:
                    if mid == len(nums)-1 or nums[mid+1] > target:
                        return mid
                    else: start = mid + 1
                elif nums[mid] < target:
                    start = mid + 1
                else:
                    end = mid - 1
            return -1
        
        f = first(nums, target, 0, len(nums)-1)
        s = second(nums, target, 0, len(nums)-1)
        return [f,s]
