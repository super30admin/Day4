#The findPeakElement method identifies a peak element in a list using binary search. By initializing low and high pointers, it repeatedly computes the middle index mid. If mid is less than its right neighbor, the search moves right; if less than its left neighbor, it moves left. Otherwise, mid itself is the peak. This process ensures O(log n) time complexity due to the halving of the search space, and O(1) space complexity as it uses minimal extra memory.


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        low, high = 0, n-1
        while low <= high:
            mid = ((high-low)//2) + low
            # Peak element is present in right side
            if mid < n-1 and nums[mid] < nums[mid+1]:
                low = mid+1
            # Peak element is present in left side
            elif mid > 0 and nums[mid] < nums[mid-1]:
                high = mid-1
            else:
                return mid