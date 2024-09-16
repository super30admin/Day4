# Time Complexity : O(logn)
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low, high = 0, len(nums)-1
        # if already sorted or contains one element then first element is the smallest element
        if nums[low] < nums[high] or len(nums) == 1:
            return nums[low]
        # iterative binary search
        while low <= high:
            mid = low + int((high - low)/2)
            # as soon as we come across a mid element which is smaller than its previous element which means its the pivot point and hence the smallest element as the array is sorted
            if nums[mid] < nums [mid-1]:
                return nums[mid]
            # if for any mid element the next element is smaller then same as above
            elif nums[mid+1] < nums[mid]:
                return nums[mid+1]
            # if the mid is bigger than first element of the array which means left subarray is sorted and we need to look at the second part or right subarray
            elif nums[0] < nums[mid]:
                low = mid + 1
            # if the mid is smaller than the first element that means right array is sorted and we need to search in the left subarray
            else:
                high = mid - 1
            