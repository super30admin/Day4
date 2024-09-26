"""
Approach 1: linear search - O(n)
Approach 2: Binary search - O(logn) - Binary search can work as long as we have some rule to divide the search space in the halves. 
It doesn't have to be sorted array. It is misconception that we always need a sorted array,
but rather we just need some rule to decide when does low = mid+1 or high = mid - the KEY to solve this problem is - we can return ANY peak, not the highest Peak.
"""
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return -1
        l, h = 0, len(nums) - 1
        while l <= h:
            mid = l + (h-l) // 2
            if ((mid ==0 or nums[mid] > nums[mid-1]) and
               (mid == len(nums)-1 or nums[mid] > nums[mid+1])):
                    return mid
            elif mid > 0 and nums[mid-1] > nums[mid]:
            # elif mid < len(nums)-1 and nums[mid] < nums[mid+1]:
                h = mid - 1 
                # l = mid +1
            else:
                l = mid + 1
                # h = mid - 1 
        return -1