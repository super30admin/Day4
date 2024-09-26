#Time Complexity: O(logn)
#Space Complexity: O(1)
#Did this code successfully run on leetcode: yes
#Any problem you faced while coding thing:
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        #idea : if we always go up until all the elements around are smaller (no where to go up then), it's a peak
        #since it's any peak it doesn't matter if it's a valley, we just go up any side
        # it is binary search because we're getting rid of half of the search space every iteration
        #if it's greater on the right, move low to mid+1, vice-versa
        low=0
        high=len(nums)-1
        while high>=low:
            mid=int(low+(high-low)/2) #to avoid overflow
            if (mid==0 or nums[mid-1]<nums[mid]) and (mid==len(nums)-1 or nums[mid+1]<nums[mid]):
                return mid
            if (nums[mid+1]>=nums[mid]):
                low=mid+1
            else:
                high=mid-1

  #!! check lecture to make sure
