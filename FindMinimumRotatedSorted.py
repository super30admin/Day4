class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # Time complexity is O(logn)
        # Space complexity is O(1)
        # Base condition is when mid is greater than both its left and right elements.
        # Otherwise check if high is less than mid then move towards right
        # Otherwise move towards left
        low = 0
        high = len(nums)-1
        while(low <= high):
            mid = (low+high)//2
            if((mid == high or nums[mid] < nums[mid+1]) and (mid == low or nums[mid] < nums[mid-1])):
                return nums[mid]
            elif(nums[high] < nums[mid]):
                low = mid+1
            else:
                high = mid-1
        return -1