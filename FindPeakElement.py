# Time Complexity : O(log N) Because we are searching in the half array to find peak element
# Space Complexity : O(log N) 
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Below code is doing Binary search on given array.

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        h = len(nums)-1
        l = 0

        while l<=h:
            mid = l + (h-l)//2
            # Check if mid is the peak
            if ((mid == 0 or nums[mid]>nums[mid-1]) and (mid == h or nums[mid]>nums[mid+1])):
                return mid
            # If mid is not peak, check whether right element of mid is greater.Greater side from min will definately have peak element.
            elif nums[mid]<nums[mid+1]:
                l=mid+1
            # If right element is not greater than mid, left will def be greater and adjust high index
            else:
                h=mid-1
        # Peak will be found in while loop, hence return garbage for this class int he end  
        return 55555
        
        

# data = [1,5,3,6,4,2]
data = [1,2]
obj = Solution()
peak = obj.findPeakElement(data)
print("Peak: ", peak)